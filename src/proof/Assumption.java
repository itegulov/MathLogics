package proof;

public final class Assumption implements StatementType {
    //TODO: javadoc
    //TODO: realize assumption

    @Override
    public boolean equals(Object o) {
        return this == o || !(o == null || getClass() != o.getClass());
    }

    @Override
    public String toString() {
        return "Допущение";
    }
}
