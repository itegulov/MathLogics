package formalarithmetic.deductor;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import exceptions.DenialReason;
import exceptions.InvalidProofException;
import formalarithmetic.validator.HashValidator;
import formalarithmetic.validator.Validator;
import parser.ArithmeticParser;
import parser.ParseException;
import proof.*;
import rules.ExistsRule;
import rules.ForAllRule;
import scanner.FastLineScanner;
import structure.Expression;
import structure.logic.Entailment;
import structure.predicate.Exists;
import structure.predicate.ForAll;
import structure.predicate.Term;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class HashDeductor implements Deductor {
    //TODO: optimize
    private boolean containsStatement(@NotNull final Statement[] proofed, @NotNull final Statement statement) {
        if (proofed == null) {
            return false;
        }
        for (Statement allow : proofed) {
            if (allow.equals(statement)) {
                return true;
            }
        }
        return false;
    }

    private Expression getHypoExp(Term variable, Statement[] assumptions) {
        for (Statement assumption : assumptions) {
            if (assumption.getExp().getFreeVars().contains(variable.getName())) {
                return assumption.getExp();
            }
        }
        return null;
    }

    @Override
    public Proof deduct(@NotNull File f, @Nullable Statement[] proofed) throws FileNotFoundException, ParseException, InvalidProofException {
        FastLineScanner scanner = new FastLineScanner(f);
        ArithmeticParser parser = new ArithmeticParser();

        String assumptionsStatement = scanner.next();
        String[] parts = assumptionsStatement.split("\\|\\-", 2);
        String[] assumptionStrings = parts[0].split(",");
        final Statement[] assumptions = new Statement[assumptionStrings.length];
        for (int i = 0; i < assumptionStrings.length; i++) {
            assumptions[i] = new Statement(parser.parse(assumptionStrings[i]), new Assumption(), 0);
        }
        Validator validator = new HashValidator();
        Proof proof = validator.validate(scanner, assumptions);
        return deduct(proof, assumptions, proofed);
    }

    @Override
    public Proof deduct(@NotNull Proof proof, @NotNull Statement[] assumptions, @Nullable Statement[] proofed) throws ParseException, InvalidProofException {
        Validator validator = new HashValidator();
        Statement[] all;
        if (proofed != null) {
            all = new Statement[assumptions.length + proofed.length];
            System.arraycopy(assumptions, 0, all, 0, assumptions.length);
            System.arraycopy(proofed, 0, all, assumptions.length, proofed.length);
        } else {
            all = new Statement[assumptions.length];
            System.arraycopy(assumptions, 0, all, 0, assumptions.length);
            proof = validator.validate(proof, assumptions);
        }
        proof = validator.validate(proof, all);
        ArithmeticParser parser = new ArithmeticParser();
        Map<String, Expression> proofedMap = new HashMap<>();
        for (int i = assumptions.length - 1; i < assumptions.length; i++) {
            Statement assumption = assumptions[i];
            Expression currentAssumption = assumption.getExp();
            Set<String> hyposVars = new HashSet<>();
            hyposVars.addAll(assumption.getExp().getFreeVars());
            Proof newProof = new Proof();
            int line = 0;
            for (Statement statement : proof.getStatements()) {
                line++;
                if (line % 100 == 0) {
                    System.out.println("Line: " + line);
                }
                Expression currentExp = statement.getExp();
                StatementType statementType = statement.getType();
                if (statement.getExp().equals(currentAssumption)) {
                    newProof.addExpression(parser.parse("(1)->(1)->(1)".replaceAll("1", currentExp.toString())), null);
                    newProof.addExpression(parser.parse("((1)->((1)->(1)))->((1)->(((1)->(1))->(1)))->((1)->(1))".replaceAll("1", currentExp.toString())), null);
                    newProof.addExpression(parser.parse("((1)->(((1)->(1))->1))->((1)->(1))".replaceAll("1", currentExp.toString())), null);
                    newProof.addExpression(parser.parse("((1)->(((1)->(1))->(1)))".replaceAll("1", currentExp.toString())), null);
                    newProof.addExpression(parser.parse("(1)->(1)".replaceAll("1", currentExp.toString())), null);
                } else if (statementType.getClass() == Axiom.class
                        || containsStatement(assumptions, statement)
                        || containsStatement(proofed, statement)) {
                    newProof.addExpression(currentExp, null);
                    newProof.addExpression(new Entailment(currentExp, new Entailment(currentAssumption, currentExp)), null);
                    Expression expression = new Entailment(currentAssumption, currentExp);
                    newProof.addExpression(expression, null);
                } else if (statementType.getClass() == ModusPonens.class) {
                    Statement antecedent = ((ModusPonens) statementType).getFirst();
                    Expression expression = parser.parse("((1)->(2))->(((1)->((2)->(3)))->((1)->(3)))"
                            .replaceAll("1", currentAssumption.toString())
                            .replaceAll("2", antecedent.getExp().toString())
                            .replaceAll("3", currentExp.toString()));
                    newProof.addExpression(expression, null);
                    expression = parser.parse("(((1)->((2)->(3)))->((1)->(3)))"
                            .replaceAll("1", currentAssumption.toString())
                            .replaceAll("2", antecedent.getExp().toString())
                            .replaceAll("3", currentExp.toString()));
                    newProof.addExpression(expression, null);
                    expression = parser.parse("(1)->(3)"
                            .replaceAll("1", currentAssumption.toString())
                            .replaceAll("3", currentExp.toString()));
                    newProof.addExpression(expression, null);
                } else if (statementType.getClass() == PredicateAxiom.class) {
                    Expression expr = statement.getExp();
                    Term var;
                    Entailment entailment = (Entailment) expr;
                    if (entailment.getRight() instanceof Exists) {
                        var = ((Exists) entailment.getRight()).getVariable();
                    } else if (entailment.getLeft() instanceof ForAll) {
                        var = ((ForAll) entailment.getLeft()).getVariable();
                    } else {
                        throw new IllegalStateException("Illegal predicate axiom");
                    }
                    if (hyposVars.contains(var.getName())) {
                        throw new InvalidProofException(
                            DenialReason.ERROR_4.create(line, var.getName(), getHypoExp(var, assumptions).toString(), expr.toString())
                        );
                    }
                    newProof.addExpression(currentExp, null);
                    newProof.addExpression(new Entailment(currentExp, new Entailment(currentAssumption, currentExp)), null);
                    Expression expression = new Entailment(currentAssumption, currentExp);
                    newProof.addExpression(expression, null);
                } else if (statementType.getClass() == ArithmeticAxiom.class) {
                    newProof.addExpression(currentExp, null);
                    newProof.addExpression(new Entailment(currentExp, new Entailment(currentAssumption, currentExp)), null);
                    Expression expression = new Entailment(currentAssumption, currentExp);
                    newProof.addExpression(expression, null);
                } else if (statementType.getClass() == InductionRule.class) {
                    newProof.addExpression(currentExp, null);
                    newProof.addExpression(new Entailment(currentExp, new Entailment(currentAssumption, currentExp)), null);
                    Expression expression = new Entailment(currentAssumption, currentExp);
                    newProof.addExpression(expression, null);
                } else {
                    if (statementType.getClass() == ExistsDerivationRule.class) {
                        if (currentExp instanceof Entailment &&
                                ((Entailment) currentExp).getLeft() instanceof Exists) {
                            Entailment entailment = (Entailment) currentExp;
                            Exists exists = (Exists) entailment.getLeft();
                            Expression prev = proofedMap.get(
                                    new Entailment(
                                            exists.getExp(),
                                            entailment.getRight()
                                    ).toString());
                            Term var = exists.getVariable();
                            boolean cond = (prev != null);
                            if (cond) {
                                cond = !((Entailment) prev).getRight().getFreeVars().contains(var.getName());
                                if (!cond) {
                                    throw new InvalidProofException(
                                            DenialReason.ERROR_2.create(line, var.getName(), entailment.getRight().toString())
                                    );
                                }
                                cond = !hyposVars.contains(var.getName());
                                if (!cond) {
                                    throw new InvalidProofException(
                                            DenialReason.ERROR_3.create(line, "правило", var.getName(), getHypoExp(var, assumptions).toString(), prev.toString(), currentExp.toString())
                                    );
                                }
                                for (ExistsRule rule : ExistsRule.values()) {
                                    newProof.addExpression(rule.replace(currentAssumption,
                                            exists.getExp(),
                                            entailment.getRight(), var), null);
                                }
                            }
                        } else {
                            throw new IllegalStateException("Illegal exists derivation rule");
                        }
                    } else if (statementType.getClass() == ForAllDerivationRule.class) {
                        if (currentExp instanceof Entailment &&
                                ((Entailment) currentExp).getRight() instanceof ForAll) {
                            Expression prev = proofedMap.get(
                                    new Entailment(
                                            ((Entailment) currentExp).getLeft(),
                                            ((ForAll) ((Entailment) currentExp).getRight()).getExp()
                                    ).toString());
                            Term var = ((ForAll) ((Entailment) currentExp).getRight()).getVariable();
                            boolean cond = (prev != null);
                            if (cond) {
                                cond = !((Entailment) prev).getLeft().getFreeVars().contains(var.getName());
                                if (!cond) {
                                    throw new InvalidProofException(
                                            DenialReason.ERROR_2.create(line, var.getName(), ((Entailment) currentExp).getLeft().toString())
                                    );
                                }
                                cond = !hyposVars.contains(var.getName());
                                if (!cond) {
                                    throw new InvalidProofException(
                                            DenialReason.ERROR_3.create(line, "правило", var.getName(), getHypoExp(var, assumptions).toString(), prev.toString(), currentExp.toString())
                                    );
                                }
                                for (ForAllRule rule : ForAllRule.values()) {
                                    newProof.addExpression(rule.replace(currentAssumption,
                                            ((Entailment) currentExp).getLeft(),
                                            ((ForAll) ((Entailment) currentExp).getRight()).getExp(), var), null);
                                }
                            }
                        } else {
                            throw new IllegalStateException("Illegal for all derivation rule");
                        }
                    }
                }
                proofedMap.put(currentExp.toString(), currentExp);
            }
            proof = validator.validate(newProof, all);
            proof.check(proofed);
        }
        return proof;
    }
}
