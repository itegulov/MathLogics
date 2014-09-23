package proof;

import expression.Expression;

public final class Assumption implements StatementType {
    //TODO: javadoc
    //TODO: realize assumption

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        return true;
    }

    @Override
    public String toString() {
        return "Допущение";
    }
}
