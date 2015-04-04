package ru.ifmo.ctddev.itegulov.propositionallogic.validator;

import ru.ifmo.ctddev.itegulov.interfaces.AbstractValidator;
import ru.ifmo.ctddev.itegulov.interfaces.Parser;
import ru.ifmo.ctddev.itegulov.interfaces.Validator;
import ru.ifmo.ctddev.itegulov.proof.LogicalProof;
import ru.ifmo.ctddev.itegulov.proof.Proof;
import ru.ifmo.ctddev.itegulov.proof.Statement;
import ru.ifmo.ctddev.itegulov.propositionallogic.parser.LogicParser;
import ru.ifmo.ctddev.itegulov.structure.LogicExpression;

import java.util.List;
import java.util.Map;

/**
 * Basic implementation of {@link Validator} for {@link LogicExpression}.
 * Works using provided @{link Proof} method {@link ru.ifmo.ctddev.itegulov.proof.Proof#findBasis(Statement, Map)}.
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