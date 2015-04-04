package ru.ifmo.ctddev.itegulov.exceptions;

import ru.ifmo.ctddev.itegulov.structure.Expression;

public class TreeMismatchException extends Exception {
    public TreeMismatchException(Expression original, Expression other) {
        super("expected " + original + ", founded " + other);
    }
}
