package formalarithmetic.deductor;

import exceptions.DenialReason;
import exceptions.InvalidProofException;
import formalarithmetic.validator.HashValidator;
import interfaces.Deductor;
import interfaces.Validator;
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
import java.util.HashSet;
import java.util.Set;

public class HashDeductor implements Deductor {
    //TODO: optimize
    private boolean containsStatement(final Statement[] proofed, final Statement statement) {
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
    public Proof deduct(File f, Statement[] proofed) throws FileNotFoundException, ParseException, InvalidProofException {
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
        Proof proof;
        proof = validator.validate(scanner, assumptions);
        return deduct(proof, assumptions, proofed);
    }

    @Override
    public Proof deduct(Proof proof, Statement[] assumptions, Statement[] proofed) throws ParseException, InvalidProofException {
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
                    newProof.addExpression(new Entailment(currentExp, new Entailment(currentExp, currentExp)), Axiom.AxiomOne);
                    newProof.addExpression(new Entailment(
                            new Entailment(
                                    currentExp,
                                    new Entailment(currentExp, currentExp)
                            ),
                            new Entailment(
                                    new Entailment(
                                            currentExp,
                                            new Entailment(
                                                    new Entailment(currentExp, currentExp),
                                                    currentExp
                                            )
                                    ),
                                    new Entailment(currentExp, currentExp)
                            )
                    ), Axiom.AxiomTwo);
                    newProof.addExpression(new Entailment(
                            new Entailment(
                                    currentExp,
                                    new Entailment(
                                            new Entailment(currentExp, currentExp),
                                            currentExp
                                    )
                            ),
                            new Entailment(currentExp, currentExp)
                    ), null);
                    newProof.addExpression(new Entailment(
                            currentExp,
                            new Entailment(
                                    new Entailment(currentExp, currentExp),
                                    currentExp
                            )
                    ), Axiom.AxiomOne);
                    newProof.addExpression(new Entailment(currentExp, currentExp), null);
                } else if (statementType.getClass() == Axiom.class
                        || containsStatement(assumptions, statement)
                        || containsStatement(proofed, statement)) {
                    newProof.addExpression(currentExp, null);
                    newProof.addExpression(new Entailment(currentExp, new Entailment(currentAssumption, currentExp)), null);
                    Expression expression = new Entailment(currentAssumption, currentExp);
                    newProof.addExpression(expression, null);
                } else if (statementType.getClass() == ModusPonens.class) {
                    Statement antecedent = ((ModusPonens) statementType).getFirst();
                    Expression expression = new Entailment(
                            new Entailment(currentAssumption, antecedent.getExp()),
                            new Entailment(
                                    new Entailment(
                                            currentAssumption,
                                            new Entailment(
                                                    antecedent.getExp(),
                                                    currentExp
                                            )
                                    ),
                                    new Entailment(
                                            currentAssumption,
                                            currentExp
                                    )
                            )
                    );
                    newProof.addExpression(expression, null);
                    expression = new Entailment(
                            new Entailment(
                                    currentAssumption,
                                    new Entailment(
                                            antecedent.getExp(),
                                            currentExp
                                    )
                            ),
                            new Entailment(
                                    currentAssumption,
                                    currentExp
                            )
                    );
                    newProof.addExpression(expression, null);
                    expression = new Entailment(currentAssumption, currentExp);
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
                    /*
                    if (hyposVars.contains(var.getName())) {
                        throw new InvalidProofException(
                            DenialReason.ERROR_3.create(line, "схема аксиом", var.getName(), getHypoExp(var, assumptions).toString())
                        );
                    }
                    */
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
                            Expression prev = proof.getAll(
                                    new Entailment(
                                            exists.getExp(),
                                            entailment.getRight()
                                    )).getExp();
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
                                            DenialReason.ERROR_3.create(line, "правило", var.getName(), getHypoExp(var, assumptions).toString())
                                    );
                                }
                                ExistsRule.addExistsProof1(currentAssumption,
                                        exists.getExp(),
                                        entailment.getRight(), var, newProof);
                                ExistsRule.addExistsProof2(currentAssumption,
                                        exists.getExp(),
                                        entailment.getRight(), var, newProof);
                                ExistsRule.addExistsProof3(currentAssumption,
                                        exists.getExp(),
                                        entailment.getRight(), var, newProof);
                            }
                        } else {
                            throw new IllegalStateException("Illegal exists derivation rule");
                        }
                    } else if (statementType.getClass() == ForAllDerivationRule.class) {
                        if (currentExp instanceof Entailment &&
                                ((Entailment) currentExp).getRight() instanceof ForAll) {
                            Expression prev = proof.getAll(
                                    new Entailment(
                                            ((Entailment) currentExp).getLeft(),
                                            ((ForAll) ((Entailment) currentExp).getRight()).getExp()
                                    )).getExp();
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
                                            DenialReason.ERROR_3.create(line, "правило", var.getName(), getHypoExp(var, assumptions).toString())
                                    );
                                }
                                ForAllRule.addForAllProof(currentAssumption,
                                        ((Entailment) currentExp).getLeft(),
                                        ((ForAll) ((Entailment) currentExp).getRight()).getExp(),
                                        var, newProof);
                            }
                        } else {
                            throw new IllegalStateException("Illegal for all derivation rule");
                        }
                    }
                }
            }
            proof = validator.validate(newProof, all);
            proof.check(proofed);
        }
        return proof;
    }
}
