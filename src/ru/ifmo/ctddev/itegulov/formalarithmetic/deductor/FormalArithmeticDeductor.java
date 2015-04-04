package ru.ifmo.ctddev.itegulov.formalarithmetic.deductor;

import ru.ifmo.ctddev.itegulov.formalarithmetic.parser.FormalArithmeticParser;
import ru.ifmo.ctddev.itegulov.formalarithmetic.validator.FormalArithmeticValidator;
import ru.ifmo.ctddev.itegulov.interfaces.AbstractDeductor;
import ru.ifmo.ctddev.itegulov.interfaces.Parser;
import ru.ifmo.ctddev.itegulov.interfaces.Validator;
import ru.ifmo.ctddev.itegulov.proof.FormalArithmeticProof;
import ru.ifmo.ctddev.itegulov.proof.Proof;
import ru.ifmo.ctddev.itegulov.proof.Statement;
import ru.ifmo.ctddev.itegulov.structure.FormalArithmeticExpression;

import java.util.List;

public class FormalArithmeticDeductor extends AbstractDeductor<FormalArithmeticExpression> {
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
