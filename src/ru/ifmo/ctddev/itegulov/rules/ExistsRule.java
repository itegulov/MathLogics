package ru.ifmo.ctddev.itegulov.rules;

import ru.ifmo.ctddev.itegulov.proof.FormalArithmeticProof;
import ru.ifmo.ctddev.itegulov.proof.Proof;
import ru.ifmo.ctddev.itegulov.structure.FormalArithmeticExpression;
import ru.ifmo.ctddev.itegulov.structure.predicate.Exists;
import ru.ifmo.ctddev.itegulov.structure.predicate.Term;
import ru.ifmo.ctddev.itegulov.structure.predicatelogic.PEntailment;

public class ExistsRule {
    public static void addExistsProof1(FormalArithmeticExpression alpha, FormalArithmeticExpression e,
                                       FormalArithmeticExpression e1, Term variable, Proof<FormalArithmeticExpression> proof) {
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(alpha, new PEntailment(e, e1))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(alpha, new PEntailment(e, e1)))
                , new PEntailment(alpha, new PEntailment(e, e1)))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(alpha, new PEntailment(e, e1))))
                , new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(alpha, new PEntailment(e, e1))), new PEntailment(alpha
                , new PEntailment(e, e1)))), new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(alpha, new PEntailment(e
                , e1))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(alpha, new PEntailment(e, e1)))
                , new PEntailment(alpha, new PEntailment(e, e1)))), new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(alpha, new PEntailment(e
                , e1)))), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(alpha, new PEntailment(e, e1)))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(alpha, new PEntailment(e
                , e1)))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(alpha, new PEntailment(e
                , e1)))), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(alpha, new PEntailment(e
                , e1)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(alpha, new PEntailment(e
                , e1))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(alpha, new PEntailment(e, e1)))
                , new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(e, new PEntailment(alpha, new PEntailment(e
                , e1))))), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(alpha, new PEntailment(e
                , e1)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(alpha, new PEntailment(e
                , e1))))), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(alpha, new PEntailment(e
                , e1))))), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(alpha, new PEntailment(e
                , e1)))), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(alpha, new PEntailment(alpha, new PEntailment(e
                , e1)))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(alpha, new PEntailment(alpha, new PEntailment(e
                , e1)))), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(alpha, new PEntailment(alpha, new PEntailment(e
                , e1)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(alpha, new PEntailment(alpha, new PEntailment(e
                , e1))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(alpha, new PEntailment(alpha, new PEntailment(e
                , e1)))), new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(alpha, new PEntailment(alpha
                , new PEntailment(e, e1)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(alpha, new PEntailment(alpha, new PEntailment(e
                , e1)))), new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(alpha, new PEntailment(alpha
                , new PEntailment(e, e1)))))), new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(alpha, new PEntailment(alpha
                , new PEntailment(e, e1)))), new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(alpha, new PEntailment(alpha
                , new PEntailment(e, e1)))))))), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(alpha, new PEntailment(alpha, new PEntailment(e
                , e1)))), new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(alpha, new PEntailment(alpha
                , new PEntailment(e, e1))))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(alpha, new PEntailment(alpha, new PEntailment(e
                , e1))))), new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(alpha, new PEntailment(alpha, new PEntailment(e
                , e1)))), new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(alpha, new PEntailment(alpha
                , new PEntailment(e, e1))))))), new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(alpha, new PEntailment(alpha
                , new PEntailment(e, e1)))))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(alpha, new PEntailment(alpha, new PEntailment(e
                , e1)))), new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(alpha, new PEntailment(alpha
                , new PEntailment(e, e1))))))), new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(alpha, new PEntailment(alpha
                , new PEntailment(e, e1))))))), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(alpha, new PEntailment(alpha
                , new PEntailment(e, e1)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(e, new PEntailment(alpha
                , new PEntailment(e, e1))), new PEntailment(new PEntailment(e
                , new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(alpha, new PEntailment(alpha, new PEntailment(e
                , e1))))), new PEntailment(e, new PEntailment(alpha, new PEntailment(alpha
                , new PEntailment(e, e1)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(e, new PEntailment(alpha
                , new PEntailment(e, e1))), new PEntailment(new PEntailment(e
                , new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(alpha, new PEntailment(alpha, new PEntailment(e
                , e1))))), new PEntailment(e, new PEntailment(alpha, new PEntailment(alpha
                , new PEntailment(e, e1)))))), new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(new PEntailment(e
                , new PEntailment(alpha, new PEntailment(e, e1))), new PEntailment(new PEntailment(e
                , new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(alpha, new PEntailment(alpha, new PEntailment(e
                , e1))))), new PEntailment(e, new PEntailment(alpha, new PEntailment(alpha
                , new PEntailment(e, e1)))))))), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(e, new PEntailment(alpha
                , new PEntailment(e, e1))), new PEntailment(new PEntailment(e
                , new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(alpha, new PEntailment(alpha, new PEntailment(e
                , e1))))), new PEntailment(e, new PEntailment(alpha, new PEntailment(alpha
                , new PEntailment(e, e1))))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(alpha, new PEntailment(e
                , e1)))), new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(e, new PEntailment(alpha
                , new PEntailment(e, e1))), new PEntailment(new PEntailment(e
                , new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(alpha, new PEntailment(alpha, new PEntailment(e
                , e1))))), new PEntailment(e, new PEntailment(alpha, new PEntailment(alpha
                , new PEntailment(e, e1))))))), new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(new PEntailment(e
                , new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(alpha, new PEntailment(alpha, new PEntailment(e
                , e1))))), new PEntailment(e, new PEntailment(alpha, new PEntailment(alpha
                , new PEntailment(e, e1)))))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(e, new PEntailment(alpha
                , new PEntailment(e, e1))), new PEntailment(new PEntailment(e
                , new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(alpha, new PEntailment(alpha, new PEntailment(e
                , e1))))), new PEntailment(e, new PEntailment(alpha, new PEntailment(alpha
                , new PEntailment(e, e1))))))), new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(new PEntailment(e
                , new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(alpha, new PEntailment(alpha, new PEntailment(e
                , e1))))), new PEntailment(e, new PEntailment(alpha, new PEntailment(alpha
                , new PEntailment(e, e1))))))), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(alpha, new PEntailment(alpha
                , new PEntailment(e, e1))))), new PEntailment(e, new PEntailment(alpha
                , new PEntailment(alpha, new PEntailment(e, e1)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(alpha, new PEntailment(alpha
                , new PEntailment(e, e1)))))), new PEntailment(new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(new PEntailment(e
                , new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(alpha, new PEntailment(alpha, new PEntailment(e
                , e1))))), new PEntailment(e, new PEntailment(alpha, new PEntailment(alpha
                , new PEntailment(e, e1)))))), new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(e, new PEntailment(alpha
                , new PEntailment(alpha, new PEntailment(e, e1))))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(alpha, new PEntailment(alpha
                , new PEntailment(e, e1))))), new PEntailment(e, new PEntailment(alpha
                , new PEntailment(alpha, new PEntailment(e, e1)))))), new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(e, new PEntailment(alpha
                , new PEntailment(alpha, new PEntailment(e, e1)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(alpha, new PEntailment(alpha
                , new PEntailment(e, e1))))), null);
        proof.addExpression(new PEntailment(alpha, new PEntailment(alpha, alpha))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(alpha
                , alpha)), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(alpha, new PEntailment(alpha, alpha))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(alpha, new PEntailment(alpha, alpha)))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(alpha
                , alpha)), new PEntailment(e, new PEntailment(alpha, new PEntailment(alpha
                , alpha)))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(alpha
                , alpha)), new PEntailment(e, new PEntailment(alpha, new PEntailment(alpha
                , alpha)))), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(alpha, new PEntailment(alpha
                , alpha)), new PEntailment(e, new PEntailment(alpha, new PEntailment(alpha
                , alpha)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(alpha, new PEntailment(alpha
                , alpha)), new PEntailment(e, new PEntailment(alpha, new PEntailment(alpha
                , alpha))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(alpha, new PEntailment(alpha, alpha)))
                , new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(new PEntailment(alpha, new PEntailment(alpha, alpha))
                , new PEntailment(e, new PEntailment(alpha, new PEntailment(alpha
                , alpha))))), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(alpha, new PEntailment(alpha
                , alpha)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(alpha, new PEntailment(alpha
                , alpha)), new PEntailment(e, new PEntailment(alpha, new PEntailment(alpha
                , alpha))))), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(alpha, new PEntailment(alpha
                , alpha))))), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(alpha, new PEntailment(alpha
                , alpha)))), null);
        proof.addExpression(new PEntailment(alpha, new PEntailment(new PEntailment(alpha
                , alpha), alpha)), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(alpha
                , alpha), alpha)), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(alpha, new PEntailment(new PEntailment(alpha
                , alpha), alpha)))), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(alpha, new PEntailment(new PEntailment(alpha
                , alpha), alpha))), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(alpha
                , alpha), alpha)), new PEntailment(e, new PEntailment(alpha
                , new PEntailment(new PEntailment(alpha, alpha), alpha)))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(alpha
                , alpha), alpha)), new PEntailment(e, new PEntailment(alpha
                , new PEntailment(new PEntailment(alpha, alpha), alpha)))), new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(alpha, alpha), alpha)), new PEntailment(e
                , new PEntailment(alpha, new PEntailment(new PEntailment(alpha, alpha)
                , alpha)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(alpha
                , alpha), alpha)), new PEntailment(e, new PEntailment(alpha
                , new PEntailment(new PEntailment(alpha, alpha), alpha))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(alpha, new PEntailment(new PEntailment(alpha
                , alpha), alpha))), new PEntailment(new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(alpha, alpha), alpha)), new PEntailment(e
                , new PEntailment(alpha, new PEntailment(new PEntailment(alpha, alpha)
                , alpha))))), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(alpha, new PEntailment(new PEntailment(alpha
                , alpha), alpha)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(alpha
                , alpha), alpha)), new PEntailment(e, new PEntailment(alpha
                , new PEntailment(new PEntailment(alpha, alpha), alpha))))), new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(e, new PEntailment(alpha
                , new PEntailment(new PEntailment(alpha, alpha), alpha))))), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(alpha, new PEntailment(new PEntailment(alpha
                , alpha), alpha)))), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(alpha
                , alpha)), new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(alpha
                , alpha), alpha)), new PEntailment(alpha, alpha))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(alpha
                , alpha)), new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(alpha
                , alpha), alpha)), new PEntailment(alpha, alpha))), new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(new PEntailment(alpha
                , new PEntailment(alpha, alpha)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(alpha, alpha), alpha)), new PEntailment(alpha
                , alpha))))), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(alpha, new PEntailment(alpha
                , alpha)), new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(alpha
                , alpha), alpha)), new PEntailment(alpha, alpha)))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(alpha
                , alpha)), new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(alpha
                , alpha), alpha)), new PEntailment(alpha, alpha))), new PEntailment(e
                , new PEntailment(new PEntailment(alpha, new PEntailment(alpha, alpha))
                , new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(alpha, alpha)
                , alpha)), new PEntailment(alpha, alpha))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(alpha
                , alpha)), new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(alpha
                , alpha), alpha)), new PEntailment(alpha, alpha))), new PEntailment(e
                , new PEntailment(new PEntailment(alpha, new PEntailment(alpha, alpha))
                , new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(alpha, alpha)
                , alpha)), new PEntailment(alpha, alpha))))), new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(new PEntailment(new PEntailment(alpha
                , new PEntailment(alpha, alpha)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(alpha, alpha), alpha)), new PEntailment(alpha
                , alpha))), new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(alpha, alpha)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(alpha, alpha), alpha)), new PEntailment(alpha
                , alpha))))))), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(alpha
                , alpha)), new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(alpha
                , alpha), alpha)), new PEntailment(alpha, alpha))), new PEntailment(e
                , new PEntailment(new PEntailment(alpha, new PEntailment(alpha, alpha))
                , new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(alpha, alpha)
                , alpha)), new PEntailment(alpha, alpha)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(alpha, new PEntailment(alpha
                , alpha)), new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(alpha
                , alpha), alpha)), new PEntailment(alpha, alpha)))), new PEntailment(new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(new PEntailment(new PEntailment(alpha
                , new PEntailment(alpha, alpha)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(alpha, alpha), alpha)), new PEntailment(alpha
                , alpha))), new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(alpha, alpha)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(alpha, alpha), alpha)), new PEntailment(alpha
                , alpha)))))), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(alpha, alpha)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(alpha, alpha), alpha)), new PEntailment(alpha
                , alpha))))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(alpha
                , alpha)), new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(alpha
                , alpha), alpha)), new PEntailment(alpha, alpha))), new PEntailment(e
                , new PEntailment(new PEntailment(alpha, new PEntailment(alpha, alpha))
                , new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(alpha, alpha)
                , alpha)), new PEntailment(alpha, alpha)))))), new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(alpha, alpha)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(alpha, alpha), alpha)), new PEntailment(alpha
                , alpha)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(alpha, alpha)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(alpha, alpha), alpha)), new PEntailment(alpha
                , alpha))))), null);
        proof.addExpression(new PEntailment(new PEntailment(e, new PEntailment(alpha
                , new PEntailment(alpha, alpha))), new PEntailment(new PEntailment(e
                , new PEntailment(new PEntailment(alpha, new PEntailment(alpha, alpha))
                , new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(alpha, alpha)
                , alpha)), new PEntailment(alpha, alpha)))), new PEntailment(e
                , new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(alpha, alpha)
                , alpha)), new PEntailment(alpha, alpha))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(e, new PEntailment(alpha
                , new PEntailment(alpha, alpha))), new PEntailment(new PEntailment(e
                , new PEntailment(new PEntailment(alpha, new PEntailment(alpha, alpha))
                , new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(alpha, alpha)
                , alpha)), new PEntailment(alpha, alpha)))), new PEntailment(e
                , new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(alpha, alpha)
                , alpha)), new PEntailment(alpha, alpha))))), new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(new PEntailment(e
                , new PEntailment(alpha, new PEntailment(alpha, alpha))), new PEntailment(new PEntailment(e
                , new PEntailment(new PEntailment(alpha, new PEntailment(alpha, alpha))
                , new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(alpha, alpha)
                , alpha)), new PEntailment(alpha, alpha)))), new PEntailment(e
                , new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(alpha, alpha)
                , alpha)), new PEntailment(alpha, alpha))))))), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(e, new PEntailment(alpha
                , new PEntailment(alpha, alpha))), new PEntailment(new PEntailment(e
                , new PEntailment(new PEntailment(alpha, new PEntailment(alpha, alpha))
                , new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(alpha, alpha)
                , alpha)), new PEntailment(alpha, alpha)))), new PEntailment(e
                , new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(alpha, alpha)
                , alpha)), new PEntailment(alpha, alpha)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(alpha, new PEntailment(alpha
                , alpha)))), new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(e, new PEntailment(alpha
                , new PEntailment(alpha, alpha))), new PEntailment(new PEntailment(e
                , new PEntailment(new PEntailment(alpha, new PEntailment(alpha, alpha))
                , new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(alpha, alpha)
                , alpha)), new PEntailment(alpha, alpha)))), new PEntailment(e
                , new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(alpha, alpha)
                , alpha)), new PEntailment(alpha, alpha)))))), new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(new PEntailment(e
                , new PEntailment(new PEntailment(alpha, new PEntailment(alpha, alpha))
                , new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(alpha, alpha)
                , alpha)), new PEntailment(alpha, alpha)))), new PEntailment(e
                , new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(alpha, alpha)
                , alpha)), new PEntailment(alpha, alpha))))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(e, new PEntailment(alpha
                , new PEntailment(alpha, alpha))), new PEntailment(new PEntailment(e
                , new PEntailment(new PEntailment(alpha, new PEntailment(alpha, alpha))
                , new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(alpha, alpha)
                , alpha)), new PEntailment(alpha, alpha)))), new PEntailment(e
                , new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(alpha, alpha)
                , alpha)), new PEntailment(alpha, alpha)))))), new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(new PEntailment(e
                , new PEntailment(new PEntailment(alpha, new PEntailment(alpha, alpha))
                , new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(alpha, alpha)
                , alpha)), new PEntailment(alpha, alpha)))), new PEntailment(e
                , new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(alpha, alpha)
                , alpha)), new PEntailment(alpha, alpha)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(alpha, alpha)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(alpha, alpha), alpha)), new PEntailment(alpha
                , alpha)))), new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(alpha, alpha), alpha)), new PEntailment(alpha
                , alpha))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(alpha, alpha)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(alpha, alpha), alpha)), new PEntailment(alpha
                , alpha))))), new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(alpha, alpha)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(alpha, alpha), alpha)), new PEntailment(alpha
                , alpha)))), new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(alpha, alpha), alpha)), new PEntailment(alpha
                , alpha))))), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(alpha, alpha), alpha)), new PEntailment(alpha
                , alpha)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(alpha, alpha)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(alpha, alpha), alpha)), new PEntailment(alpha
                , alpha)))), new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(alpha, alpha), alpha)), new PEntailment(alpha
                , alpha))))), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(alpha, alpha), alpha)), new PEntailment(alpha
                , alpha))))), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(alpha, alpha), alpha)), new PEntailment(alpha
                , alpha)))), null);
        proof.addExpression(new PEntailment(new PEntailment(e, new PEntailment(alpha
                , new PEntailment(new PEntailment(alpha, alpha), alpha))), new PEntailment(new PEntailment(e
                , new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(alpha, alpha)
                , alpha)), new PEntailment(alpha, alpha))), new PEntailment(e
                , new PEntailment(alpha, alpha)))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(e, new PEntailment(alpha
                , new PEntailment(new PEntailment(alpha, alpha), alpha))), new PEntailment(new PEntailment(e
                , new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(alpha, alpha)
                , alpha)), new PEntailment(alpha, alpha))), new PEntailment(e
                , new PEntailment(alpha, alpha)))), new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(new PEntailment(e
                , new PEntailment(alpha, new PEntailment(new PEntailment(alpha, alpha)
                , alpha))), new PEntailment(new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(alpha, alpha), alpha)), new PEntailment(alpha
                , alpha))), new PEntailment(e, new PEntailment(alpha, alpha))))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(e, new PEntailment(alpha
                , new PEntailment(new PEntailment(alpha, alpha), alpha))), new PEntailment(new PEntailment(e
                , new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(alpha, alpha)
                , alpha)), new PEntailment(alpha, alpha))), new PEntailment(e
                , new PEntailment(alpha, alpha))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(alpha, new PEntailment(new PEntailment(alpha
                , alpha), alpha)))), new PEntailment(new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(new PEntailment(e
                , new PEntailment(alpha, new PEntailment(new PEntailment(alpha, alpha)
                , alpha))), new PEntailment(new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(alpha, alpha), alpha)), new PEntailment(alpha
                , alpha))), new PEntailment(e, new PEntailment(alpha, alpha)))))
                , new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(new PEntailment(e, new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(alpha
                , alpha), alpha)), new PEntailment(alpha, alpha))), new PEntailment(e
                , new PEntailment(alpha, alpha)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(e, new PEntailment(alpha
                , new PEntailment(new PEntailment(alpha, alpha), alpha))), new PEntailment(new PEntailment(e
                , new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(alpha, alpha)
                , alpha)), new PEntailment(alpha, alpha))), new PEntailment(e
                , new PEntailment(alpha, alpha))))), new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(new PEntailment(e
                , new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(alpha, alpha)
                , alpha)), new PEntailment(alpha, alpha))), new PEntailment(e
                , new PEntailment(alpha, alpha))))), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(alpha, alpha), alpha)), new PEntailment(alpha
                , alpha))), new PEntailment(e, new PEntailment(alpha, alpha))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(alpha, alpha), alpha)), new PEntailment(alpha
                , alpha)))), new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(alpha, alpha), alpha)), new PEntailment(alpha
                , alpha))), new PEntailment(e, new PEntailment(alpha, alpha))))
                , new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(e, new PEntailment(alpha, alpha))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(alpha, alpha), alpha)), new PEntailment(alpha
                , alpha))), new PEntailment(e, new PEntailment(alpha, alpha))))
                , new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(e, new PEntailment(alpha, alpha)))), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(alpha, alpha)))
                , null);
        proof.addExpression(new PEntailment(e, new PEntailment(e, e))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(e, new PEntailment(e
                , e)), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(e, e))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(e, e)))
                , null);
        proof.addExpression(new PEntailment(e, new PEntailment(new PEntailment(e
                , e), e)), null);
        proof.addExpression(new PEntailment(new PEntailment(e, new PEntailment(new PEntailment(e
                , e), e)), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(new PEntailment(e
                , e), e)))), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(new PEntailment(e
                , e), e))), null);
        proof.addExpression(new PEntailment(new PEntailment(e, new PEntailment(e
                , e)), new PEntailment(new PEntailment(e, new PEntailment(new PEntailment(e
                , e), e)), new PEntailment(e, e))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(e, new PEntailment(e
                , e)), new PEntailment(new PEntailment(e, new PEntailment(new PEntailment(e
                , e), e)), new PEntailment(e, e))), new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(new PEntailment(e
                , new PEntailment(e, e)), new PEntailment(new PEntailment(e
                , new PEntailment(new PEntailment(e, e), e)), new PEntailment(e
                , e))))), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(e, new PEntailment(e
                , e)), new PEntailment(new PEntailment(e, new PEntailment(new PEntailment(e
                , e), e)), new PEntailment(e, e)))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(e, e)))
                , new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(new PEntailment(e, new PEntailment(e, e))
                , new PEntailment(new PEntailment(e, new PEntailment(new PEntailment(e, e)
                , e)), new PEntailment(e, e)))), new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(new PEntailment(e
                , new PEntailment(new PEntailment(e, e), e)), new PEntailment(e
                , e))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(e, new PEntailment(e
                , e)), new PEntailment(new PEntailment(e, new PEntailment(new PEntailment(e
                , e), e)), new PEntailment(e, e)))), new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(new PEntailment(e
                , new PEntailment(new PEntailment(e, e), e)), new PEntailment(e
                , e)))), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(e, new PEntailment(new PEntailment(e
                , e), e)), new PEntailment(e, e))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(new PEntailment(e
                , e), e))), new PEntailment(new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(new PEntailment(e
                , new PEntailment(new PEntailment(e, e), e)), new PEntailment(e
                , e))), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, e)))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(e, new PEntailment(new PEntailment(e
                , e), e)), new PEntailment(e, e))), new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(e, e)))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, e)), null);
        proof.addExpression(new PEntailment(e, new PEntailment(alpha, e))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(e, new PEntailment(alpha
                , e)), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(alpha, e))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(alpha, e)))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(e, new PEntailment(alpha
                , e)), new PEntailment(e, new PEntailment(e, new PEntailment(alpha
                , e)))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(e, new PEntailment(alpha
                , e)), new PEntailment(e, new PEntailment(e, new PEntailment(alpha
                , e)))), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(e, new PEntailment(alpha
                , e)), new PEntailment(e, new PEntailment(e, new PEntailment(alpha
                , e)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(e, new PEntailment(alpha
                , e)), new PEntailment(e, new PEntailment(e, new PEntailment(alpha
                , e))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(alpha, e)))
                , new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(new PEntailment(e, new PEntailment(alpha, e))
                , new PEntailment(e, new PEntailment(e, new PEntailment(alpha
                , e))))), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(e, new PEntailment(alpha
                , e)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(e, new PEntailment(alpha
                , e)), new PEntailment(e, new PEntailment(e, new PEntailment(alpha
                , e))))), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(e, new PEntailment(alpha
                , e))))), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(e, new PEntailment(alpha
                , e)))), null);
        proof.addExpression(new PEntailment(new PEntailment(e, e), new PEntailment(new PEntailment(e
                , new PEntailment(e, new PEntailment(alpha, e))), new PEntailment(e
                , new PEntailment(alpha, e)))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(e, e)
                , new PEntailment(new PEntailment(e, new PEntailment(e, new PEntailment(alpha
                , e))), new PEntailment(e, new PEntailment(alpha, e))))
                , new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(new PEntailment(e, e), new PEntailment(new PEntailment(e
                , new PEntailment(e, new PEntailment(alpha, e))), new PEntailment(e
                , new PEntailment(alpha, e)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(e, e), new PEntailment(new PEntailment(e
                , new PEntailment(e, new PEntailment(alpha, e))), new PEntailment(e
                , new PEntailment(alpha, e))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, e)), new PEntailment(new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(new PEntailment(e
                , e), new PEntailment(new PEntailment(e, new PEntailment(e
                , new PEntailment(alpha, e))), new PEntailment(e, new PEntailment(alpha
                , e))))), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(e, new PEntailment(e
                , new PEntailment(alpha, e))), new PEntailment(e, new PEntailment(alpha
                , e)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(e, e), new PEntailment(new PEntailment(e
                , new PEntailment(e, new PEntailment(alpha, e))), new PEntailment(e
                , new PEntailment(alpha, e))))), new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(new PEntailment(e
                , new PEntailment(e, new PEntailment(alpha, e))), new PEntailment(e
                , new PEntailment(alpha, e))))), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(e, new PEntailment(e
                , new PEntailment(alpha, e))), new PEntailment(e, new PEntailment(alpha
                , e)))), null);
        proof.addExpression(new PEntailment(e, new PEntailment(alpha, e))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(e, new PEntailment(alpha
                , e)), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(alpha, e))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(alpha, e)))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, alpha), new PEntailment(new PEntailment(alpha
                , new PEntailment(alpha, new PEntailment(e, e1))), new PEntailment(alpha
                , new PEntailment(e, e1)))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, alpha)
                , new PEntailment(new PEntailment(alpha, new PEntailment(alpha, new PEntailment(e
                , e1))), new PEntailment(alpha, new PEntailment(e, e1))))
                , new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(new PEntailment(alpha, alpha), new PEntailment(new PEntailment(alpha
                , new PEntailment(alpha, new PEntailment(e, e1))), new PEntailment(alpha
                , new PEntailment(e, e1)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(alpha, alpha), new PEntailment(new PEntailment(alpha
                , new PEntailment(alpha, new PEntailment(e, e1))), new PEntailment(alpha
                , new PEntailment(e, e1))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, alpha)
                , new PEntailment(new PEntailment(alpha, new PEntailment(alpha, new PEntailment(e
                , e1))), new PEntailment(alpha, new PEntailment(e, e1))))
                , new PEntailment(e, new PEntailment(new PEntailment(alpha, alpha)
                , new PEntailment(new PEntailment(alpha, new PEntailment(alpha, new PEntailment(e
                , e1))), new PEntailment(alpha, new PEntailment(e, e1))))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new PEntailment(alpha, alpha)
                , new PEntailment(new PEntailment(alpha, new PEntailment(alpha, new PEntailment(e
                , e1))), new PEntailment(alpha, new PEntailment(e, e1))))
                , new PEntailment(e, new PEntailment(new PEntailment(alpha, alpha)
                , new PEntailment(new PEntailment(alpha, new PEntailment(alpha, new PEntailment(e
                , e1))), new PEntailment(alpha, new PEntailment(e, e1))))))
                , new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(new PEntailment(new PEntailment(alpha, alpha), new PEntailment(new PEntailment(alpha
                , new PEntailment(alpha, new PEntailment(e, e1))), new PEntailment(alpha
                , new PEntailment(e, e1)))), new PEntailment(e, new PEntailment(new PEntailment(alpha
                , alpha), new PEntailment(new PEntailment(alpha, new PEntailment(alpha
                , new PEntailment(e, e1))), new PEntailment(alpha, new PEntailment(e
                , e1)))))))), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(new PEntailment(alpha, alpha)
                , new PEntailment(new PEntailment(alpha, new PEntailment(alpha, new PEntailment(e
                , e1))), new PEntailment(alpha, new PEntailment(e, e1))))
                , new PEntailment(e, new PEntailment(new PEntailment(alpha, alpha)
                , new PEntailment(new PEntailment(alpha, new PEntailment(alpha, new PEntailment(e
                , e1))), new PEntailment(alpha, new PEntailment(e, e1)))))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(alpha, alpha), new PEntailment(new PEntailment(alpha
                , new PEntailment(alpha, new PEntailment(e, e1))), new PEntailment(alpha
                , new PEntailment(e, e1))))), new PEntailment(new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(new PEntailment(new PEntailment(alpha
                , alpha), new PEntailment(new PEntailment(alpha, new PEntailment(alpha
                , new PEntailment(e, e1))), new PEntailment(alpha, new PEntailment(e
                , e1)))), new PEntailment(e, new PEntailment(new PEntailment(alpha
                , alpha), new PEntailment(new PEntailment(alpha, new PEntailment(alpha
                , new PEntailment(e, e1))), new PEntailment(alpha, new PEntailment(e
                , e1))))))), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(new PEntailment(alpha
                , alpha), new PEntailment(new PEntailment(alpha, new PEntailment(alpha
                , new PEntailment(e, e1))), new PEntailment(alpha, new PEntailment(e
                , e1)))))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(new PEntailment(alpha, alpha)
                , new PEntailment(new PEntailment(alpha, new PEntailment(alpha, new PEntailment(e
                , e1))), new PEntailment(alpha, new PEntailment(e, e1))))
                , new PEntailment(e, new PEntailment(new PEntailment(alpha, alpha)
                , new PEntailment(new PEntailment(alpha, new PEntailment(alpha, new PEntailment(e
                , e1))), new PEntailment(alpha, new PEntailment(e, e1)))))))
                , new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(e, new PEntailment(new PEntailment(alpha, alpha)
                , new PEntailment(new PEntailment(alpha, new PEntailment(alpha, new PEntailment(e
                , e1))), new PEntailment(alpha, new PEntailment(e, e1)))))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(new PEntailment(alpha
                , alpha), new PEntailment(new PEntailment(alpha, new PEntailment(alpha
                , new PEntailment(e, e1))), new PEntailment(alpha, new PEntailment(e
                , e1)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(e, new PEntailment(alpha
                , alpha)), new PEntailment(new PEntailment(e, new PEntailment(new PEntailment(alpha
                , alpha), new PEntailment(new PEntailment(alpha, new PEntailment(alpha
                , new PEntailment(e, e1))), new PEntailment(alpha, new PEntailment(e
                , e1))))), new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(alpha, new PEntailment(e, e1))), new PEntailment(alpha
                , new PEntailment(e, e1)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(e, new PEntailment(alpha
                , alpha)), new PEntailment(new PEntailment(e, new PEntailment(new PEntailment(alpha
                , alpha), new PEntailment(new PEntailment(alpha, new PEntailment(alpha
                , new PEntailment(e, e1))), new PEntailment(alpha, new PEntailment(e
                , e1))))), new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(alpha, new PEntailment(e, e1))), new PEntailment(alpha
                , new PEntailment(e, e1)))))), new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(new PEntailment(e
                , new PEntailment(alpha, alpha)), new PEntailment(new PEntailment(e
                , new PEntailment(new PEntailment(alpha, alpha), new PEntailment(new PEntailment(alpha
                , new PEntailment(alpha, new PEntailment(e, e1))), new PEntailment(alpha
                , new PEntailment(e, e1))))), new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(alpha, new PEntailment(e, e1))), new PEntailment(alpha
                , new PEntailment(e, e1)))))))), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(e, new PEntailment(alpha
                , alpha)), new PEntailment(new PEntailment(e, new PEntailment(new PEntailment(alpha
                , alpha), new PEntailment(new PEntailment(alpha, new PEntailment(alpha
                , new PEntailment(e, e1))), new PEntailment(alpha, new PEntailment(e
                , e1))))), new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(alpha, new PEntailment(e, e1))), new PEntailment(alpha
                , new PEntailment(e, e1))))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(alpha, alpha)))
                , new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(new PEntailment(e, new PEntailment(alpha, alpha))
                , new PEntailment(new PEntailment(e, new PEntailment(new PEntailment(alpha, alpha)
                , new PEntailment(new PEntailment(alpha, new PEntailment(alpha, new PEntailment(e
                , e1))), new PEntailment(alpha, new PEntailment(e, e1)))))
                , new PEntailment(e, new PEntailment(new PEntailment(alpha, new PEntailment(alpha
                , new PEntailment(e, e1))), new PEntailment(alpha, new PEntailment(e
                , e1))))))), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(e, new PEntailment(new PEntailment(alpha
                , alpha), new PEntailment(new PEntailment(alpha, new PEntailment(alpha
                , new PEntailment(e, e1))), new PEntailment(alpha, new PEntailment(e
                , e1))))), new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(alpha, new PEntailment(e, e1))), new PEntailment(alpha
                , new PEntailment(e, e1)))))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(e, new PEntailment(alpha
                , alpha)), new PEntailment(new PEntailment(e, new PEntailment(new PEntailment(alpha
                , alpha), new PEntailment(new PEntailment(alpha, new PEntailment(alpha
                , new PEntailment(e, e1))), new PEntailment(alpha, new PEntailment(e
                , e1))))), new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(alpha, new PEntailment(e, e1))), new PEntailment(alpha
                , new PEntailment(e, e1))))))), new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(new PEntailment(e
                , new PEntailment(new PEntailment(alpha, alpha), new PEntailment(new PEntailment(alpha
                , new PEntailment(alpha, new PEntailment(e, e1))), new PEntailment(alpha
                , new PEntailment(e, e1))))), new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(alpha, new PEntailment(e, e1))), new PEntailment(alpha
                , new PEntailment(e, e1))))))), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(e, new PEntailment(new PEntailment(alpha
                , alpha), new PEntailment(new PEntailment(alpha, new PEntailment(alpha
                , new PEntailment(e, e1))), new PEntailment(alpha, new PEntailment(e
                , e1))))), new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(alpha, new PEntailment(e, e1))), new PEntailment(alpha
                , new PEntailment(e, e1)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(new PEntailment(alpha
                , alpha), new PEntailment(new PEntailment(alpha, new PEntailment(alpha
                , new PEntailment(e, e1))), new PEntailment(alpha, new PEntailment(e
                , e1)))))), new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(e, new PEntailment(new PEntailment(alpha
                , alpha), new PEntailment(new PEntailment(alpha, new PEntailment(alpha
                , new PEntailment(e, e1))), new PEntailment(alpha, new PEntailment(e
                , e1))))), new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(alpha, new PEntailment(e, e1))), new PEntailment(alpha
                , new PEntailment(e, e1)))))), new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(alpha, new PEntailment(e, e1))), new PEntailment(alpha
                , new PEntailment(e, e1))))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(e, new PEntailment(new PEntailment(alpha
                , alpha), new PEntailment(new PEntailment(alpha, new PEntailment(alpha
                , new PEntailment(e, e1))), new PEntailment(alpha, new PEntailment(e
                , e1))))), new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(alpha, new PEntailment(e, e1))), new PEntailment(alpha
                , new PEntailment(e, e1)))))), new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(alpha, new PEntailment(e, e1))), new PEntailment(alpha
                , new PEntailment(e, e1)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(alpha, new PEntailment(e, e1))), new PEntailment(alpha
                , new PEntailment(e, e1))))), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(alpha, new PEntailment(e, e1))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(alpha, new PEntailment(e, e1)))
                , new PEntailment(alpha, new PEntailment(e, e1)))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(alpha, new PEntailment(e, e1))))
                , new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(alpha, new PEntailment(e, e1))), new PEntailment(alpha
                , new PEntailment(e, e1)))), new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(alpha, new PEntailment(e
                , e1))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(alpha, new PEntailment(e, e1)))
                , new PEntailment(alpha, new PEntailment(e, e1)))), new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(alpha, new PEntailment(e
                , e1)))), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(alpha, new PEntailment(e, e1)))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(alpha, new PEntailment(e
                , e1)))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(alpha, new PEntailment(e
                , e1)))), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(alpha, new PEntailment(e
                , e1)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(alpha, new PEntailment(e
                , e1))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(alpha, new PEntailment(e, e1)))
                , new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(e, new PEntailment(alpha, new PEntailment(e
                , e1))))), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(alpha, new PEntailment(e
                , e1)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(alpha, new PEntailment(e
                , e1))))), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(alpha, new PEntailment(e
                , e1))))), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(alpha, new PEntailment(e
                , e1)))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(alpha, new PEntailment(e, e1)))
                , new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(e, new PEntailment(alpha, new PEntailment(e
                , e1))))), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(alpha, new PEntailment(e
                , e1)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(alpha, new PEntailment(e
                , e1))))), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(alpha, new PEntailment(e
                , e1))))), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(alpha, new PEntailment(e
                , e1)))), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, e), new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(alpha, e1)))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, e)
                , new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(alpha, e1))), new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(new PEntailment(alpha
                , e), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(alpha, e1))))), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(alpha, e), new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(alpha, e1))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, e)
                , new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(alpha, e1))), new PEntailment(e, new PEntailment(new PEntailment(alpha
                , e), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(alpha, e1))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new PEntailment(alpha, e)
                , new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(alpha, e1))), new PEntailment(e, new PEntailment(new PEntailment(alpha
                , e), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(alpha, e1))))), new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(new PEntailment(new PEntailment(alpha
                , e), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(alpha, e1))), new PEntailment(e
                , new PEntailment(new PEntailment(alpha, e), new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(alpha, e1)))))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(new PEntailment(alpha, e)
                , new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(alpha, e1))), new PEntailment(e, new PEntailment(new PEntailment(alpha
                , e), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(alpha, e1)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(alpha, e), new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(alpha, e1))))
                , new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(new PEntailment(new PEntailment(alpha, e), new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(alpha, e1)))
                , new PEntailment(e, new PEntailment(new PEntailment(alpha, e)
                , new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(alpha, e1)))))), new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(e, new PEntailment(new PEntailment(alpha
                , e), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(alpha, e1))))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(new PEntailment(alpha, e)
                , new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(alpha, e1))), new PEntailment(e, new PEntailment(new PEntailment(alpha
                , e), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(alpha, e1)))))), new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(e, new PEntailment(new PEntailment(alpha
                , e), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(alpha, e1)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(new PEntailment(alpha
                , e), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(alpha, e1))))), null);
        proof.addExpression(new PEntailment(new PEntailment(e, new PEntailment(alpha
                , e)), new PEntailment(new PEntailment(e, new PEntailment(new PEntailment(alpha
                , e), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(alpha, e1)))), new PEntailment(e
                , new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(alpha, e1))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(e, new PEntailment(alpha
                , e)), new PEntailment(new PEntailment(e, new PEntailment(new PEntailment(alpha
                , e), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(alpha, e1)))), new PEntailment(e
                , new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(alpha, e1))))), new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(new PEntailment(e
                , new PEntailment(alpha, e)), new PEntailment(new PEntailment(e
                , new PEntailment(new PEntailment(alpha, e), new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(alpha, e1))))
                , new PEntailment(e, new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(alpha, e1))))))), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(e, new PEntailment(alpha
                , e)), new PEntailment(new PEntailment(e, new PEntailment(new PEntailment(alpha
                , e), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(alpha, e1)))), new PEntailment(e
                , new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(alpha, e1)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(alpha, e)))
                , new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(new PEntailment(e, new PEntailment(alpha, e))
                , new PEntailment(new PEntailment(e, new PEntailment(new PEntailment(alpha, e)
                , new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(alpha, e1)))), new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(alpha, e1))))))
                , new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(new PEntailment(e, new PEntailment(new PEntailment(alpha, e)
                , new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(alpha, e1)))), new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(alpha, e1)))))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(e, new PEntailment(alpha
                , e)), new PEntailment(new PEntailment(e, new PEntailment(new PEntailment(alpha
                , e), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(alpha, e1)))), new PEntailment(e
                , new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(alpha, e1)))))), new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(new PEntailment(e
                , new PEntailment(new PEntailment(alpha, e), new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(alpha, e1))))
                , new PEntailment(e, new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(alpha, e1)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(e, new PEntailment(new PEntailment(alpha
                , e), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(alpha, e1)))), new PEntailment(e
                , new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(alpha, e1))))), null);
    }

    public static void addExistsProof2(FormalArithmeticExpression alpha, FormalArithmeticExpression e,
                                       FormalArithmeticExpression e1, Term variable, Proof<FormalArithmeticExpression> proof) {
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(alpha, e)))
                , new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(new PEntailment(e, new PEntailment(alpha, e))
                , new PEntailment(new PEntailment(e, new PEntailment(new PEntailment(alpha, e)
                , new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(alpha, e1)))), new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(alpha, e1))))))
                , new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(new PEntailment(e, new PEntailment(new PEntailment(alpha, e)
                , new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(alpha, e1)))), new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(alpha, e1)))))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(e, new PEntailment(alpha
                , e)), new PEntailment(new PEntailment(e, new PEntailment(new PEntailment(alpha
                , e), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(alpha, e1)))), new PEntailment(e
                , new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(alpha, e1)))))), new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(new PEntailment(e
                , new PEntailment(new PEntailment(alpha, e), new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(alpha, e1))))
                , new PEntailment(e, new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(alpha, e1)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(e, new PEntailment(new PEntailment(alpha
                , e), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(alpha, e1)))), new PEntailment(e
                , new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(alpha, e1))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(new PEntailment(alpha
                , e), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(alpha, e1))))), new PEntailment(new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(new PEntailment(e
                , new PEntailment(new PEntailment(alpha, e), new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(alpha, e1))))
                , new PEntailment(e, new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(alpha, e1))))), new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(alpha, e1))))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(e, new PEntailment(new PEntailment(alpha
                , e), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(alpha, e1)))), new PEntailment(e
                , new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(alpha, e1))))), new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(alpha, e1)))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(alpha, e1))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(e, new PEntailment(alpha
                , new PEntailment(e, e1))), new PEntailment(new PEntailment(e
                , new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(alpha, e1))), new PEntailment(e, new PEntailment(alpha
                , e1)))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(e, new PEntailment(alpha
                , new PEntailment(e, e1))), new PEntailment(new PEntailment(e
                , new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(alpha, e1))), new PEntailment(e, new PEntailment(alpha
                , e1)))), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(e, new PEntailment(alpha
                , new PEntailment(e, e1))), new PEntailment(new PEntailment(e
                , new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(alpha, e1))), new PEntailment(e, new PEntailment(alpha
                , e1)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(e, new PEntailment(alpha
                , new PEntailment(e, e1))), new PEntailment(new PEntailment(e
                , new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(alpha, e1))), new PEntailment(e, new PEntailment(alpha
                , e1))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(alpha, new PEntailment(e
                , e1)))), new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(e, new PEntailment(alpha
                , new PEntailment(e, e1))), new PEntailment(new PEntailment(e
                , new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(alpha, e1))), new PEntailment(e, new PEntailment(alpha
                , e1))))), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(alpha, e1)))
                , new PEntailment(e, new PEntailment(alpha, e1)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(e, new PEntailment(alpha
                , new PEntailment(e, e1))), new PEntailment(new PEntailment(e
                , new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(alpha, e1))), new PEntailment(e, new PEntailment(alpha
                , e1))))), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(alpha, e1)))
                , new PEntailment(e, new PEntailment(alpha, e1))))), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(alpha, e1)))
                , new PEntailment(e, new PEntailment(alpha, e1)))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(alpha, new PEntailment(e
                , e1)))), new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(e, new PEntailment(alpha
                , new PEntailment(e, e1))), new PEntailment(new PEntailment(e
                , new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(alpha, e1))), new PEntailment(e, new PEntailment(alpha
                , e1))))), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(alpha, e1)))
                , new PEntailment(e, new PEntailment(alpha, e1)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(e, new PEntailment(alpha
                , new PEntailment(e, e1))), new PEntailment(new PEntailment(e
                , new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(alpha, e1))), new PEntailment(e, new PEntailment(alpha
                , e1))))), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(alpha, e1)))
                , new PEntailment(e, new PEntailment(alpha, e1))))), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(alpha, e1)))
                , new PEntailment(e, new PEntailment(alpha, e1)))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(alpha, e1))))
                , new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(new PEntailment(e, new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(alpha, e1))), new PEntailment(e
                , new PEntailment(alpha, e1)))), new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(e, new PEntailment(alpha
                , e1))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(alpha, e1)))
                , new PEntailment(e, new PEntailment(alpha, e1)))), new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(e, new PEntailment(alpha
                , e1)))), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(alpha, e1)))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(e, new PEntailment(alpha
                , new PEntailment(e, e1))), new PEntailment(new PEntailment(e
                , new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(alpha, e1))), new PEntailment(e, new PEntailment(alpha
                , e1)))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(e, new PEntailment(alpha
                , new PEntailment(e, e1))), new PEntailment(new PEntailment(e
                , new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(alpha, e1))), new PEntailment(e, new PEntailment(alpha
                , e1)))), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(e, new PEntailment(alpha
                , new PEntailment(e, e1))), new PEntailment(new PEntailment(e
                , new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(alpha, e1))), new PEntailment(e, new PEntailment(alpha
                , e1)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(e, new PEntailment(alpha
                , new PEntailment(e, e1))), new PEntailment(new PEntailment(e
                , new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(alpha, e1))), new PEntailment(e, new PEntailment(alpha
                , e1))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(alpha, new PEntailment(e
                , e1)))), new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(e, new PEntailment(alpha
                , new PEntailment(e, e1))), new PEntailment(new PEntailment(e
                , new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(alpha, e1))), new PEntailment(e, new PEntailment(alpha
                , e1))))), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(alpha, e1)))
                , new PEntailment(e, new PEntailment(alpha, e1)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(e, new PEntailment(alpha
                , new PEntailment(e, e1))), new PEntailment(new PEntailment(e
                , new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(alpha, e1))), new PEntailment(e, new PEntailment(alpha
                , e1))))), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(alpha, e1)))
                , new PEntailment(e, new PEntailment(alpha, e1))))), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(alpha, e1)))
                , new PEntailment(e, new PEntailment(alpha, e1)))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(alpha, new PEntailment(e
                , e1)))), new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(e, new PEntailment(alpha
                , new PEntailment(e, e1))), new PEntailment(new PEntailment(e
                , new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(alpha, e1))), new PEntailment(e, new PEntailment(alpha
                , e1))))), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(alpha, e1)))
                , new PEntailment(e, new PEntailment(alpha, e1)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(e, new PEntailment(alpha
                , new PEntailment(e, e1))), new PEntailment(new PEntailment(e
                , new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(alpha, e1))), new PEntailment(e, new PEntailment(alpha
                , e1))))), new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(alpha, e1)))
                , new PEntailment(e, new PEntailment(alpha, e1))))), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(alpha, e1)))
                , new PEntailment(e, new PEntailment(alpha, e1)))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(alpha, e1))))
                , new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e, e1))
                , new PEntailment(new PEntailment(e, new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(alpha, e1))), new PEntailment(e
                , new PEntailment(alpha, e1)))), new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(e, new PEntailment(alpha
                , e1))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(new PEntailment(e, new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(alpha, e1)))
                , new PEntailment(e, new PEntailment(alpha, e1)))), new PEntailment(new PEntailment(alpha
                , new PEntailment(e, e1)), new PEntailment(e, new PEntailment(alpha
                , e1)))), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(e
                , e1)), new PEntailment(e, new PEntailment(alpha, e1)))
                , null);
        proof.addExpression(new PEntailment(alpha, new PEntailment(e, e1))
                , null);
        proof.addExpression(new PEntailment(e, new PEntailment(alpha, e1))
                , null);
        proof.addExpression(new PEntailment(new Exists(variable, e), new PEntailment(alpha
                , e1)), null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new Exists(variable, e), new PEntailment(alpha
                , e1)))), null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1))), new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)))), new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable, e)
                , new PEntailment(alpha, e1))), new PEntailment(new Exists(variable, e)
                , new PEntailment(alpha, e1)))), new PEntailment(new PEntailment(new Exists(variable, e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable, e)
                , new PEntailment(alpha, e1))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable, e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(new PEntailment(new Exists(variable, e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1))), new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)))), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)))), null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1))), null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)))), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1))), new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1))))), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1))))), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)))), null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new Exists(variable,e), new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1))))
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new Exists(variable,e), new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new Exists(variable,e), new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1))))
                , new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1))))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1))))
                , new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1))))))
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1))))
                , new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1))))))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1))))
                , new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))))
                , new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1))))
                , new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))))))
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1))))))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1))))
                , new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))))))
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1))))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1))), new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new Exists(variable,e), new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1))))), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1))))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1))), new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new Exists(variable,e), new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1))))), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1))))))
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1))), new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new Exists(variable,e), new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1))))), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1))))))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1))), new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new Exists(variable,e), new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1))))), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)))), new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))
                , new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))))
                , new PEntailment(alpha, new PEntailment(new Exists(variable,e), new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1))))))), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new Exists(variable,e), new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1))))), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1))))))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))
                , new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))))
                , new PEntailment(alpha, new PEntailment(new Exists(variable,e), new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1))))))), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new Exists(variable,e), new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1))))), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))))
                , new PEntailment(alpha, new PEntailment(new Exists(variable,e), new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1))))))
                , new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))))
                , new PEntailment(alpha, new PEntailment(new Exists(variable,e), new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)))))), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new Exists(variable,e), new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1))))), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1))))))
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1))))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))))
                , null);
        proof.addExpression(new PEntailment(new Exists(variable,e), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e))), null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e))), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new Exists(variable,e)))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new Exists(variable,e), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)))), null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e))), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new Exists(variable,e)))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new Exists(variable,e)))
                , new PEntailment(alpha, new PEntailment(new Exists(variable,e), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e))))), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new Exists(variable,e)))
                , new PEntailment(alpha, new PEntailment(new Exists(variable,e), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e))))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e))), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new Exists(variable,e))))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new Exists(variable,e))))
                , new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e))), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new Exists(variable,e))))))
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new Exists(variable,e)))))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new Exists(variable,e)))
                , new PEntailment(alpha, new PEntailment(new Exists(variable,e), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)))))), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new Exists(variable,e))))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new Exists(variable,e)))))
                , null);
        proof.addExpression(new PEntailment(new Exists(variable,e), new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , new PEntailment(new PEntailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new Exists(variable,e), new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e)))), null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new PEntailment(alpha
                , new PEntailment(new Exists(variable,e), new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new PEntailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(new PEntailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))))), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new PEntailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(new PEntailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new PEntailment(alpha
                , new PEntailment(new Exists(variable,e), new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , new PEntailment(new PEntailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e)))), new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new PEntailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(new PEntailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e)))))), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(new PEntailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new PEntailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(new PEntailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e)))))), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(new PEntailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(new PEntailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e))), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new PEntailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new Exists(variable,e)))
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)))), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new Exists(variable,e)))
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e))), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new PEntailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new Exists(variable,e)))
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)))), new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new Exists(variable,e)))
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new Exists(variable,e)))
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)))), new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new Exists(variable,e)))
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)))))), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new Exists(variable,e)))
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)))), new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new Exists(variable,e)))
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)))))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new Exists(variable,e)))
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)))), new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new Exists(variable,e)))
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e))))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new Exists(variable,e)))
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e))))), new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new Exists(variable,e)))
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)))), new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new Exists(variable,e)))
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e))))))), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new Exists(variable,e)))
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)))))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new Exists(variable,e)))
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)))), new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new Exists(variable,e)))
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e))))))), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new Exists(variable,e)))
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e))))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new Exists(variable,e)))
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new Exists(variable,e))))
                , new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new Exists(variable,e)))
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e))))), new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new PEntailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new Exists(variable,e))))
                , new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new Exists(variable,e)))
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e))))), new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new PEntailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)))))), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new Exists(variable,e), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)))), new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new Exists(variable,e)))
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e))))), new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new PEntailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)))))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new Exists(variable,e))))
                , new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new Exists(variable,e)))
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e))))), new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new PEntailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e))))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new Exists(variable,e)))))
                , new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new Exists(variable,e))))
                , new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new Exists(variable,e)))
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e))))), new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new PEntailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e))))))), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e))), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new PEntailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e))))), new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new PEntailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)))))))), null);
    }

    public static void addExistsProof3(FormalArithmeticExpression alpha, FormalArithmeticExpression e,
                                       FormalArithmeticExpression e1, Term variable, Proof<FormalArithmeticExpression> proof) {
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new Exists(variable,e), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)))), new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new Exists(variable,e)))
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e))))), new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new PEntailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e))))))), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e))), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new PEntailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e))))), new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new PEntailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e))))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new Exists(variable,e)))
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e))))), new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new PEntailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new Exists(variable,e)))
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)))))), new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e))), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new PEntailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e))))), new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new PEntailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)))))), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new PEntailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e))))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e))), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new PEntailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e))))), new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new PEntailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)))))), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new PEntailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new PEntailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e))))), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(new PEntailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e)))), new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new PEntailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)))), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new Exists(variable,e))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(new PEntailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e)))), new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new PEntailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)))), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new Exists(variable,e))))), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new Exists(variable,e), new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e)))), new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)))), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new Exists(variable,e))))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(new PEntailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e)))), new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new PEntailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)))), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(new PEntailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))))), new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new Exists(variable,e), new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e)))), new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)))), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)))))), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)))), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new Exists(variable,e))))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new Exists(variable,e), new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e)))), new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)))), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)))))), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)))), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new PEntailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)))), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new Exists(variable,e))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new PEntailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e))))), new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)))), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new Exists(variable,e))))), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)))), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new Exists(variable,e))))), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new Exists(variable,e))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)))), null);
        proof.addExpression(new PEntailment(alpha, new PEntailment(alpha, alpha))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(alpha
                , alpha)), new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(alpha, new PEntailment(alpha, alpha))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(alpha, new PEntailment(alpha, alpha)))
                , null);
        proof.addExpression(new PEntailment(alpha, new PEntailment(new PEntailment(alpha
                , alpha), alpha)), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(alpha
                , alpha), alpha)), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(alpha, new PEntailment(new PEntailment(alpha
                , alpha), alpha)))), null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(alpha, new PEntailment(new PEntailment(alpha
                , alpha), alpha))), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(alpha
                , alpha)), new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(alpha
                , alpha), alpha)), new PEntailment(alpha, alpha))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(alpha
                , alpha)), new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(alpha
                , alpha), alpha)), new PEntailment(alpha, alpha))), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(alpha
                , new PEntailment(alpha, alpha)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(alpha, alpha), alpha)), new PEntailment(alpha
                , alpha))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(alpha, new PEntailment(alpha
                , alpha)), new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(alpha
                , alpha), alpha)), new PEntailment(alpha, alpha)))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(alpha, new PEntailment(alpha
                , alpha))), new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(alpha
                , new PEntailment(alpha, alpha)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(alpha, alpha), alpha)), new PEntailment(alpha
                , alpha)))), new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(alpha
                , alpha), alpha)), new PEntailment(alpha, alpha))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(alpha
                , new PEntailment(alpha, alpha)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(alpha, alpha), alpha)), new PEntailment(alpha
                , alpha)))), new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(alpha
                , alpha), alpha)), new PEntailment(alpha, alpha)))), null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(alpha
                , alpha), alpha)), new PEntailment(alpha, alpha))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(alpha, new PEntailment(new PEntailment(alpha
                , alpha), alpha))), new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(alpha, alpha), alpha)), new PEntailment(alpha
                , alpha))), new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(alpha, alpha)))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(alpha, alpha), alpha)), new PEntailment(alpha
                , alpha))), new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(alpha, alpha))), null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(alpha, alpha)), null);
        proof.addExpression(new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , alpha)), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , alpha)), new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , alpha)))), null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , alpha))), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , alpha)), new PEntailment(alpha, new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , alpha)))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , alpha)), new PEntailment(alpha, new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , alpha)))), new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , alpha)), new PEntailment(alpha, new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , alpha)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , alpha)), new PEntailment(alpha, new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , alpha))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , alpha))), new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new Exists(variable,e), alpha)), new PEntailment(alpha
                , new PEntailment(alpha, new PEntailment(new Exists(variable,e), alpha)))))
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(alpha, new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , alpha)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new Exists(variable,e), alpha)), new PEntailment(alpha
                , new PEntailment(alpha, new PEntailment(new Exists(variable,e), alpha)))))
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(alpha, new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , alpha))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(alpha, new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , alpha)))), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, alpha), new PEntailment(new PEntailment(alpha
                , new PEntailment(alpha, new PEntailment(new Exists(variable,e), alpha)))
                , new PEntailment(alpha, new PEntailment(new Exists(variable,e), alpha))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, alpha)
                , new PEntailment(new PEntailment(alpha, new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , alpha))), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , alpha)))), new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(alpha, alpha), new PEntailment(new PEntailment(alpha
                , new PEntailment(alpha, new PEntailment(new Exists(variable,e), alpha)))
                , new PEntailment(alpha, new PEntailment(new Exists(variable,e), alpha))))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(alpha, alpha), new PEntailment(new PEntailment(alpha
                , new PEntailment(alpha, new PEntailment(new Exists(variable,e), alpha)))
                , new PEntailment(alpha, new PEntailment(new Exists(variable,e), alpha)))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(alpha, alpha))
                , new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(alpha, alpha), new PEntailment(new PEntailment(alpha
                , new PEntailment(alpha, new PEntailment(new Exists(variable,e), alpha)))
                , new PEntailment(alpha, new PEntailment(new Exists(variable,e), alpha)))))
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(alpha, new PEntailment(alpha
                , new PEntailment(new Exists(variable,e), alpha))), new PEntailment(alpha
                , new PEntailment(new Exists(variable,e), alpha)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(alpha
                , alpha), new PEntailment(new PEntailment(alpha, new PEntailment(alpha
                , new PEntailment(new Exists(variable,e), alpha))), new PEntailment(alpha
                , new PEntailment(new Exists(variable,e), alpha))))), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(alpha
                , new PEntailment(alpha, new PEntailment(new Exists(variable,e), alpha)))
                , new PEntailment(alpha, new PEntailment(new Exists(variable,e), alpha)))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(alpha, new PEntailment(alpha
                , new PEntailment(new Exists(variable,e), alpha))), new PEntailment(alpha
                , new PEntailment(new Exists(variable,e), alpha)))), null);
        proof.addExpression(new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , alpha)), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , alpha)), new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , alpha)))), null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , alpha))), null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new Exists(variable,e))
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1))), new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1))))
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(new Exists(variable,e), new Exists(variable,e))
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1))), new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(new Exists(variable,e), new Exists(variable,e))
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1))), new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1))))
                , new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1))))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1))))
                , new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1))))))
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1))))
                , new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1))))))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1))))
                , new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))))
                , new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1))))
                , new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))))))
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1))))))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1))))
                , new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))))))
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1))))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new Exists(variable,e))), new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))))
                , new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1))))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new Exists(variable,e))), new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))))
                , new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1))))))
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new Exists(variable,e))), new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))))
                , new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1))))))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new Exists(variable,e))), new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))))
                , new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)))), new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new Exists(variable,e), new Exists(variable,e)))
                , new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))))
                , new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))))))
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))))
                , new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1))))))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new Exists(variable,e), new Exists(variable,e)))
                , new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))))
                , new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))))))
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))))
                , new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))))
                , new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1))))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1))))))
                , new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new Exists(variable,e)), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))))
                , new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1))))))
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(new Exists(variable,e), new Exists(variable,e))
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1))), new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1))))), new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1))))))
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1))))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)))), null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1))), new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)))), new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1))), new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)))), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1))), new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)))), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)))), null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1))), null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)))), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1))), new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1))))), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1))))), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1))), new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1))))), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1))))), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)))), null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), alpha)
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new Exists(variable,e), e1)))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , alpha), new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new Exists(variable,e), e1)))
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(new Exists(variable,e), alpha)
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new Exists(variable,e), e1)))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(new Exists(variable,e), alpha)
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new Exists(variable,e), e1))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , alpha), new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new Exists(variable,e), e1)))
                , new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , alpha), new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new Exists(variable,e), e1)))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , alpha), new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new Exists(variable,e), e1)))
                , new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , alpha), new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new Exists(variable,e), e1)))))
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , alpha), new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new Exists(variable,e), e1)))
                , new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , alpha), new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new Exists(variable,e), e1)))))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , alpha), new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new Exists(variable,e), e1)))
                , new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , alpha), new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new Exists(variable,e), e1))))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(new Exists(variable,e)
                , alpha), new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new Exists(variable,e), e1))))
                , new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , alpha), new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new Exists(variable,e), e1)))
                , new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , alpha), new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new Exists(variable,e), e1))))))
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , alpha), new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new Exists(variable,e), e1)))))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , alpha), new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new Exists(variable,e), e1)))
                , new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , alpha), new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new Exists(variable,e), e1))))))
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , alpha), new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new Exists(variable,e), e1))))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , alpha), new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new Exists(variable,e), e1)))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , alpha)), new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , alpha), new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new Exists(variable,e), e1))))
                , new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , e1))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , alpha)), new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , alpha), new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new Exists(variable,e), e1))))
                , new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , e1))))), new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , alpha)), new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , alpha), new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new Exists(variable,e), e1))))
                , new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , e1))))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , alpha)), new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , alpha), new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new Exists(variable,e), e1))))
                , new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , e1)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , alpha))), new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new Exists(variable,e), alpha)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(new Exists(variable,e), alpha), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , e1)))), new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , e1)))))), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(new Exists(variable,e), alpha), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , e1)))), new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , e1))))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new Exists(variable,e), alpha)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(new Exists(variable,e), alpha), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , e1)))), new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , e1)))))), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(new Exists(variable,e), alpha), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , e1)))), new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , e1)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , alpha), new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new Exists(variable,e), e1))))
                , new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , e1))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , alpha))), new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new Exists(variable,e), alpha)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(new Exists(variable,e), alpha), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , e1)))), new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , e1)))))), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(new Exists(variable,e), alpha), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , e1)))), new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , e1))))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new Exists(variable,e), alpha)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(new Exists(variable,e), alpha), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , e1)))), new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , e1)))))), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(new Exists(variable,e), alpha), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , e1)))), new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , e1)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , alpha), new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new Exists(variable,e), e1))))
                , new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , e1))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , alpha), new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new Exists(variable,e), e1)))))
                , new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , alpha), new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new Exists(variable,e), e1))))
                , new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , e1))))), new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , e1)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(new Exists(variable,e), alpha), new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , e1)))), new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , e1))))), new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , e1))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , e1)))), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1))), new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new Exists(variable,e), e1)))
                , new PEntailment(alpha, new PEntailment(new Exists(variable,e), e1))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1))), new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new Exists(variable,e), e1)))
                , new PEntailment(alpha, new PEntailment(new Exists(variable,e), e1))))
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1))), new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new Exists(variable,e), e1)))
                , new PEntailment(alpha, new PEntailment(new Exists(variable,e), e1))))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1))), new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new Exists(variable,e), e1)))
                , new PEntailment(alpha, new PEntailment(new Exists(variable,e), e1)))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)))), new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))
                , new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , e1))), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , e1))))), new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , e1))), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , e1)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))
                , new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , e1))), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , e1))))), new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , e1))), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , e1))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , e1))), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , e1)))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)))), new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))
                , new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , e1))), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , e1))))), new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , e1))), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , e1)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))
                , new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , e1))), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , e1))))), new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , e1))), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , e1))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , e1))), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , e1)))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , e1)))), new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new Exists(variable,e), e1)))
                , new PEntailment(alpha, new PEntailment(new Exists(variable,e), e1))))
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , e1))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new Exists(variable,e), e1)))
                , new PEntailment(alpha, new PEntailment(new Exists(variable,e), e1))))
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , e1)))), null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , e1))), null);
        proof.addExpression(new PEntailment(new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1))), new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new Exists(variable,e), e1)))
                , new PEntailment(alpha, new PEntailment(new Exists(variable,e), e1))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1))), new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new Exists(variable,e), e1)))
                , new PEntailment(alpha, new PEntailment(new Exists(variable,e), e1))))
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1))), new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new Exists(variable,e), e1)))
                , new PEntailment(alpha, new PEntailment(new Exists(variable,e), e1))))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1))), new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new Exists(variable,e), e1)))
                , new PEntailment(alpha, new PEntailment(new Exists(variable,e), e1)))))
                , null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)))), new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))
                , new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , e1))), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , e1))))), new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , e1))), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , e1)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))
                , new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , e1))), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , e1))))), new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , e1))), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , e1))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , e1))), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , e1)))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)))), new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))
                , new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , e1))), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , e1))))), new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , e1))), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , e1)))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new Exists(variable,e), new PEntailment(alpha, e1)))
                , new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , e1))), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , e1))))), new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , e1))), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , e1))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , e1))), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , e1)))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(alpha, new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new Exists(variable,e)
                , e1)))), new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new Exists(variable,e), e1)))
                , new PEntailment(alpha, new PEntailment(new Exists(variable,e), e1))))
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , e1))))), null);
        proof.addExpression(new PEntailment(new PEntailment(new PEntailment(new Exists(variable,e)
                , new PEntailment(alpha, e1)), new PEntailment(new PEntailment(alpha
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(new Exists(variable,e), e1)))
                , new PEntailment(alpha, new PEntailment(new Exists(variable,e), e1))))
                , new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , e1)))), null);
        proof.addExpression(new PEntailment(new PEntailment(new Exists(variable,e), new PEntailment(alpha
                , e1)), new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , e1))), null);
        proof.addExpression(new PEntailment(alpha, new PEntailment(new Exists(variable,e)
                , e1)), null);
    }
}
