package proof;

public final class Error implements StatementType {
    //TODO: javadoc
    private int line;

    public Error(int line) {
        this.line = line;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Error error = (Error) o;

        return line == error.line;

    }

    @Override
    public int hashCode() {
        return line;
    }

    @Override
    public String toString() {
        return "Доказательство неверно начиная со строки №" + line;
    }
}
