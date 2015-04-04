package ru.ifmo.ctddev.itegulov.formalarithmetic.validator;

import ru.ifmo.ctddev.itegulov.formalarithmetic.parser.FormalArithmeticParser;
import ru.ifmo.ctddev.itegulov.interfaces.AbstractValidator;
import ru.ifmo.ctddev.itegulov.interfaces.Parser;
import ru.ifmo.ctddev.itegulov.proof.FormalArithmeticProof;
import ru.ifmo.ctddev.itegulov.proof.Proof;
import ru.ifmo.ctddev.itegulov.proof.Statement;
import ru.ifmo.ctddev.itegulov.structure.FormalArithmeticExpression;

import java.util.List;

public class FormalArithmeticValidator extends AbstractValidator<FormalArithmeticExpression> {
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
