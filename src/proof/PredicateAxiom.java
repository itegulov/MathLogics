package proof;

public enum PredicateAxiom implements StatementType {
    AXIOM_FOR_ALL("Сх. акс. всеобщности"), AXIOM_EXISTS("Сх. акс. существования");

    private String text;

    PredicateAxiom(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
