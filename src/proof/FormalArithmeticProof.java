package proof;

import structure.FormalArithmeticExpression;

import java.util.List;

/**
 * @author Daniyar Itegulov
 */
public class FormalArithmeticProof implements Proof<FormalArithmeticExpression> {
    @Override
    public void addExpression(final FormalArithmeticExpression expression, final StatementType type) {

    }

    @Override
    public void addStatement(final Statement<FormalArithmeticExpression> st) {

    }

    @Override
    public void addProof(final Proof<FormalArithmeticExpression> proof) {

    }

    @Override
    public List<Statement<FormalArithmeticExpression>> getStatements() {
        return null;
    }

    @Override
    public boolean check(final Statement<FormalArithmeticExpression>[] assumptions) {
        return false;
    }

    @Override
    public StatementType findBasis(final Statement<FormalArithmeticExpression> statement) {
        return null;
    }
}
