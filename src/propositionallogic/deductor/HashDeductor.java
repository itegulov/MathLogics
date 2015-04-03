package propositionallogic.deductor;

import exceptions.InvalidProofException;
import interfaces.Deductor;
import interfaces.Validator;
import parser.LogicParser;
import parser.ParseException;
import parser.Parser;
import proof.Assumption;
import proof.LogicalProof;
import proof.Proof;
import proof.Statement;
import propositionallogic.validator.BasicValidator;
import scanner.FastLineScanner;
import structure.LogicExpression;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public final class HashDeductor implements Deductor<LogicExpression> {
    //TODO: javadoc

    @Override
    public Proof<LogicExpression> deductAll(final File f,
                                            final List<Statement<LogicExpression>> proofed)
            throws FileNotFoundException, InvalidProofException {
        FastLineScanner scanner = new FastLineScanner(f);
        Parser<LogicExpression> parser = new LogicParser();

        String assumptionsStatement = scanner.next();
        String[] parts = assumptionsStatement.split("\\|\\-", 2);
        String[] assumptionStrings = parts[0].split(",");
        final List<Statement<LogicExpression>> assumptions = new ArrayList<>(assumptionStrings.length);
        for (String assumptionString : assumptionStrings) {
            try {
                assumptions.add(new Statement<>(parser.parse(assumptionString), new Assumption(), 0));
            } catch (ParseException e) {
                throw new InvalidProofException("Couldn't parse assumption");
            }
        }
        Validator<LogicExpression> validator = new BasicValidator();
        Proof<LogicExpression> proof = validator.validate(scanner, assumptions);
        return deductAll(proof, assumptions, proofed);
    }

    @Override
    public Proof<LogicExpression> deductAll(Proof<LogicExpression> proof,
                                            final List<Statement<LogicExpression>> assumptions,
                                            final List<Statement<LogicExpression>> proofed) throws InvalidProofException {
        Validator<LogicExpression> validator = new BasicValidator();
        List<Statement<LogicExpression>> all;
        if (proofed != null) {
            all = new ArrayList<>(assumptions.size() + proofed.size());
            all.addAll(assumptions);
            all.addAll(proofed);
        } else {
            all = new ArrayList<>(assumptions.size());
            all.addAll(assumptions);
            proof = validator.validate(proof, assumptions);
        }
        proof = validator.validate(proof, all);
        for (Statement<LogicExpression> assumption : assumptions) {
            LogicExpression currentAssumption = assumption.getExp();
            LogicalProof newProof = new LogicalProof(all);
            for (Statement<LogicExpression> statement : proof.getStatements()) {
                proof.deduct(statement, newProof, currentAssumption, proofed);
            }
            proof = validator.validate(newProof, all);
            proof.check(proofed);
        }
        return proof;
    }

    @Override
    public Proof<LogicExpression> deductLast(Proof<LogicExpression> proof,
                                             final List<Statement<LogicExpression>> assumptions,
                                             final List<Statement<LogicExpression>> proofed) throws InvalidProofException {
        Validator<LogicExpression> validator = new BasicValidator();
        List<Statement<LogicExpression>> all;
        if (proofed != null) {
            all = new ArrayList<>(assumptions.size() + proofed.size());
            all.addAll(assumptions);
            all.addAll(proofed);
        } else {
            all = new ArrayList<>(assumptions.size());
            all.addAll(assumptions);
            proof = validator.validate(proof, assumptions);
        }
        proof = validator.validate(proof, all);
        LogicExpression currentAssumption = assumptions.get(assumptions.size() - 1).getExp();
        LogicalProof newProof = new LogicalProof(assumptions);
        for (Statement<LogicExpression> statement : proof.getStatements()) {
            proof.deduct(statement, newProof, currentAssumption, proofed);
        }
        proof = validator.validate(newProof, all);
        proof.check(proofed);
        return proof;
    }
}
