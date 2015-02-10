package rules;

import parser.ArithmeticParser;
import parser.ParseException;
import proof.Proof;
import structure.Expression;
import structure.logic.Entailment;
import structure.logic.Variable;
import structure.predicate.Exists;
import structure.predicate.Term;

public class ExistsRule {
    public static void addExistsProof1(Expression alpha, Expression e, Expression e1, Term variable, Proof proof) {
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(alpha, new Entailment(e, e1))))
                , null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(alpha, new Entailment(e, e1)))
                , new Entailment(alpha, new Entailment(e, e1)))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(alpha, new Entailment(e, e1))))
                , new Entailment(new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(alpha, new Entailment(e, e1))), new Entailment(alpha
                , new Entailment(e, e1)))), new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(alpha, new Entailment(e
                , e1))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(alpha, new Entailment(e, e1)))
                , new Entailment(alpha, new Entailment(e, e1)))), new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(alpha, new Entailment(e
                , e1)))), null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(alpha, new Entailment(e, e1)))
                , null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(alpha, new Entailment(e
                , e1)))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(alpha, new Entailment(e
                , e1)))), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(alpha, new Entailment(e
                , e1)))))), null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(alpha, new Entailment(e
                , e1))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(alpha, new Entailment(e, e1)))
                , new Entailment(new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(e, new Entailment(alpha, new Entailment(e
                , e1))))), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(alpha, new Entailment(e
                , e1)))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(alpha, new Entailment(e
                , e1))))), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(alpha, new Entailment(e
                , e1))))), null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(alpha, new Entailment(e
                , e1)))), null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(alpha, new Entailment(alpha, new Entailment(e
                , e1)))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(alpha, new Entailment(alpha, new Entailment(e
                , e1)))), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(alpha, new Entailment(alpha, new Entailment(e
                , e1)))))), null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(alpha, new Entailment(alpha, new Entailment(e
                , e1))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(alpha, new Entailment(alpha, new Entailment(e
                , e1)))), new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(alpha, new Entailment(alpha
                , new Entailment(e, e1)))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(alpha, new Entailment(alpha, new Entailment(e
                , e1)))), new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(alpha, new Entailment(alpha
                , new Entailment(e, e1)))))), new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(alpha, new Entailment(alpha
                , new Entailment(e, e1)))), new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(alpha, new Entailment(alpha
                , new Entailment(e, e1)))))))), null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(alpha, new Entailment(alpha, new Entailment(e
                , e1)))), new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(alpha, new Entailment(alpha
                , new Entailment(e, e1))))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(alpha, new Entailment(alpha, new Entailment(e
                , e1))))), new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(alpha, new Entailment(alpha, new Entailment(e
                , e1)))), new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(alpha, new Entailment(alpha
                , new Entailment(e, e1))))))), new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(alpha, new Entailment(alpha
                , new Entailment(e, e1)))))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(alpha, new Entailment(alpha, new Entailment(e
                , e1)))), new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(alpha, new Entailment(alpha
                , new Entailment(e, e1))))))), new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(alpha, new Entailment(alpha
                , new Entailment(e, e1))))))), null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(alpha, new Entailment(alpha
                , new Entailment(e, e1)))))), null);
        proof.addExpression(new Entailment(new Entailment(e, new Entailment(alpha
                , new Entailment(e, e1))), new Entailment(new Entailment(e
                , new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(alpha, new Entailment(alpha, new Entailment(e
                , e1))))), new Entailment(e, new Entailment(alpha, new Entailment(alpha
                , new Entailment(e, e1)))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(e, new Entailment(alpha
                , new Entailment(e, e1))), new Entailment(new Entailment(e
                , new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(alpha, new Entailment(alpha, new Entailment(e
                , e1))))), new Entailment(e, new Entailment(alpha, new Entailment(alpha
                , new Entailment(e, e1)))))), new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(new Entailment(e
                , new Entailment(alpha, new Entailment(e, e1))), new Entailment(new Entailment(e
                , new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(alpha, new Entailment(alpha, new Entailment(e
                , e1))))), new Entailment(e, new Entailment(alpha, new Entailment(alpha
                , new Entailment(e, e1)))))))), null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(e, new Entailment(alpha
                , new Entailment(e, e1))), new Entailment(new Entailment(e
                , new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(alpha, new Entailment(alpha, new Entailment(e
                , e1))))), new Entailment(e, new Entailment(alpha, new Entailment(alpha
                , new Entailment(e, e1))))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(alpha, new Entailment(e
                , e1)))), new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(e, new Entailment(alpha
                , new Entailment(e, e1))), new Entailment(new Entailment(e
                , new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(alpha, new Entailment(alpha, new Entailment(e
                , e1))))), new Entailment(e, new Entailment(alpha, new Entailment(alpha
                , new Entailment(e, e1))))))), new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(new Entailment(e
                , new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(alpha, new Entailment(alpha, new Entailment(e
                , e1))))), new Entailment(e, new Entailment(alpha, new Entailment(alpha
                , new Entailment(e, e1)))))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(e, new Entailment(alpha
                , new Entailment(e, e1))), new Entailment(new Entailment(e
                , new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(alpha, new Entailment(alpha, new Entailment(e
                , e1))))), new Entailment(e, new Entailment(alpha, new Entailment(alpha
                , new Entailment(e, e1))))))), new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(new Entailment(e
                , new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(alpha, new Entailment(alpha, new Entailment(e
                , e1))))), new Entailment(e, new Entailment(alpha, new Entailment(alpha
                , new Entailment(e, e1))))))), null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(alpha, new Entailment(alpha
                , new Entailment(e, e1))))), new Entailment(e, new Entailment(alpha
                , new Entailment(alpha, new Entailment(e, e1)))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(alpha, new Entailment(alpha
                , new Entailment(e, e1)))))), new Entailment(new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(new Entailment(e
                , new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(alpha, new Entailment(alpha, new Entailment(e
                , e1))))), new Entailment(e, new Entailment(alpha, new Entailment(alpha
                , new Entailment(e, e1)))))), new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(e, new Entailment(alpha
                , new Entailment(alpha, new Entailment(e, e1))))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(alpha, new Entailment(alpha
                , new Entailment(e, e1))))), new Entailment(e, new Entailment(alpha
                , new Entailment(alpha, new Entailment(e, e1)))))), new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(e, new Entailment(alpha
                , new Entailment(alpha, new Entailment(e, e1)))))), null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(alpha, new Entailment(alpha
                , new Entailment(e, e1))))), null);
        proof.addExpression(new Entailment(alpha, new Entailment(alpha, alpha))
                , null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(alpha
                , alpha)), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(alpha, new Entailment(alpha, alpha))))
                , null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(alpha, new Entailment(alpha, alpha)))
                , null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(alpha
                , alpha)), new Entailment(e, new Entailment(alpha, new Entailment(alpha
                , alpha)))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(alpha
                , alpha)), new Entailment(e, new Entailment(alpha, new Entailment(alpha
                , alpha)))), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(alpha, new Entailment(alpha
                , alpha)), new Entailment(e, new Entailment(alpha, new Entailment(alpha
                , alpha)))))), null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(alpha, new Entailment(alpha
                , alpha)), new Entailment(e, new Entailment(alpha, new Entailment(alpha
                , alpha))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(alpha, new Entailment(alpha, alpha)))
                , new Entailment(new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(new Entailment(alpha, new Entailment(alpha, alpha))
                , new Entailment(e, new Entailment(alpha, new Entailment(alpha
                , alpha))))), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(alpha, new Entailment(alpha
                , alpha)))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(alpha, new Entailment(alpha
                , alpha)), new Entailment(e, new Entailment(alpha, new Entailment(alpha
                , alpha))))), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(alpha, new Entailment(alpha
                , alpha))))), null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(alpha, new Entailment(alpha
                , alpha)))), null);
        proof.addExpression(new Entailment(alpha, new Entailment(new Entailment(alpha
                , alpha), alpha)), null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(new Entailment(alpha
                , alpha), alpha)), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(alpha, new Entailment(new Entailment(alpha
                , alpha), alpha)))), null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(alpha, new Entailment(new Entailment(alpha
                , alpha), alpha))), null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(new Entailment(alpha
                , alpha), alpha)), new Entailment(e, new Entailment(alpha
                , new Entailment(new Entailment(alpha, alpha), alpha)))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(new Entailment(alpha
                , alpha), alpha)), new Entailment(e, new Entailment(alpha
                , new Entailment(new Entailment(alpha, alpha), alpha)))), new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(alpha, alpha), alpha)), new Entailment(e
                , new Entailment(alpha, new Entailment(new Entailment(alpha, alpha)
                , alpha)))))), null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(alpha, new Entailment(new Entailment(alpha
                , alpha), alpha)), new Entailment(e, new Entailment(alpha
                , new Entailment(new Entailment(alpha, alpha), alpha))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(alpha, new Entailment(new Entailment(alpha
                , alpha), alpha))), new Entailment(new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(alpha, alpha), alpha)), new Entailment(e
                , new Entailment(alpha, new Entailment(new Entailment(alpha, alpha)
                , alpha))))), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(alpha, new Entailment(new Entailment(alpha
                , alpha), alpha)))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(alpha, new Entailment(new Entailment(alpha
                , alpha), alpha)), new Entailment(e, new Entailment(alpha
                , new Entailment(new Entailment(alpha, alpha), alpha))))), new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(e, new Entailment(alpha
                , new Entailment(new Entailment(alpha, alpha), alpha))))), null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(alpha, new Entailment(new Entailment(alpha
                , alpha), alpha)))), null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(alpha
                , alpha)), new Entailment(new Entailment(alpha, new Entailment(new Entailment(alpha
                , alpha), alpha)), new Entailment(alpha, alpha))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(alpha
                , alpha)), new Entailment(new Entailment(alpha, new Entailment(new Entailment(alpha
                , alpha), alpha)), new Entailment(alpha, alpha))), new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(new Entailment(alpha
                , new Entailment(alpha, alpha)), new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(alpha, alpha), alpha)), new Entailment(alpha
                , alpha))))), null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(alpha, new Entailment(alpha
                , alpha)), new Entailment(new Entailment(alpha, new Entailment(new Entailment(alpha
                , alpha), alpha)), new Entailment(alpha, alpha)))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(alpha
                , alpha)), new Entailment(new Entailment(alpha, new Entailment(new Entailment(alpha
                , alpha), alpha)), new Entailment(alpha, alpha))), new Entailment(e
                , new Entailment(new Entailment(alpha, new Entailment(alpha, alpha))
                , new Entailment(new Entailment(alpha, new Entailment(new Entailment(alpha, alpha)
                , alpha)), new Entailment(alpha, alpha))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Entailment(alpha, new Entailment(alpha
                , alpha)), new Entailment(new Entailment(alpha, new Entailment(new Entailment(alpha
                , alpha), alpha)), new Entailment(alpha, alpha))), new Entailment(e
                , new Entailment(new Entailment(alpha, new Entailment(alpha, alpha))
                , new Entailment(new Entailment(alpha, new Entailment(new Entailment(alpha, alpha)
                , alpha)), new Entailment(alpha, alpha))))), new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(new Entailment(new Entailment(alpha
                , new Entailment(alpha, alpha)), new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(alpha, alpha), alpha)), new Entailment(alpha
                , alpha))), new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(alpha, alpha)), new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(alpha, alpha), alpha)), new Entailment(alpha
                , alpha))))))), null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(new Entailment(alpha, new Entailment(alpha
                , alpha)), new Entailment(new Entailment(alpha, new Entailment(new Entailment(alpha
                , alpha), alpha)), new Entailment(alpha, alpha))), new Entailment(e
                , new Entailment(new Entailment(alpha, new Entailment(alpha, alpha))
                , new Entailment(new Entailment(alpha, new Entailment(new Entailment(alpha, alpha)
                , alpha)), new Entailment(alpha, alpha)))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(alpha, new Entailment(alpha
                , alpha)), new Entailment(new Entailment(alpha, new Entailment(new Entailment(alpha
                , alpha), alpha)), new Entailment(alpha, alpha)))), new Entailment(new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(new Entailment(new Entailment(alpha
                , new Entailment(alpha, alpha)), new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(alpha, alpha), alpha)), new Entailment(alpha
                , alpha))), new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(alpha, alpha)), new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(alpha, alpha), alpha)), new Entailment(alpha
                , alpha)))))), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(alpha, alpha)), new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(alpha, alpha), alpha)), new Entailment(alpha
                , alpha))))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(new Entailment(alpha, new Entailment(alpha
                , alpha)), new Entailment(new Entailment(alpha, new Entailment(new Entailment(alpha
                , alpha), alpha)), new Entailment(alpha, alpha))), new Entailment(e
                , new Entailment(new Entailment(alpha, new Entailment(alpha, alpha))
                , new Entailment(new Entailment(alpha, new Entailment(new Entailment(alpha, alpha)
                , alpha)), new Entailment(alpha, alpha)))))), new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(alpha, alpha)), new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(alpha, alpha), alpha)), new Entailment(alpha
                , alpha)))))), null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(alpha, alpha)), new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(alpha, alpha), alpha)), new Entailment(alpha
                , alpha))))), null);
        proof.addExpression(new Entailment(new Entailment(e, new Entailment(alpha
                , new Entailment(alpha, alpha))), new Entailment(new Entailment(e
                , new Entailment(new Entailment(alpha, new Entailment(alpha, alpha))
                , new Entailment(new Entailment(alpha, new Entailment(new Entailment(alpha, alpha)
                , alpha)), new Entailment(alpha, alpha)))), new Entailment(e
                , new Entailment(new Entailment(alpha, new Entailment(new Entailment(alpha, alpha)
                , alpha)), new Entailment(alpha, alpha))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(e, new Entailment(alpha
                , new Entailment(alpha, alpha))), new Entailment(new Entailment(e
                , new Entailment(new Entailment(alpha, new Entailment(alpha, alpha))
                , new Entailment(new Entailment(alpha, new Entailment(new Entailment(alpha, alpha)
                , alpha)), new Entailment(alpha, alpha)))), new Entailment(e
                , new Entailment(new Entailment(alpha, new Entailment(new Entailment(alpha, alpha)
                , alpha)), new Entailment(alpha, alpha))))), new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(new Entailment(e
                , new Entailment(alpha, new Entailment(alpha, alpha))), new Entailment(new Entailment(e
                , new Entailment(new Entailment(alpha, new Entailment(alpha, alpha))
                , new Entailment(new Entailment(alpha, new Entailment(new Entailment(alpha, alpha)
                , alpha)), new Entailment(alpha, alpha)))), new Entailment(e
                , new Entailment(new Entailment(alpha, new Entailment(new Entailment(alpha, alpha)
                , alpha)), new Entailment(alpha, alpha))))))), null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(e, new Entailment(alpha
                , new Entailment(alpha, alpha))), new Entailment(new Entailment(e
                , new Entailment(new Entailment(alpha, new Entailment(alpha, alpha))
                , new Entailment(new Entailment(alpha, new Entailment(new Entailment(alpha, alpha)
                , alpha)), new Entailment(alpha, alpha)))), new Entailment(e
                , new Entailment(new Entailment(alpha, new Entailment(new Entailment(alpha, alpha)
                , alpha)), new Entailment(alpha, alpha)))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(alpha, new Entailment(alpha
                , alpha)))), new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(e, new Entailment(alpha
                , new Entailment(alpha, alpha))), new Entailment(new Entailment(e
                , new Entailment(new Entailment(alpha, new Entailment(alpha, alpha))
                , new Entailment(new Entailment(alpha, new Entailment(new Entailment(alpha, alpha)
                , alpha)), new Entailment(alpha, alpha)))), new Entailment(e
                , new Entailment(new Entailment(alpha, new Entailment(new Entailment(alpha, alpha)
                , alpha)), new Entailment(alpha, alpha)))))), new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(new Entailment(e
                , new Entailment(new Entailment(alpha, new Entailment(alpha, alpha))
                , new Entailment(new Entailment(alpha, new Entailment(new Entailment(alpha, alpha)
                , alpha)), new Entailment(alpha, alpha)))), new Entailment(e
                , new Entailment(new Entailment(alpha, new Entailment(new Entailment(alpha, alpha)
                , alpha)), new Entailment(alpha, alpha))))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(e, new Entailment(alpha
                , new Entailment(alpha, alpha))), new Entailment(new Entailment(e
                , new Entailment(new Entailment(alpha, new Entailment(alpha, alpha))
                , new Entailment(new Entailment(alpha, new Entailment(new Entailment(alpha, alpha)
                , alpha)), new Entailment(alpha, alpha)))), new Entailment(e
                , new Entailment(new Entailment(alpha, new Entailment(new Entailment(alpha, alpha)
                , alpha)), new Entailment(alpha, alpha)))))), new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(new Entailment(e
                , new Entailment(new Entailment(alpha, new Entailment(alpha, alpha))
                , new Entailment(new Entailment(alpha, new Entailment(new Entailment(alpha, alpha)
                , alpha)), new Entailment(alpha, alpha)))), new Entailment(e
                , new Entailment(new Entailment(alpha, new Entailment(new Entailment(alpha, alpha)
                , alpha)), new Entailment(alpha, alpha)))))), null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(alpha, alpha)), new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(alpha, alpha), alpha)), new Entailment(alpha
                , alpha)))), new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(alpha, alpha), alpha)), new Entailment(alpha
                , alpha))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(alpha, alpha)), new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(alpha, alpha), alpha)), new Entailment(alpha
                , alpha))))), new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(alpha, alpha)), new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(alpha, alpha), alpha)), new Entailment(alpha
                , alpha)))), new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(alpha, alpha), alpha)), new Entailment(alpha
                , alpha))))), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(alpha, alpha), alpha)), new Entailment(alpha
                , alpha)))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(alpha, alpha)), new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(alpha, alpha), alpha)), new Entailment(alpha
                , alpha)))), new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(alpha, alpha), alpha)), new Entailment(alpha
                , alpha))))), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(alpha, alpha), alpha)), new Entailment(alpha
                , alpha))))), null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(alpha, alpha), alpha)), new Entailment(alpha
                , alpha)))), null);
        proof.addExpression(new Entailment(new Entailment(e, new Entailment(alpha
                , new Entailment(new Entailment(alpha, alpha), alpha))), new Entailment(new Entailment(e
                , new Entailment(new Entailment(alpha, new Entailment(new Entailment(alpha, alpha)
                , alpha)), new Entailment(alpha, alpha))), new Entailment(e
                , new Entailment(alpha, alpha)))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(e, new Entailment(alpha
                , new Entailment(new Entailment(alpha, alpha), alpha))), new Entailment(new Entailment(e
                , new Entailment(new Entailment(alpha, new Entailment(new Entailment(alpha, alpha)
                , alpha)), new Entailment(alpha, alpha))), new Entailment(e
                , new Entailment(alpha, alpha)))), new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(new Entailment(e
                , new Entailment(alpha, new Entailment(new Entailment(alpha, alpha)
                , alpha))), new Entailment(new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(alpha, alpha), alpha)), new Entailment(alpha
                , alpha))), new Entailment(e, new Entailment(alpha, alpha))))))
                , null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(e, new Entailment(alpha
                , new Entailment(new Entailment(alpha, alpha), alpha))), new Entailment(new Entailment(e
                , new Entailment(new Entailment(alpha, new Entailment(new Entailment(alpha, alpha)
                , alpha)), new Entailment(alpha, alpha))), new Entailment(e
                , new Entailment(alpha, alpha))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(alpha, new Entailment(new Entailment(alpha
                , alpha), alpha)))), new Entailment(new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(new Entailment(e
                , new Entailment(alpha, new Entailment(new Entailment(alpha, alpha)
                , alpha))), new Entailment(new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(alpha, alpha), alpha)), new Entailment(alpha
                , alpha))), new Entailment(e, new Entailment(alpha, alpha)))))
                , new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(new Entailment(e, new Entailment(new Entailment(alpha, new Entailment(new Entailment(alpha
                , alpha), alpha)), new Entailment(alpha, alpha))), new Entailment(e
                , new Entailment(alpha, alpha)))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(e, new Entailment(alpha
                , new Entailment(new Entailment(alpha, alpha), alpha))), new Entailment(new Entailment(e
                , new Entailment(new Entailment(alpha, new Entailment(new Entailment(alpha, alpha)
                , alpha)), new Entailment(alpha, alpha))), new Entailment(e
                , new Entailment(alpha, alpha))))), new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(new Entailment(e
                , new Entailment(new Entailment(alpha, new Entailment(new Entailment(alpha, alpha)
                , alpha)), new Entailment(alpha, alpha))), new Entailment(e
                , new Entailment(alpha, alpha))))), null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(alpha, alpha), alpha)), new Entailment(alpha
                , alpha))), new Entailment(e, new Entailment(alpha, alpha))))
                , null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(alpha, alpha), alpha)), new Entailment(alpha
                , alpha)))), new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(alpha, alpha), alpha)), new Entailment(alpha
                , alpha))), new Entailment(e, new Entailment(alpha, alpha))))
                , new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(e, new Entailment(alpha, alpha))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(alpha, alpha), alpha)), new Entailment(alpha
                , alpha))), new Entailment(e, new Entailment(alpha, alpha))))
                , new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(e, new Entailment(alpha, alpha)))), null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(alpha, alpha)))
                , null);
        proof.addExpression(new Entailment(e, new Entailment(e, e))
                , null);
        proof.addExpression(new Entailment(new Entailment(e, new Entailment(e
                , e)), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(e, e))))
                , null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(e, e)))
                , null);
        proof.addExpression(new Entailment(e, new Entailment(new Entailment(e
                , e), e)), null);
        proof.addExpression(new Entailment(new Entailment(e, new Entailment(new Entailment(e
                , e), e)), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(new Entailment(e
                , e), e)))), null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(new Entailment(e
                , e), e))), null);
        proof.addExpression(new Entailment(new Entailment(e, new Entailment(e
                , e)), new Entailment(new Entailment(e, new Entailment(new Entailment(e
                , e), e)), new Entailment(e, e))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(e, new Entailment(e
                , e)), new Entailment(new Entailment(e, new Entailment(new Entailment(e
                , e), e)), new Entailment(e, e))), new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(new Entailment(e
                , new Entailment(e, e)), new Entailment(new Entailment(e
                , new Entailment(new Entailment(e, e), e)), new Entailment(e
                , e))))), null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(e, new Entailment(e
                , e)), new Entailment(new Entailment(e, new Entailment(new Entailment(e
                , e), e)), new Entailment(e, e)))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(e, e)))
                , new Entailment(new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(new Entailment(e, new Entailment(e, e))
                , new Entailment(new Entailment(e, new Entailment(new Entailment(e, e)
                , e)), new Entailment(e, e)))), new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(new Entailment(e
                , new Entailment(new Entailment(e, e), e)), new Entailment(e
                , e))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(e, new Entailment(e
                , e)), new Entailment(new Entailment(e, new Entailment(new Entailment(e
                , e), e)), new Entailment(e, e)))), new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(new Entailment(e
                , new Entailment(new Entailment(e, e), e)), new Entailment(e
                , e)))), null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(e, new Entailment(new Entailment(e
                , e), e)), new Entailment(e, e))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(new Entailment(e
                , e), e))), new Entailment(new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(new Entailment(e
                , new Entailment(new Entailment(e, e), e)), new Entailment(e
                , e))), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, e)))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(e, new Entailment(new Entailment(e
                , e), e)), new Entailment(e, e))), new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(e, e)))
                , null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, e)), null);
        proof.addExpression(new Entailment(e, new Entailment(alpha, e))
                , null);
        proof.addExpression(new Entailment(new Entailment(e, new Entailment(alpha
                , e)), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(alpha, e))))
                , null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(alpha, e)))
                , null);
        proof.addExpression(new Entailment(new Entailment(e, new Entailment(alpha
                , e)), new Entailment(e, new Entailment(e, new Entailment(alpha
                , e)))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(e, new Entailment(alpha
                , e)), new Entailment(e, new Entailment(e, new Entailment(alpha
                , e)))), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(e, new Entailment(alpha
                , e)), new Entailment(e, new Entailment(e, new Entailment(alpha
                , e)))))), null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(e, new Entailment(alpha
                , e)), new Entailment(e, new Entailment(e, new Entailment(alpha
                , e))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(alpha, e)))
                , new Entailment(new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(new Entailment(e, new Entailment(alpha, e))
                , new Entailment(e, new Entailment(e, new Entailment(alpha
                , e))))), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(e, new Entailment(alpha
                , e)))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(e, new Entailment(alpha
                , e)), new Entailment(e, new Entailment(e, new Entailment(alpha
                , e))))), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(e, new Entailment(alpha
                , e))))), null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(e, new Entailment(alpha
                , e)))), null);
        proof.addExpression(new Entailment(new Entailment(e, e), new Entailment(new Entailment(e
                , new Entailment(e, new Entailment(alpha, e))), new Entailment(e
                , new Entailment(alpha, e)))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(e, e)
                , new Entailment(new Entailment(e, new Entailment(e, new Entailment(alpha
                , e))), new Entailment(e, new Entailment(alpha, e))))
                , new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(new Entailment(e, e), new Entailment(new Entailment(e
                , new Entailment(e, new Entailment(alpha, e))), new Entailment(e
                , new Entailment(alpha, e)))))), null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(e, e), new Entailment(new Entailment(e
                , new Entailment(e, new Entailment(alpha, e))), new Entailment(e
                , new Entailment(alpha, e))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, e)), new Entailment(new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(new Entailment(e
                , e), new Entailment(new Entailment(e, new Entailment(e
                , new Entailment(alpha, e))), new Entailment(e, new Entailment(alpha
                , e))))), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(e, new Entailment(e
                , new Entailment(alpha, e))), new Entailment(e, new Entailment(alpha
                , e)))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(e, e), new Entailment(new Entailment(e
                , new Entailment(e, new Entailment(alpha, e))), new Entailment(e
                , new Entailment(alpha, e))))), new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(new Entailment(e
                , new Entailment(e, new Entailment(alpha, e))), new Entailment(e
                , new Entailment(alpha, e))))), null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(e, new Entailment(e
                , new Entailment(alpha, e))), new Entailment(e, new Entailment(alpha
                , e)))), null);
        proof.addExpression(new Entailment(e, new Entailment(alpha, e))
                , null);
        proof.addExpression(new Entailment(new Entailment(e, new Entailment(alpha
                , e)), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(alpha, e))))
                , null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(alpha, e)))
                , null);
        proof.addExpression(new Entailment(new Entailment(alpha, alpha), new Entailment(new Entailment(alpha
                , new Entailment(alpha, new Entailment(e, e1))), new Entailment(alpha
                , new Entailment(e, e1)))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, alpha)
                , new Entailment(new Entailment(alpha, new Entailment(alpha, new Entailment(e
                , e1))), new Entailment(alpha, new Entailment(e, e1))))
                , new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(new Entailment(alpha, alpha), new Entailment(new Entailment(alpha
                , new Entailment(alpha, new Entailment(e, e1))), new Entailment(alpha
                , new Entailment(e, e1)))))), null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(alpha, alpha), new Entailment(new Entailment(alpha
                , new Entailment(alpha, new Entailment(e, e1))), new Entailment(alpha
                , new Entailment(e, e1))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, alpha)
                , new Entailment(new Entailment(alpha, new Entailment(alpha, new Entailment(e
                , e1))), new Entailment(alpha, new Entailment(e, e1))))
                , new Entailment(e, new Entailment(new Entailment(alpha, alpha)
                , new Entailment(new Entailment(alpha, new Entailment(alpha, new Entailment(e
                , e1))), new Entailment(alpha, new Entailment(e, e1))))))
                , null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Entailment(alpha, alpha)
                , new Entailment(new Entailment(alpha, new Entailment(alpha, new Entailment(e
                , e1))), new Entailment(alpha, new Entailment(e, e1))))
                , new Entailment(e, new Entailment(new Entailment(alpha, alpha)
                , new Entailment(new Entailment(alpha, new Entailment(alpha, new Entailment(e
                , e1))), new Entailment(alpha, new Entailment(e, e1))))))
                , new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(new Entailment(new Entailment(alpha, alpha), new Entailment(new Entailment(alpha
                , new Entailment(alpha, new Entailment(e, e1))), new Entailment(alpha
                , new Entailment(e, e1)))), new Entailment(e, new Entailment(new Entailment(alpha
                , alpha), new Entailment(new Entailment(alpha, new Entailment(alpha
                , new Entailment(e, e1))), new Entailment(alpha, new Entailment(e
                , e1)))))))), null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(new Entailment(alpha, alpha)
                , new Entailment(new Entailment(alpha, new Entailment(alpha, new Entailment(e
                , e1))), new Entailment(alpha, new Entailment(e, e1))))
                , new Entailment(e, new Entailment(new Entailment(alpha, alpha)
                , new Entailment(new Entailment(alpha, new Entailment(alpha, new Entailment(e
                , e1))), new Entailment(alpha, new Entailment(e, e1)))))))
                , null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(alpha, alpha), new Entailment(new Entailment(alpha
                , new Entailment(alpha, new Entailment(e, e1))), new Entailment(alpha
                , new Entailment(e, e1))))), new Entailment(new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(new Entailment(new Entailment(alpha
                , alpha), new Entailment(new Entailment(alpha, new Entailment(alpha
                , new Entailment(e, e1))), new Entailment(alpha, new Entailment(e
                , e1)))), new Entailment(e, new Entailment(new Entailment(alpha
                , alpha), new Entailment(new Entailment(alpha, new Entailment(alpha
                , new Entailment(e, e1))), new Entailment(alpha, new Entailment(e
                , e1))))))), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(new Entailment(alpha
                , alpha), new Entailment(new Entailment(alpha, new Entailment(alpha
                , new Entailment(e, e1))), new Entailment(alpha, new Entailment(e
                , e1)))))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(new Entailment(alpha, alpha)
                , new Entailment(new Entailment(alpha, new Entailment(alpha, new Entailment(e
                , e1))), new Entailment(alpha, new Entailment(e, e1))))
                , new Entailment(e, new Entailment(new Entailment(alpha, alpha)
                , new Entailment(new Entailment(alpha, new Entailment(alpha, new Entailment(e
                , e1))), new Entailment(alpha, new Entailment(e, e1)))))))
                , new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(e, new Entailment(new Entailment(alpha, alpha)
                , new Entailment(new Entailment(alpha, new Entailment(alpha, new Entailment(e
                , e1))), new Entailment(alpha, new Entailment(e, e1)))))))
                , null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(new Entailment(alpha
                , alpha), new Entailment(new Entailment(alpha, new Entailment(alpha
                , new Entailment(e, e1))), new Entailment(alpha, new Entailment(e
                , e1)))))), null);
        proof.addExpression(new Entailment(new Entailment(e, new Entailment(alpha
                , alpha)), new Entailment(new Entailment(e, new Entailment(new Entailment(alpha
                , alpha), new Entailment(new Entailment(alpha, new Entailment(alpha
                , new Entailment(e, e1))), new Entailment(alpha, new Entailment(e
                , e1))))), new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(alpha, new Entailment(e, e1))), new Entailment(alpha
                , new Entailment(e, e1)))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(e, new Entailment(alpha
                , alpha)), new Entailment(new Entailment(e, new Entailment(new Entailment(alpha
                , alpha), new Entailment(new Entailment(alpha, new Entailment(alpha
                , new Entailment(e, e1))), new Entailment(alpha, new Entailment(e
                , e1))))), new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(alpha, new Entailment(e, e1))), new Entailment(alpha
                , new Entailment(e, e1)))))), new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(new Entailment(e
                , new Entailment(alpha, alpha)), new Entailment(new Entailment(e
                , new Entailment(new Entailment(alpha, alpha), new Entailment(new Entailment(alpha
                , new Entailment(alpha, new Entailment(e, e1))), new Entailment(alpha
                , new Entailment(e, e1))))), new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(alpha, new Entailment(e, e1))), new Entailment(alpha
                , new Entailment(e, e1)))))))), null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(e, new Entailment(alpha
                , alpha)), new Entailment(new Entailment(e, new Entailment(new Entailment(alpha
                , alpha), new Entailment(new Entailment(alpha, new Entailment(alpha
                , new Entailment(e, e1))), new Entailment(alpha, new Entailment(e
                , e1))))), new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(alpha, new Entailment(e, e1))), new Entailment(alpha
                , new Entailment(e, e1))))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(alpha, alpha)))
                , new Entailment(new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(new Entailment(e, new Entailment(alpha, alpha))
                , new Entailment(new Entailment(e, new Entailment(new Entailment(alpha, alpha)
                , new Entailment(new Entailment(alpha, new Entailment(alpha, new Entailment(e
                , e1))), new Entailment(alpha, new Entailment(e, e1)))))
                , new Entailment(e, new Entailment(new Entailment(alpha, new Entailment(alpha
                , new Entailment(e, e1))), new Entailment(alpha, new Entailment(e
                , e1))))))), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(e, new Entailment(new Entailment(alpha
                , alpha), new Entailment(new Entailment(alpha, new Entailment(alpha
                , new Entailment(e, e1))), new Entailment(alpha, new Entailment(e
                , e1))))), new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(alpha, new Entailment(e, e1))), new Entailment(alpha
                , new Entailment(e, e1)))))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(e, new Entailment(alpha
                , alpha)), new Entailment(new Entailment(e, new Entailment(new Entailment(alpha
                , alpha), new Entailment(new Entailment(alpha, new Entailment(alpha
                , new Entailment(e, e1))), new Entailment(alpha, new Entailment(e
                , e1))))), new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(alpha, new Entailment(e, e1))), new Entailment(alpha
                , new Entailment(e, e1))))))), new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(new Entailment(e
                , new Entailment(new Entailment(alpha, alpha), new Entailment(new Entailment(alpha
                , new Entailment(alpha, new Entailment(e, e1))), new Entailment(alpha
                , new Entailment(e, e1))))), new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(alpha, new Entailment(e, e1))), new Entailment(alpha
                , new Entailment(e, e1))))))), null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(e, new Entailment(new Entailment(alpha
                , alpha), new Entailment(new Entailment(alpha, new Entailment(alpha
                , new Entailment(e, e1))), new Entailment(alpha, new Entailment(e
                , e1))))), new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(alpha, new Entailment(e, e1))), new Entailment(alpha
                , new Entailment(e, e1)))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(new Entailment(alpha
                , alpha), new Entailment(new Entailment(alpha, new Entailment(alpha
                , new Entailment(e, e1))), new Entailment(alpha, new Entailment(e
                , e1)))))), new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(e, new Entailment(new Entailment(alpha
                , alpha), new Entailment(new Entailment(alpha, new Entailment(alpha
                , new Entailment(e, e1))), new Entailment(alpha, new Entailment(e
                , e1))))), new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(alpha, new Entailment(e, e1))), new Entailment(alpha
                , new Entailment(e, e1)))))), new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(alpha, new Entailment(e, e1))), new Entailment(alpha
                , new Entailment(e, e1))))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(e, new Entailment(new Entailment(alpha
                , alpha), new Entailment(new Entailment(alpha, new Entailment(alpha
                , new Entailment(e, e1))), new Entailment(alpha, new Entailment(e
                , e1))))), new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(alpha, new Entailment(e, e1))), new Entailment(alpha
                , new Entailment(e, e1)))))), new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(alpha, new Entailment(e, e1))), new Entailment(alpha
                , new Entailment(e, e1)))))), null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(alpha, new Entailment(e, e1))), new Entailment(alpha
                , new Entailment(e, e1))))), null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(alpha, new Entailment(e, e1))))
                , null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(alpha, new Entailment(e, e1)))
                , new Entailment(alpha, new Entailment(e, e1)))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(alpha, new Entailment(e, e1))))
                , new Entailment(new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(alpha, new Entailment(e, e1))), new Entailment(alpha
                , new Entailment(e, e1)))), new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(alpha, new Entailment(e
                , e1))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(alpha, new Entailment(e, e1)))
                , new Entailment(alpha, new Entailment(e, e1)))), new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(alpha, new Entailment(e
                , e1)))), null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(alpha, new Entailment(e, e1)))
                , null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(alpha, new Entailment(e
                , e1)))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(alpha, new Entailment(e
                , e1)))), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(alpha, new Entailment(e
                , e1)))))), null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(alpha, new Entailment(e
                , e1))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(alpha, new Entailment(e, e1)))
                , new Entailment(new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(e, new Entailment(alpha, new Entailment(e
                , e1))))), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(alpha, new Entailment(e
                , e1)))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(alpha, new Entailment(e
                , e1))))), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(alpha, new Entailment(e
                , e1))))), null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(alpha, new Entailment(e
                , e1)))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(alpha, new Entailment(e, e1)))
                , new Entailment(new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(e, new Entailment(alpha, new Entailment(e
                , e1))))), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(alpha, new Entailment(e
                , e1)))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(alpha, new Entailment(e
                , e1))))), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(alpha, new Entailment(e
                , e1))))), null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(alpha, new Entailment(e
                , e1)))), null);
        proof.addExpression(new Entailment(new Entailment(alpha, e), new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(alpha, e1)))
                , null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, e)
                , new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(alpha, e1))), new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(new Entailment(alpha
                , e), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(alpha, e1))))), null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(alpha, e), new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(alpha, e1))))
                , null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, e)
                , new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(alpha, e1))), new Entailment(e, new Entailment(new Entailment(alpha
                , e), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(alpha, e1))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Entailment(alpha, e)
                , new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(alpha, e1))), new Entailment(e, new Entailment(new Entailment(alpha
                , e), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(alpha, e1))))), new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(new Entailment(new Entailment(alpha
                , e), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(alpha, e1))), new Entailment(e
                , new Entailment(new Entailment(alpha, e), new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(alpha, e1)))))))
                , null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(new Entailment(alpha, e)
                , new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(alpha, e1))), new Entailment(e, new Entailment(new Entailment(alpha
                , e), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(alpha, e1)))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(alpha, e), new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(alpha, e1))))
                , new Entailment(new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(new Entailment(new Entailment(alpha, e), new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(alpha, e1)))
                , new Entailment(e, new Entailment(new Entailment(alpha, e)
                , new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(alpha, e1)))))), new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(e, new Entailment(new Entailment(alpha
                , e), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(alpha, e1))))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(new Entailment(alpha, e)
                , new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(alpha, e1))), new Entailment(e, new Entailment(new Entailment(alpha
                , e), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(alpha, e1)))))), new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(e, new Entailment(new Entailment(alpha
                , e), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(alpha, e1)))))), null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(new Entailment(alpha
                , e), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(alpha, e1))))), null);
        proof.addExpression(new Entailment(new Entailment(e, new Entailment(alpha
                , e)), new Entailment(new Entailment(e, new Entailment(new Entailment(alpha
                , e), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(alpha, e1)))), new Entailment(e
                , new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(alpha, e1))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(e, new Entailment(alpha
                , e)), new Entailment(new Entailment(e, new Entailment(new Entailment(alpha
                , e), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(alpha, e1)))), new Entailment(e
                , new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(alpha, e1))))), new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(new Entailment(e
                , new Entailment(alpha, e)), new Entailment(new Entailment(e
                , new Entailment(new Entailment(alpha, e), new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(alpha, e1))))
                , new Entailment(e, new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(alpha, e1))))))), null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(e, new Entailment(alpha
                , e)), new Entailment(new Entailment(e, new Entailment(new Entailment(alpha
                , e), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(alpha, e1)))), new Entailment(e
                , new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(alpha, e1)))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(alpha, e)))
                , new Entailment(new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(new Entailment(e, new Entailment(alpha, e))
                , new Entailment(new Entailment(e, new Entailment(new Entailment(alpha, e)
                , new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(alpha, e1)))), new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(alpha, e1))))))
                , new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(new Entailment(e, new Entailment(new Entailment(alpha, e)
                , new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(alpha, e1)))), new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(alpha, e1)))))))
                , null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(e, new Entailment(alpha
                , e)), new Entailment(new Entailment(e, new Entailment(new Entailment(alpha
                , e), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(alpha, e1)))), new Entailment(e
                , new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(alpha, e1)))))), new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(new Entailment(e
                , new Entailment(new Entailment(alpha, e), new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(alpha, e1))))
                , new Entailment(e, new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(alpha, e1)))))), null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(e, new Entailment(new Entailment(alpha
                , e), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(alpha, e1)))), new Entailment(e
                , new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(alpha, e1))))), null);
    }

    public static void addExistsProof2(Expression alpha, Expression e, Expression e1, Term variable, Proof proof) {
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(alpha, e)))
                , new Entailment(new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(new Entailment(e, new Entailment(alpha, e))
                , new Entailment(new Entailment(e, new Entailment(new Entailment(alpha, e)
                , new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(alpha, e1)))), new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(alpha, e1))))))
                , new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(new Entailment(e, new Entailment(new Entailment(alpha, e)
                , new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(alpha, e1)))), new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(alpha, e1)))))))
                , null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(e, new Entailment(alpha
                , e)), new Entailment(new Entailment(e, new Entailment(new Entailment(alpha
                , e), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(alpha, e1)))), new Entailment(e
                , new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(alpha, e1)))))), new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(new Entailment(e
                , new Entailment(new Entailment(alpha, e), new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(alpha, e1))))
                , new Entailment(e, new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(alpha, e1)))))), null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(e, new Entailment(new Entailment(alpha
                , e), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(alpha, e1)))), new Entailment(e
                , new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(alpha, e1))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(new Entailment(alpha
                , e), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(alpha, e1))))), new Entailment(new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(new Entailment(e
                , new Entailment(new Entailment(alpha, e), new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(alpha, e1))))
                , new Entailment(e, new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(alpha, e1))))), new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(alpha, e1))))))
                , null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(e, new Entailment(new Entailment(alpha
                , e), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(alpha, e1)))), new Entailment(e
                , new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(alpha, e1))))), new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(alpha, e1)))))
                , null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(alpha, e1))))
                , null);
        proof.addExpression(new Entailment(new Entailment(e, new Entailment(alpha
                , new Entailment(e, e1))), new Entailment(new Entailment(e
                , new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(alpha, e1))), new Entailment(e, new Entailment(alpha
                , e1)))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(e, new Entailment(alpha
                , new Entailment(e, e1))), new Entailment(new Entailment(e
                , new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(alpha, e1))), new Entailment(e, new Entailment(alpha
                , e1)))), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(e, new Entailment(alpha
                , new Entailment(e, e1))), new Entailment(new Entailment(e
                , new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(alpha, e1))), new Entailment(e, new Entailment(alpha
                , e1)))))), null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(e, new Entailment(alpha
                , new Entailment(e, e1))), new Entailment(new Entailment(e
                , new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(alpha, e1))), new Entailment(e, new Entailment(alpha
                , e1))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(alpha, new Entailment(e
                , e1)))), new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(e, new Entailment(alpha
                , new Entailment(e, e1))), new Entailment(new Entailment(e
                , new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(alpha, e1))), new Entailment(e, new Entailment(alpha
                , e1))))), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(alpha, e1)))
                , new Entailment(e, new Entailment(alpha, e1)))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(e, new Entailment(alpha
                , new Entailment(e, e1))), new Entailment(new Entailment(e
                , new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(alpha, e1))), new Entailment(e, new Entailment(alpha
                , e1))))), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(alpha, e1)))
                , new Entailment(e, new Entailment(alpha, e1))))), null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(alpha, e1)))
                , new Entailment(e, new Entailment(alpha, e1)))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(alpha, new Entailment(e
                , e1)))), new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(e, new Entailment(alpha
                , new Entailment(e, e1))), new Entailment(new Entailment(e
                , new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(alpha, e1))), new Entailment(e, new Entailment(alpha
                , e1))))), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(alpha, e1)))
                , new Entailment(e, new Entailment(alpha, e1)))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(e, new Entailment(alpha
                , new Entailment(e, e1))), new Entailment(new Entailment(e
                , new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(alpha, e1))), new Entailment(e, new Entailment(alpha
                , e1))))), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(alpha, e1)))
                , new Entailment(e, new Entailment(alpha, e1))))), null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(alpha, e1)))
                , new Entailment(e, new Entailment(alpha, e1)))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(alpha, e1))))
                , new Entailment(new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(new Entailment(e, new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(alpha, e1))), new Entailment(e
                , new Entailment(alpha, e1)))), new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(e, new Entailment(alpha
                , e1))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(alpha, e1)))
                , new Entailment(e, new Entailment(alpha, e1)))), new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(e, new Entailment(alpha
                , e1)))), null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(alpha, e1)))
                , null);
        proof.addExpression(new Entailment(new Entailment(e, new Entailment(alpha
                , new Entailment(e, e1))), new Entailment(new Entailment(e
                , new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(alpha, e1))), new Entailment(e, new Entailment(alpha
                , e1)))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(e, new Entailment(alpha
                , new Entailment(e, e1))), new Entailment(new Entailment(e
                , new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(alpha, e1))), new Entailment(e, new Entailment(alpha
                , e1)))), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(e, new Entailment(alpha
                , new Entailment(e, e1))), new Entailment(new Entailment(e
                , new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(alpha, e1))), new Entailment(e, new Entailment(alpha
                , e1)))))), null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(e, new Entailment(alpha
                , new Entailment(e, e1))), new Entailment(new Entailment(e
                , new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(alpha, e1))), new Entailment(e, new Entailment(alpha
                , e1))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(alpha, new Entailment(e
                , e1)))), new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(e, new Entailment(alpha
                , new Entailment(e, e1))), new Entailment(new Entailment(e
                , new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(alpha, e1))), new Entailment(e, new Entailment(alpha
                , e1))))), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(alpha, e1)))
                , new Entailment(e, new Entailment(alpha, e1)))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(e, new Entailment(alpha
                , new Entailment(e, e1))), new Entailment(new Entailment(e
                , new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(alpha, e1))), new Entailment(e, new Entailment(alpha
                , e1))))), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(alpha, e1)))
                , new Entailment(e, new Entailment(alpha, e1))))), null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(alpha, e1)))
                , new Entailment(e, new Entailment(alpha, e1)))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(alpha, new Entailment(e
                , e1)))), new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(e, new Entailment(alpha
                , new Entailment(e, e1))), new Entailment(new Entailment(e
                , new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(alpha, e1))), new Entailment(e, new Entailment(alpha
                , e1))))), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(alpha, e1)))
                , new Entailment(e, new Entailment(alpha, e1)))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(e, new Entailment(alpha
                , new Entailment(e, e1))), new Entailment(new Entailment(e
                , new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(alpha, e1))), new Entailment(e, new Entailment(alpha
                , e1))))), new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(alpha, e1)))
                , new Entailment(e, new Entailment(alpha, e1))))), null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(alpha, e1)))
                , new Entailment(e, new Entailment(alpha, e1)))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(alpha, e1))))
                , new Entailment(new Entailment(new Entailment(alpha, new Entailment(e, e1))
                , new Entailment(new Entailment(e, new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(alpha, e1))), new Entailment(e
                , new Entailment(alpha, e1)))), new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(e, new Entailment(alpha
                , e1))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(new Entailment(e, new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(alpha, e1)))
                , new Entailment(e, new Entailment(alpha, e1)))), new Entailment(new Entailment(alpha
                , new Entailment(e, e1)), new Entailment(e, new Entailment(alpha
                , e1)))), null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(e
                , e1)), new Entailment(e, new Entailment(alpha, e1)))
                , null);
        proof.addExpression(new Entailment(alpha, new Entailment(e, e1))
                , null);
        proof.addExpression(new Entailment(e, new Entailment(alpha, e1))
                , null);
        proof.addExpression(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)))), null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1))), new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)))), new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1))), new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)))), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1))), new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)))), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)))), null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1))), null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)))), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)))))), null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1))), new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1))))), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1))))), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1))))), null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)))), null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Exists(variable,e), new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1))))
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Exists(variable,e), new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)))))), null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Exists(variable,e), new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1))))
                , new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1))))))
                , null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1))))
                , new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1))))))
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1))))
                , new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1))))))))
                , null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1))))
                , new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))))))
                , null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))))
                , new Entailment(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1))))
                , new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))))))
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1))))))))
                , null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1))))
                , new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))))))
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))))))
                , null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1))))))
                , null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1))), new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Exists(variable,e), new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1))))), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1))))))
                , null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1))), new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Exists(variable,e), new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1))))), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1))))))
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1))), new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Exists(variable,e), new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1))))), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1))))))))
                , null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1))), new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Exists(variable,e), new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1))))), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))))))
                , null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)))), new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(alpha
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))
                , new Entailment(new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))))
                , new Entailment(alpha, new Entailment(new Exists(variable,e), new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1))))))), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Exists(variable,e), new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1))))), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1))))))))
                , null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(alpha
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))
                , new Entailment(new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))))
                , new Entailment(alpha, new Entailment(new Exists(variable,e), new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1))))))), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Exists(variable,e), new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1))))), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))))))
                , null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))))
                , new Entailment(alpha, new Entailment(new Exists(variable,e), new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1))))))
                , new Entailment(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))))
                , new Entailment(alpha, new Entailment(new Exists(variable,e), new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)))))), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))))))
                , null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Exists(variable,e), new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1))))), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1))))))
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1))))))
                , null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))))
                , null);
        proof.addExpression(new Entailment(new Exists(variable,e), new Entailment(new Exists(variable,e)
                , new Exists(variable,e))), null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(new Exists(variable,e)
                , new Exists(variable,e))), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Exists(variable,e)))))
                , null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Exists(variable,e), new Entailment(new Exists(variable,e)
                , new Exists(variable,e)))), null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(new Exists(variable,e)
                , new Exists(variable,e))), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Exists(variable,e)))))
                , null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Exists(variable,e)))
                , new Entailment(alpha, new Entailment(new Exists(variable,e), new Entailment(new Exists(variable,e)
                , new Exists(variable,e))))), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Exists(variable,e)))
                , new Entailment(alpha, new Entailment(new Exists(variable,e), new Entailment(new Exists(variable,e)
                , new Exists(variable,e))))))), null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(new Exists(variable,e), new Entailment(new Exists(variable,e)
                , new Exists(variable,e))), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Exists(variable,e))))))
                , null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Exists(variable,e))))
                , new Entailment(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(new Exists(variable,e), new Entailment(new Exists(variable,e)
                , new Exists(variable,e))), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Exists(variable,e))))))
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Exists(variable,e)))))))
                , null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Exists(variable,e)))
                , new Entailment(alpha, new Entailment(new Exists(variable,e), new Entailment(new Exists(variable,e)
                , new Exists(variable,e)))))), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Exists(variable,e))))))
                , null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Exists(variable,e)))))
                , null);
        proof.addExpression(new Entailment(new Exists(variable,e), new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , new Entailment(new Entailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))))), null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Exists(variable,e), new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e)))), null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new Entailment(alpha
                , new Entailment(new Exists(variable,e), new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Entailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(new Entailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))))), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Entailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(new Entailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))))))), null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(new Exists(variable,e), new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new Entailment(alpha
                , new Entailment(new Exists(variable,e), new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e)))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , new Entailment(new Entailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e)))), new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Entailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(new Entailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e)))))), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(new Entailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Entailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(new Entailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e)))))), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(new Entailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e)))))), null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(new Entailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))))), null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(new Exists(variable,e)
                , new Exists(variable,e))), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Entailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))), new Entailment(new Exists(variable,e)
                , new Exists(variable,e)))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Exists(variable,e)))
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new Entailment(new Exists(variable,e)
                , new Exists(variable,e)))), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Exists(variable,e)))
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new Entailment(new Exists(variable,e)
                , new Exists(variable,e)))))), null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(new Exists(variable,e), new Entailment(new Exists(variable,e)
                , new Exists(variable,e))), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Entailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))), new Entailment(new Exists(variable,e)
                , new Exists(variable,e))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Exists(variable,e)))
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new Entailment(new Exists(variable,e)
                , new Exists(variable,e)))), new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Exists(variable,e)))
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new Entailment(new Exists(variable,e)
                , new Exists(variable,e)))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Exists(variable,e)))
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new Entailment(new Exists(variable,e)
                , new Exists(variable,e)))), new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Exists(variable,e)))
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new Entailment(new Exists(variable,e)
                , new Exists(variable,e)))))), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Exists(variable,e)))
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new Entailment(new Exists(variable,e)
                , new Exists(variable,e)))), new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Exists(variable,e)))
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new Entailment(new Exists(variable,e)
                , new Exists(variable,e)))))))), null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Exists(variable,e)))
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new Entailment(new Exists(variable,e)
                , new Exists(variable,e)))), new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Exists(variable,e)))
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new Entailment(new Exists(variable,e)
                , new Exists(variable,e))))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Exists(variable,e)))
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new Entailment(new Exists(variable,e)
                , new Exists(variable,e))))), new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Exists(variable,e)))
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new Entailment(new Exists(variable,e)
                , new Exists(variable,e)))), new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Exists(variable,e)))
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new Entailment(new Exists(variable,e)
                , new Exists(variable,e))))))), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Exists(variable,e)))
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new Entailment(new Exists(variable,e)
                , new Exists(variable,e)))))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Exists(variable,e)))
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new Entailment(new Exists(variable,e)
                , new Exists(variable,e)))), new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Exists(variable,e)))
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new Entailment(new Exists(variable,e)
                , new Exists(variable,e))))))), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Exists(variable,e)))
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new Entailment(new Exists(variable,e)
                , new Exists(variable,e))))))), null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Exists(variable,e)))
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new Entailment(new Exists(variable,e)
                , new Exists(variable,e)))))), null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Exists(variable,e))))
                , new Entailment(new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Exists(variable,e)))
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new Entailment(new Exists(variable,e)
                , new Exists(variable,e))))), new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Entailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))), new Entailment(new Exists(variable,e)
                , new Exists(variable,e)))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Exists(variable,e))))
                , new Entailment(new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Exists(variable,e)))
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new Entailment(new Exists(variable,e)
                , new Exists(variable,e))))), new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Entailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))), new Entailment(new Exists(variable,e)
                , new Exists(variable,e)))))), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(alpha
                , new Entailment(new Exists(variable,e), new Entailment(new Exists(variable,e)
                , new Exists(variable,e)))), new Entailment(new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Exists(variable,e)))
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new Entailment(new Exists(variable,e)
                , new Exists(variable,e))))), new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Entailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))), new Entailment(new Exists(variable,e)
                , new Exists(variable,e)))))))), null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Exists(variable,e))))
                , new Entailment(new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Exists(variable,e)))
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new Entailment(new Exists(variable,e)
                , new Exists(variable,e))))), new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Entailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))), new Entailment(new Exists(variable,e)
                , new Exists(variable,e))))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Exists(variable,e)))))
                , new Entailment(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Exists(variable,e))))
                , new Entailment(new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Exists(variable,e)))
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new Entailment(new Exists(variable,e)
                , new Exists(variable,e))))), new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Entailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))), new Entailment(new Exists(variable,e)
                , new Exists(variable,e))))))), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(new Exists(variable,e)
                , new Exists(variable,e))), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Entailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))), new Entailment(new Exists(variable,e)
                , new Exists(variable,e))))), new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Entailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))), new Entailment(new Exists(variable,e)
                , new Exists(variable,e)))))))), null);
    }

    public static void addExistsProof3(Expression alpha, Expression e, Expression e1, Term variable, Proof proof) {
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(alpha
                , new Entailment(new Exists(variable,e), new Entailment(new Exists(variable,e)
                , new Exists(variable,e)))), new Entailment(new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Exists(variable,e)))
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new Entailment(new Exists(variable,e)
                , new Exists(variable,e))))), new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Entailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))), new Entailment(new Exists(variable,e)
                , new Exists(variable,e))))))), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(new Exists(variable,e)
                , new Exists(variable,e))), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Entailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))), new Entailment(new Exists(variable,e)
                , new Exists(variable,e))))), new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Entailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))), new Entailment(new Exists(variable,e)
                , new Exists(variable,e))))))), null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Exists(variable,e)))
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new Entailment(new Exists(variable,e)
                , new Exists(variable,e))))), new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Entailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))), new Entailment(new Exists(variable,e)
                , new Exists(variable,e)))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Exists(variable,e)))
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new Entailment(new Exists(variable,e)
                , new Exists(variable,e)))))), new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(new Exists(variable,e)
                , new Exists(variable,e))), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Entailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))), new Entailment(new Exists(variable,e)
                , new Exists(variable,e))))), new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Entailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))), new Entailment(new Exists(variable,e)
                , new Exists(variable,e)))))), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Entailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))), new Entailment(new Exists(variable,e)
                , new Exists(variable,e))))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(new Exists(variable,e)
                , new Exists(variable,e))), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Entailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))), new Entailment(new Exists(variable,e)
                , new Exists(variable,e))))), new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Entailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))), new Entailment(new Exists(variable,e)
                , new Exists(variable,e)))))), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Entailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))), new Entailment(new Exists(variable,e)
                , new Exists(variable,e)))))), null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Entailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))), new Entailment(new Exists(variable,e)
                , new Exists(variable,e))))), null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(new Entailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e)))), new Entailment(new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Entailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))), new Entailment(new Exists(variable,e)
                , new Exists(variable,e)))), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Exists(variable,e))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(new Entailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e)))), new Entailment(new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Entailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))), new Entailment(new Exists(variable,e)
                , new Exists(variable,e)))), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Exists(variable,e))))), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(alpha
                , new Entailment(new Exists(variable,e), new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e)))), new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new Entailment(new Exists(variable,e)
                , new Exists(variable,e)))), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Exists(variable,e))))))), null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(new Entailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e)))), new Entailment(new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Entailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))), new Entailment(new Exists(variable,e)
                , new Exists(variable,e)))), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Exists(variable,e)))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(new Entailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))))), new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(alpha
                , new Entailment(new Exists(variable,e), new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e)))), new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new Entailment(new Exists(variable,e)
                , new Exists(variable,e)))), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Exists(variable,e)))))), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new Entailment(new Exists(variable,e)
                , new Exists(variable,e)))), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Exists(variable,e))))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(alpha
                , new Entailment(new Exists(variable,e), new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e)))), new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new Entailment(new Exists(variable,e)
                , new Exists(variable,e)))), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Exists(variable,e)))))), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new Entailment(new Exists(variable,e)
                , new Exists(variable,e)))), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Exists(variable,e)))))), null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Entailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))), new Entailment(new Exists(variable,e)
                , new Exists(variable,e)))), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Exists(variable,e))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Entailment(new Exists(variable,e), new Exists(variable,e))
                , new Exists(variable,e))), new Entailment(new Exists(variable,e)
                , new Exists(variable,e))))), new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new Entailment(new Exists(variable,e)
                , new Exists(variable,e)))), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Exists(variable,e))))), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Exists(variable,e)))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Exists(variable,e))), new Entailment(new Exists(variable,e)
                , new Exists(variable,e)))), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Exists(variable,e))))), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Exists(variable,e))))), null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Exists(variable,e)))), null);
        proof.addExpression(new Entailment(alpha, new Entailment(alpha, alpha))
                , null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(alpha
                , alpha)), new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(alpha, new Entailment(alpha, alpha))))
                , null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(alpha, new Entailment(alpha, alpha)))
                , null);
        proof.addExpression(new Entailment(alpha, new Entailment(new Entailment(alpha
                , alpha), alpha)), null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(new Entailment(alpha
                , alpha), alpha)), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(alpha, new Entailment(new Entailment(alpha
                , alpha), alpha)))), null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(alpha, new Entailment(new Entailment(alpha
                , alpha), alpha))), null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(alpha
                , alpha)), new Entailment(new Entailment(alpha, new Entailment(new Entailment(alpha
                , alpha), alpha)), new Entailment(alpha, alpha))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(alpha
                , alpha)), new Entailment(new Entailment(alpha, new Entailment(new Entailment(alpha
                , alpha), alpha)), new Entailment(alpha, alpha))), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(alpha
                , new Entailment(alpha, alpha)), new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(alpha, alpha), alpha)), new Entailment(alpha
                , alpha))))), null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(alpha, new Entailment(alpha
                , alpha)), new Entailment(new Entailment(alpha, new Entailment(new Entailment(alpha
                , alpha), alpha)), new Entailment(alpha, alpha)))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(alpha, new Entailment(alpha
                , alpha))), new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(alpha
                , new Entailment(alpha, alpha)), new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(alpha, alpha), alpha)), new Entailment(alpha
                , alpha)))), new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(alpha, new Entailment(new Entailment(alpha
                , alpha), alpha)), new Entailment(alpha, alpha))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(alpha
                , new Entailment(alpha, alpha)), new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(alpha, alpha), alpha)), new Entailment(alpha
                , alpha)))), new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(alpha, new Entailment(new Entailment(alpha
                , alpha), alpha)), new Entailment(alpha, alpha)))), null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(alpha, new Entailment(new Entailment(alpha
                , alpha), alpha)), new Entailment(alpha, alpha))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(alpha, new Entailment(new Entailment(alpha
                , alpha), alpha))), new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(alpha, alpha), alpha)), new Entailment(alpha
                , alpha))), new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(alpha, alpha)))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(alpha, alpha), alpha)), new Entailment(alpha
                , alpha))), new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(alpha, alpha))), null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(alpha, alpha)), null);
        proof.addExpression(new Entailment(alpha, new Entailment(new Exists(variable,e)
                , alpha)), null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(new Exists(variable,e)
                , alpha)), new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , alpha)))), null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , alpha))), null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(new Exists(variable,e)
                , alpha)), new Entailment(alpha, new Entailment(alpha, new Entailment(new Exists(variable,e)
                , alpha)))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(new Exists(variable,e)
                , alpha)), new Entailment(alpha, new Entailment(alpha, new Entailment(new Exists(variable,e)
                , alpha)))), new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(alpha, new Entailment(new Exists(variable,e)
                , alpha)), new Entailment(alpha, new Entailment(alpha, new Entailment(new Exists(variable,e)
                , alpha)))))), null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(alpha, new Entailment(new Exists(variable,e)
                , alpha)), new Entailment(alpha, new Entailment(alpha, new Entailment(new Exists(variable,e)
                , alpha))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , alpha))), new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(alpha
                , new Entailment(new Exists(variable,e), alpha)), new Entailment(alpha
                , new Entailment(alpha, new Entailment(new Exists(variable,e), alpha)))))
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(alpha, new Entailment(alpha, new Entailment(new Exists(variable,e)
                , alpha)))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(alpha
                , new Entailment(new Exists(variable,e), alpha)), new Entailment(alpha
                , new Entailment(alpha, new Entailment(new Exists(variable,e), alpha)))))
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(alpha, new Entailment(alpha, new Entailment(new Exists(variable,e)
                , alpha))))), null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(alpha, new Entailment(alpha, new Entailment(new Exists(variable,e)
                , alpha)))), null);
        proof.addExpression(new Entailment(new Entailment(alpha, alpha), new Entailment(new Entailment(alpha
                , new Entailment(alpha, new Entailment(new Exists(variable,e), alpha)))
                , new Entailment(alpha, new Entailment(new Exists(variable,e), alpha))))
                , null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, alpha)
                , new Entailment(new Entailment(alpha, new Entailment(alpha, new Entailment(new Exists(variable,e)
                , alpha))), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , alpha)))), new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(alpha, alpha), new Entailment(new Entailment(alpha
                , new Entailment(alpha, new Entailment(new Exists(variable,e), alpha)))
                , new Entailment(alpha, new Entailment(new Exists(variable,e), alpha))))))
                , null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(alpha, alpha), new Entailment(new Entailment(alpha
                , new Entailment(alpha, new Entailment(new Exists(variable,e), alpha)))
                , new Entailment(alpha, new Entailment(new Exists(variable,e), alpha)))))
                , null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(alpha, alpha))
                , new Entailment(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(alpha, alpha), new Entailment(new Entailment(alpha
                , new Entailment(alpha, new Entailment(new Exists(variable,e), alpha)))
                , new Entailment(alpha, new Entailment(new Exists(variable,e), alpha)))))
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(alpha, new Entailment(alpha
                , new Entailment(new Exists(variable,e), alpha))), new Entailment(alpha
                , new Entailment(new Exists(variable,e), alpha)))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(alpha
                , alpha), new Entailment(new Entailment(alpha, new Entailment(alpha
                , new Entailment(new Exists(variable,e), alpha))), new Entailment(alpha
                , new Entailment(new Exists(variable,e), alpha))))), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(alpha
                , new Entailment(alpha, new Entailment(new Exists(variable,e), alpha)))
                , new Entailment(alpha, new Entailment(new Exists(variable,e), alpha)))))
                , null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(alpha, new Entailment(alpha
                , new Entailment(new Exists(variable,e), alpha))), new Entailment(alpha
                , new Entailment(new Exists(variable,e), alpha)))), null);
        proof.addExpression(new Entailment(alpha, new Entailment(new Exists(variable,e)
                , alpha)), null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(new Exists(variable,e)
                , alpha)), new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , alpha)))), null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , alpha))), null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Exists(variable,e))
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1))), new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1))))
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(new Exists(variable,e), new Exists(variable,e))
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1))), new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)))))), null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(new Exists(variable,e), new Exists(variable,e))
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1))), new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1))))
                , new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1))))))
                , null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1))))
                , new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1))))))
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1))))
                , new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1))))))))
                , null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1))))
                , new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))))))
                , null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))))
                , new Entailment(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1))))
                , new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))))))
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1))))))))
                , null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1))))
                , new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))))))
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))))))
                , null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1))))))
                , null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Exists(variable,e))), new Entailment(new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))))
                , new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1))))))
                , null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Exists(variable,e))), new Entailment(new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))))
                , new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1))))))
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Exists(variable,e))), new Entailment(new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))))
                , new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1))))))))
                , null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Exists(variable,e))), new Entailment(new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))))
                , new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))))))
                , null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Exists(variable,e)))), new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(alpha
                , new Entailment(new Exists(variable,e), new Exists(variable,e)))
                , new Entailment(new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))))
                , new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))))))
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))))
                , new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1))))))))
                , null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(alpha
                , new Entailment(new Exists(variable,e), new Exists(variable,e)))
                , new Entailment(new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))))
                , new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))))))
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))))
                , new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))))))
                , null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))))
                , new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1))))))
                , null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1))))))
                , new Entailment(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Exists(variable,e)), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))))
                , new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1))))))
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))))))
                , null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(new Exists(variable,e), new Exists(variable,e))
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1))), new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1))))), new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1))))))
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1))))))
                , null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))))
                , null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)))), null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1))), new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)))), new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1))), new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)))), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1))), new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)))), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)))), null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1))), null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)))), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)))))), null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1))), new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1))))), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1))))), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1))))), null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1))), new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1))))), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1))))), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1))))), null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)))), null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), alpha)
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Exists(variable,e), e1)))
                , null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , alpha), new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Exists(variable,e), e1)))
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(new Exists(variable,e), alpha)
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Exists(variable,e), e1)))))
                , null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(new Exists(variable,e), alpha)
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Exists(variable,e), e1))))
                , null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , alpha), new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Exists(variable,e), e1)))
                , new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , alpha), new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Exists(variable,e), e1)))))
                , null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , alpha), new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Exists(variable,e), e1)))
                , new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , alpha), new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Exists(variable,e), e1)))))
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , alpha), new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Exists(variable,e), e1)))
                , new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , alpha), new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Exists(variable,e), e1)))))))
                , null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , alpha), new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Exists(variable,e), e1)))
                , new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , alpha), new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Exists(variable,e), e1))))))
                , null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(new Exists(variable,e)
                , alpha), new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Exists(variable,e), e1))))
                , new Entailment(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , alpha), new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Exists(variable,e), e1)))
                , new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , alpha), new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Exists(variable,e), e1))))))
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , alpha), new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Exists(variable,e), e1)))))))
                , null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , alpha), new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Exists(variable,e), e1)))
                , new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , alpha), new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Exists(variable,e), e1))))))
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , alpha), new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Exists(variable,e), e1))))))
                , null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , alpha), new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Exists(variable,e), e1)))))
                , null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(new Exists(variable,e)
                , alpha)), new Entailment(new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , alpha), new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Exists(variable,e), e1))))
                , new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , e1))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(new Exists(variable,e)
                , alpha)), new Entailment(new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , alpha), new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Exists(variable,e), e1))))
                , new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , e1))))), new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(alpha, new Entailment(new Exists(variable,e)
                , alpha)), new Entailment(new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , alpha), new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Exists(variable,e), e1))))
                , new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , e1))))))), null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(alpha, new Entailment(new Exists(variable,e)
                , alpha)), new Entailment(new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , alpha), new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Exists(variable,e), e1))))
                , new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , e1)))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , alpha))), new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(alpha
                , new Entailment(new Exists(variable,e), alpha)), new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(new Exists(variable,e), alpha), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , e1)))), new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , e1)))))), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(new Exists(variable,e), alpha), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , e1)))), new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , e1))))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(alpha
                , new Entailment(new Exists(variable,e), alpha)), new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(new Exists(variable,e), alpha), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , e1)))), new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , e1)))))), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(new Exists(variable,e), alpha), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , e1)))), new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , e1)))))), null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , alpha), new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Exists(variable,e), e1))))
                , new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , e1))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , alpha))), new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(alpha
                , new Entailment(new Exists(variable,e), alpha)), new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(new Exists(variable,e), alpha), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , e1)))), new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , e1)))))), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(new Exists(variable,e), alpha), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , e1)))), new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , e1))))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(alpha
                , new Entailment(new Exists(variable,e), alpha)), new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(new Exists(variable,e), alpha), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , e1)))), new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , e1)))))), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(new Exists(variable,e), alpha), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , e1)))), new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , e1)))))), null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , alpha), new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Exists(variable,e), e1))))
                , new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , e1))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , alpha), new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Exists(variable,e), e1)))))
                , new Entailment(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , alpha), new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Exists(variable,e), e1))))
                , new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , e1))))), new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , e1)))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(new Exists(variable,e), alpha), new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , e1)))), new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , e1))))), new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , e1))))), null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , e1)))), null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1))), new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Exists(variable,e), e1)))
                , new Entailment(alpha, new Entailment(new Exists(variable,e), e1))))
                , null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1))), new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Exists(variable,e), e1)))
                , new Entailment(alpha, new Entailment(new Exists(variable,e), e1))))
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1))), new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Exists(variable,e), e1)))
                , new Entailment(alpha, new Entailment(new Exists(variable,e), e1))))))
                , null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1))), new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Exists(variable,e), e1)))
                , new Entailment(alpha, new Entailment(new Exists(variable,e), e1)))))
                , null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)))), new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(alpha
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))
                , new Entailment(new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , e1))), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , e1))))), new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , e1))), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , e1)))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(alpha
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))
                , new Entailment(new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , e1))), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , e1))))), new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , e1))), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , e1))))), null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , e1))), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , e1)))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)))), new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(alpha
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))
                , new Entailment(new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , e1))), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , e1))))), new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , e1))), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , e1)))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(alpha
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))
                , new Entailment(new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , e1))), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , e1))))), new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , e1))), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , e1))))), null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , e1))), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , e1)))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , e1)))), new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Exists(variable,e), e1)))
                , new Entailment(alpha, new Entailment(new Exists(variable,e), e1))))
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , e1))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Exists(variable,e), e1)))
                , new Entailment(alpha, new Entailment(new Exists(variable,e), e1))))
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , e1)))), null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , e1))), null);
        proof.addExpression(new Entailment(new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1))), new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Exists(variable,e), e1)))
                , new Entailment(alpha, new Entailment(new Exists(variable,e), e1))))
                , null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1))), new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Exists(variable,e), e1)))
                , new Entailment(alpha, new Entailment(new Exists(variable,e), e1))))
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1))), new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Exists(variable,e), e1)))
                , new Entailment(alpha, new Entailment(new Exists(variable,e), e1))))))
                , null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1))), new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Exists(variable,e), e1)))
                , new Entailment(alpha, new Entailment(new Exists(variable,e), e1)))))
                , null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)))), new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(alpha
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))
                , new Entailment(new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , e1))), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , e1))))), new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , e1))), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , e1)))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(alpha
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))
                , new Entailment(new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , e1))), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , e1))))), new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , e1))), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , e1))))), null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , e1))), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , e1)))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)))), new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(alpha
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))
                , new Entailment(new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , e1))), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , e1))))), new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , e1))), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , e1)))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(alpha
                , new Entailment(new Exists(variable,e), new Entailment(alpha, e1)))
                , new Entailment(new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , e1))), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , e1))))), new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , e1))), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , e1))))), null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , e1))), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , e1)))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(alpha, new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Exists(variable,e)
                , e1)))), new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Exists(variable,e), e1)))
                , new Entailment(alpha, new Entailment(new Exists(variable,e), e1))))
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , e1))))), null);
        proof.addExpression(new Entailment(new Entailment(new Entailment(new Exists(variable,e)
                , new Entailment(alpha, e1)), new Entailment(new Entailment(alpha
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(new Exists(variable,e), e1)))
                , new Entailment(alpha, new Entailment(new Exists(variable,e), e1))))
                , new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , e1)))), null);
        proof.addExpression(new Entailment(new Entailment(new Exists(variable,e), new Entailment(alpha
                , e1)), new Entailment(alpha, new Entailment(new Exists(variable,e)
                , e1))), null);
        proof.addExpression(new Entailment(alpha, new Entailment(new Exists(variable,e)
                , e1)), null);
    }
}
