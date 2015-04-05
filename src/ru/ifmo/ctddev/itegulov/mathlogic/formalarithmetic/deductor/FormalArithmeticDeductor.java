package ru.ifmo.ctddev.itegulov.mathlogic.formalarithmetic.deductor;

import ru.ifmo.ctddev.itegulov.mathlogic.formalarithmetic.parser.FormalArithmeticParser;
import ru.ifmo.ctddev.itegulov.mathlogic.formalarithmetic.validator.FormalArithmeticValidator;
import ru.ifmo.ctddev.itegulov.mathlogic.interfaces.AbstractDeductor;
import ru.ifmo.ctddev.itegulov.mathlogic.interfaces.Parser;
import ru.ifmo.ctddev.itegulov.mathlogic.interfaces.Validator;
import ru.ifmo.ctddev.itegulov.mathlogic.proof.FormalArithmeticProof;
import ru.ifmo.ctddev.itegulov.mathlogic.proof.Proof;
import ru.ifmo.ctddev.itegulov.mathlogic.proof.Statement;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.FormalArithmeticExpression;

import java.util.List;

public final class FormalArithmeticDeductor extends AbstractDeductor<FormalArithmeticExpression> {
    //TODO: javadoc
    private static FormalArithmeticDeductor ourInstance = new FormalArithmeticDeductor();

    //No instances for you
    private FormalArithmeticDeductor() {
    }

    public static FormalArithmeticDeductor getInstance() {
        return ourInstance;
    }

    @Override
    protected Parser<FormalArithmeticExpression> getParser() {
        return FormalArithmeticParser.getInstance();
    }

    @Override
    protected Validator<FormalArithmeticExpression> getValidator() {
        return FormalArithmeticValidator.getInstance();
    }

    @Override
    protected Proof<FormalArithmeticExpression> createProof(final List<Statement<FormalArithmeticExpression>> assumptions) {
        return new FormalArithmeticProof(assumptions);
    }
}
