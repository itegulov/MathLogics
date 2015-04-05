package ru.ifmo.ctddev.itegulov.mathlogic.propositionallogic.validator;

import ru.ifmo.ctddev.itegulov.mathlogic.interfaces.AbstractValidator;
import ru.ifmo.ctddev.itegulov.mathlogic.interfaces.Parser;
import ru.ifmo.ctddev.itegulov.mathlogic.interfaces.Validator;
import ru.ifmo.ctddev.itegulov.mathlogic.proof.LogicalProof;
import ru.ifmo.ctddev.itegulov.mathlogic.proof.Proof;
import ru.ifmo.ctddev.itegulov.mathlogic.proof.Statement;
import ru.ifmo.ctddev.itegulov.mathlogic.propositionallogic.parser.LogicParser;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.LogicExpression;

import java.util.List;
import java.util.Map;

/**
 * Basic implementation of {@link Validator} for {@link LogicExpression}.
 * Works using provided @{link Proof} method {@link ru.ifmo.ctddev.itegulov.mathlogic.proof.Proof#findBasis(Statement, Map)}.
 */
public final class LogicValidator extends AbstractValidator<LogicExpression> {
    private static LogicValidator ourInstance = new LogicValidator();

    //No instances for you
    private LogicValidator() {
    }

    public static LogicValidator getInstance() {
        return ourInstance;
    }

    @Override
    protected Parser<LogicExpression> getParser() {
        return LogicParser.getInstance();
    }

    @Override
    protected Proof<LogicExpression> createProof(final List<Statement<LogicExpression>> assumptions) {
        return new LogicalProof(assumptions);
    }
}