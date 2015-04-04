package ru.ifmo.ctddev.itegulov.formalarithmetic.deductor;

import ru.ifmo.ctddev.itegulov.exceptions.InvalidProofException;
import ru.ifmo.ctddev.itegulov.formalarithmetic.validator.BasicValidator;
import ru.ifmo.ctddev.itegulov.interfaces.Deductor;
import ru.ifmo.ctddev.itegulov.interfaces.Validator;
import ru.ifmo.ctddev.itegulov.formalarithmetic.parser.FormalArithmeticParser;
import ru.ifmo.ctddev.itegulov.exceptions.ParseException;
import ru.ifmo.ctddev.itegulov.proof.Assumption;
import ru.ifmo.ctddev.itegulov.proof.FormalArithmeticProof;
import ru.ifmo.ctddev.itegulov.proof.Proof;
import ru.ifmo.ctddev.itegulov.proof.Statement;
import ru.ifmo.ctddev.itegulov.scanner.FastLineScanner;
import ru.ifmo.ctddev.itegulov.structure.FormalArithmeticExpression;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class BasicDeductor implements Deductor<FormalArithmeticExpression> {
    //TODO: javadoc
    private static BasicDeductor ourInstance = new BasicDeductor();

    //No instances for you
    private BasicDeductor() {
    }

    public static BasicDeductor getInstance() {
        return ourInstance;
    }

    //TODO: optimize

    @Override
    public Proof<FormalArithmeticExpression> deductAll(final File f, final List<Statement<FormalArithmeticExpression>> proofed)
            throws FileNotFoundException, InvalidProofException {
        FastLineScanner scanner = new FastLineScanner(f);
        FormalArithmeticParser parser = FormalArithmeticParser.getInstance();

        String assumptionsStatement = scanner.next();
        String[] parts = assumptionsStatement.split("\\|\\-", 2);
        String[] assumptionStrings = parts[0].split(",");
        final List<Statement<FormalArithmeticExpression>> assumptions = new ArrayList<>(assumptionStrings.length);
        for (String assumptionString : assumptionStrings) {
            try {
                assumptions.add(new Statement<>(parser.parse(assumptionString), new Assumption(), 0));
            } catch (ParseException e) {
                throw new InvalidProofException("Couldn't parse assumption");
            }
        }
        Validator<FormalArithmeticExpression> validator = BasicValidator.getInstance();
        Proof<FormalArithmeticExpression> proof;
        proof = validator.validate(scanner, assumptions);
        return deductAll(proof, assumptions, proofed);
    }

    @Override
    public Proof<FormalArithmeticExpression> deductAll(Proof<FormalArithmeticExpression> proof,
                                                       List<Statement<FormalArithmeticExpression>> assumptions,
                                                       List<Statement<FormalArithmeticExpression>> proofed)
            throws InvalidProofException {
        Validator<FormalArithmeticExpression> validator = BasicValidator.getInstance();
        List<Statement<FormalArithmeticExpression>> all;
        if (proofed != null) {
            all = new ArrayList<>();
            all.addAll(assumptions);
            all.addAll(proofed);
        } else {
            all = new ArrayList<>(assumptions.size());
            all.addAll(assumptions);
            proof = validator.validate(proof, assumptions);
        }
        proof = validator.validate(proof, all);
        for (int i = 0; i < assumptions.size(); i++) {
            FormalArithmeticExpression currentAssumption = assumptions.get(i).getExp();
            Proof<FormalArithmeticExpression> newProof = new FormalArithmeticProof(assumptions);
            int line = 0;
            for (Statement<FormalArithmeticExpression> statement : proof.getStatements()) {
                line++;
                if (line % 100 == 0) {
                    System.out.println("Line: " + line);
                }
                proof.deduct(statement, newProof, currentAssumption, proofed);
            }
            proof = validator.validate(newProof, all);
            proof.check(proofed);
        }
        return proof;
    }

    @Override
    public Proof<FormalArithmeticExpression> deductLast(final File file, final List<Statement<FormalArithmeticExpression>> proofed) throws FileNotFoundException, InvalidProofException {
        FastLineScanner scanner = new FastLineScanner(file);
        FormalArithmeticParser parser = FormalArithmeticParser.getInstance();

        String assumptionsStatement = scanner.next();
        String[] parts = assumptionsStatement.split("\\|\\-", 2);
        String[] assumptionStrings = parts[0].split(",");
        final List<Statement<FormalArithmeticExpression>> assumptions = new ArrayList<>(assumptionStrings.length);
        for (String assumptionString : assumptionStrings) {
            try {
                assumptions.add(new Statement<>(parser.parse(assumptionString), new Assumption(), 0));
            } catch (ParseException e) {
                throw new InvalidProofException("Couldn't parse assumption");
            }
        }
        Validator<FormalArithmeticExpression> validator = BasicValidator.getInstance();
        Proof<FormalArithmeticExpression> proof;
        proof = validator.validate(scanner, assumptions);
        return deductLast(proof, assumptions, proofed);
    }

    @Override
    public Proof<FormalArithmeticExpression> deductLast(Proof<FormalArithmeticExpression> proof,
                                                        final List<Statement<FormalArithmeticExpression>> assumptions,
                                                        final List<Statement<FormalArithmeticExpression>> proofed)
            throws InvalidProofException {
        Validator<FormalArithmeticExpression> validator = BasicValidator.getInstance();
        List<Statement<FormalArithmeticExpression>> all;
        if (proofed != null) {
            all = new ArrayList<>();
            all.addAll(assumptions);
            all.addAll(proofed);
        } else {
            all = new ArrayList<>(assumptions.size());
            all.addAll(assumptions);
            proof = validator.validate(proof, assumptions);
        }
        proof = validator.validate(proof, all);
        FormalArithmeticExpression currentAssumption = assumptions.get(assumptions.size() - 1).getExp();
        Proof<FormalArithmeticExpression> newProof = new FormalArithmeticProof(assumptions);
        int line = 0;
        for (Statement<FormalArithmeticExpression> statement : proof.getStatements()) {
            line++;
            if (line % 100 == 0) {
                System.out.println("Line: " + line);
            }
            proof.deduct(statement, newProof, currentAssumption, proofed);
        }
        proof = validator.validate(newProof, all);
        proof.check(proofed);
        return proof;
    }
}
