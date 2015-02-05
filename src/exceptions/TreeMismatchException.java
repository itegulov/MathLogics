package exceptions;

import structure.Expression;

public class TreeMismatchException extends Exception {
    public TreeMismatchException(Expression original, Expression other) {
        super("expected " + original + ", founded " + other);
    }
}
