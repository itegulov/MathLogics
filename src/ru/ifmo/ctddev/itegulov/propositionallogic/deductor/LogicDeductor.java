package ru.ifmo.ctddev.itegulov.propositionallogic.deductor;

import ru.ifmo.ctddev.itegulov.interfaces.AbstractDeductor;
import ru.ifmo.ctddev.itegulov.interfaces.Parser;
import ru.ifmo.ctddev.itegulov.interfaces.Validator;
import ru.ifmo.ctddev.itegulov.proof.LogicalProof;
import ru.ifmo.ctddev.itegulov.proof.Proof;
import ru.ifmo.ctddev.itegulov.proof.Statement;
import ru.ifmo.ctddev.itegulov.propositionallogic.parser.LogicParser;
import ru.ifmo.ctddev.itegulov.propositionallogic.validator.LogicValidator;
import ru.ifmo.ctddev.itegulov.structure.LogicExpression;

import java.util.List;

public final class LogicDeductor extends AbstractDeductor<LogicExpression> {
    //TODO: javadoc
    private static LogicDeductor ourInstance = new LogicDeductor();

    //No instances for you
    private LogicDeductor() {
    }

    public static LogicDeductor getInstance() {
        return ourInstance;
    }


    @Override
    protected Parser<LogicExpression> getParser() {
        return LogicParser.getInstance();
    }

    @Override
    protected Validator<LogicExpression> getValidator() {
        return LogicValidator.getInstance();
    }

    @Override
    protected Proof<LogicExpression> createProof(final List<Statement<LogicExpression>> assumptions) {
        return new LogicalProof(assumptions);
    }
}
