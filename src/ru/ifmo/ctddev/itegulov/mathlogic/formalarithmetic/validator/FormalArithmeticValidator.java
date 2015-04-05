package ru.ifmo.ctddev.itegulov.mathlogic.formalarithmetic.validator;

import ru.ifmo.ctddev.itegulov.mathlogic.formalarithmetic.parser.FormalArithmeticParser;
import ru.ifmo.ctddev.itegulov.mathlogic.interfaces.AbstractValidator;
import ru.ifmo.ctddev.itegulov.mathlogic.interfaces.Parser;
import ru.ifmo.ctddev.itegulov.mathlogic.proof.FormalArithmeticProof;
import ru.ifmo.ctddev.itegulov.mathlogic.proof.Proof;
import ru.ifmo.ctddev.itegulov.mathlogic.proof.Statement;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.FormalArithmeticExpression;

import java.util.List;

public final class FormalArithmeticValidator extends AbstractValidator<FormalArithmeticExpression> {
    //TODO: javadoc
    private static FormalArithmeticValidator ourInstance = new FormalArithmeticValidator();

    //No instances for you
    private FormalArithmeticValidator() {
    }

    public static FormalArithmeticValidator getInstance() {
        return ourInstance;
    }

    @Override
    protected Parser<FormalArithmeticExpression> getParser() {
        return FormalArithmeticParser.getInstance();
    }

    @Override
    protected Proof<FormalArithmeticExpression> createProof(final List<Statement<FormalArithmeticExpression>> assumptions) {
        return new FormalArithmeticProof(assumptions);
    }
}
