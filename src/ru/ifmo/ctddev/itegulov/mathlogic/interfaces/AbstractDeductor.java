package ru.ifmo.ctddev.itegulov.mathlogic.interfaces;

import ru.ifmo.ctddev.itegulov.mathlogic.exceptions.InvalidProofException;
import ru.ifmo.ctddev.itegulov.mathlogic.exceptions.ParseException;
import ru.ifmo.ctddev.itegulov.mathlogic.proof.Assumption;
import ru.ifmo.ctddev.itegulov.mathlogic.proof.Proof;
import ru.ifmo.ctddev.itegulov.mathlogic.proof.Statement;
import ru.ifmo.ctddev.itegulov.mathlogic.scanner.FastLineScanner;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.Expression;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Provides basic implementation for {@link Deductor}. Uses
 * {@link Proof#deduct(Statement, Proof, Expression, List)} to
 * do all the work.
 *
 * @author Daniyar Itegulov
 */
public abstract class AbstractDeductor<E extends Expression<E>> implements Deductor<E> {

    /**
     * Get any correct parser, that can parse expressions
     * with type {@code E}.
     *
     * @return parser, that can correctly parse {@code E}
     * type expressions
     */
    abstract protected Parser<E> getParser();

    /**
     * Get any correct validator, that can validate expressions
     * with type {@code E}.
     *
     * @return validator, that can correctly validate {@code E}
     * type expressions
     */
    abstract protected Validator<E> getValidator();

    /**
     * Get any correct proof with specified assumptions, that represent
     * expressions of type {@code E}.
     *
     * @param assumptions list of {@link Statement}, which represent
     *                    assumptions in proof
     * @return proof, containing specified assumptions
     */
    abstract protected Proof<E> createProof(List<Statement<E>> assumptions);

    private static <E extends Expression<E>> Proof<E> prepare(final File file,
                                                              final List<Statement<E>> assumptions,
                                                              final Parser<E> parser,
                                                              final Validator<E> validator)
            throws FileNotFoundException, InvalidProofException {
        FastLineScanner scanner = new FastLineScanner(file);

        String assumptionsStatement = scanner.next();
        String[] parts = assumptionsStatement.split("\\|\\-", 2);
        String left = parts[0];
        int balance = 0;
        int last = 0;
        List<String> as = new ArrayList<>();
        for (int i = 0; i < left.length(); i++) {
            if (left.charAt(i) == ')') {
                balance--;
            } else if (left.charAt(i) == '(') {
                balance++;
            } else if (left.charAt(i) == ',' && balance == 0) {
                as.add(left.substring(last, i));
                last = i + 1;
            }
        }
        as.add(left.substring(last, left.length()));
        String[] assumptionStrings = as.toArray(new String[as.size()]);
        for (String assumptionString : assumptionStrings) {
            try {
                assumptions.add(new Statement<>(parser.parse(assumptionString), new Assumption<>(), 0));
            } catch (ParseException e) {
                throw new InvalidProofException("Couldn't parse assumption");
            }
        }
        return validator.validate(scanner, assumptions);
    }

    private static <T> List<T> combineLists(List<T> list1, List<T> list2) {
        List<T> all;
        if (list1 != null) {
            if (list2 != null) {
                all = new ArrayList<>(list1.size() + list2.size());
                all.addAll(list1);
                all.addAll(list2);
            } else {
                all = new ArrayList<>(list1.size());
                all.addAll(list1);
            }
        } else {
            if (list2 != null) {
                all = new ArrayList<>(list2.size());
                all.addAll(list2);
            } else {
                all = new ArrayList<>();
            }
        }
        return all;
    }

    @Override
    public Proof<E> deductAll(final File file,
                              final List<Statement<E>> proofed)
            throws FileNotFoundException, InvalidProofException {
        List<Statement<E>> assumptions = new ArrayList<>();
        Proof<E> proof = prepare(file, assumptions, getParser(), getValidator());
        return deductAll(proof, assumptions, proofed);
    }

    @Override
    public Proof<E> deductAll(Proof<E> proof,
                              final List<Statement<E>> assumptions,
                              final List<Statement<E>> proofed) throws InvalidProofException {
        Validator<E> validator = getValidator();
        List<Statement<E>> all = combineLists(assumptions, proofed);
        proof = validator.validate(proof, all);
        for (Statement<E> assumption : assumptions) {
            E currentAssumption = assumption.getExp();
            Proof<E> newProof = createProof(all);
            for (Statement<E> statement : proof.getStatements()) {
                proof.deduct(statement, newProof, currentAssumption, proofed);
            }
            proof = validator.validate(newProof, all);
        }
        return proof;
    }

    @Override
    public Proof<E> deductLast(final File file,
                               final List<Statement<E>> proofed) throws FileNotFoundException, InvalidProofException {
        List<Statement<E>> assumptions = new ArrayList<>();
        Proof<E> proof = prepare(file, assumptions, getParser(), getValidator());
        return deductLast(proof, assumptions, proofed);
    }

    @Override
    public Proof<E> deductLast(Proof<E> proof,
                               final List<Statement<E>> assumptions,
                               final List<Statement<E>> proofed) throws InvalidProofException {
        Validator<E> validator = getValidator();
        List<Statement<E>> all = combineLists(assumptions, proofed);
        proof = validator.validate(proof, all);

        E currentAssumption = assumptions.get(assumptions.size() - 1).getExp();
        Proof<E> newProof = createProof(assumptions);
        for (Statement<E> statement : proof.getStatements()) {
            proof.deduct(statement, newProof, currentAssumption, proofed);
        }
        proof = validator.validate(newProof, all);

        return proof;
    }
}
