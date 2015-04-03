package formalarithmetic.deductor;

import exceptions.InvalidProofException;
import formalarithmetic.validator.HashValidator;
import interfaces.Deductor;
import interfaces.Validator;
import parser.ArithmeticParser;
import parser.ParseException;
import proof.Assumption;
import proof.FormalArithmeticProof;
import proof.Proof;
import proof.Statement;
import scanner.FastLineScanner;
import structure.FormalArithmeticExpression;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class HashDeductor implements Deductor<FormalArithmeticExpression> {
    //TODO: javadoc
    private static HashDeductor ourInstance = new HashDeductor();

    //No instances for you
    private HashDeductor() {
    }

    public static HashDeductor getInstance() {
        return ourInstance;
    }

    //TODO: optimize

    @Override
    public Proof<FormalArithmeticExpression> deductAll(final File f, final List<Statement<FormalArithmeticExpression>> proofed)
            throws FileNotFoundException, InvalidProofException {
        FastLineScanner scanner = new FastLineScanner(f);
        ArithmeticParser parser = ArithmeticParser.getInstance();

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
        Validator<FormalArithmeticExpression> validator = HashValidator.getInstance();
        Proof<FormalArithmeticExpression> proof;
        proof = validator.validate(scanner, assumptions);
        return deductAll(proof, assumptions, proofed);
    }

    @Override
    public Proof<FormalArithmeticExpression> deductAll(Proof<FormalArithmeticExpression> proof,
                                                       List<Statement<FormalArithmeticExpression>> assumptions,
                                                       List<Statement<FormalArithmeticExpression>> proofed)
            throws InvalidProofException {
        Validator<FormalArithmeticExpression> validator = HashValidator.getInstance();
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
        ArithmeticParser parser = ArithmeticParser.getInstance();

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
        Validator<FormalArithmeticExpression> validator = HashValidator.getInstance();
        Proof<FormalArithmeticExpression> proof;
        proof = validator.validate(scanner, assumptions);
        return deductLast(proof, assumptions, proofed);
    }

    @Override
    public Proof<FormalArithmeticExpression> deductLast(Proof<FormalArithmeticExpression> proof,
                                                        final List<Statement<FormalArithmeticExpression>> assumptions,
                                                        final List<Statement<FormalArithmeticExpression>> proofed)
            throws InvalidProofException {
        Validator<FormalArithmeticExpression> validator = HashValidator.getInstance();
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
