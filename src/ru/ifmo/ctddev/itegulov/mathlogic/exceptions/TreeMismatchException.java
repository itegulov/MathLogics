package ru.ifmo.ctddev.itegulov.mathlogic.exceptions;

import ru.ifmo.ctddev.itegulov.mathlogic.structure.Expression;

public class TreeMismatchException extends Exception {
    public TreeMismatchException(Expression original, Expression other) {
        super("expected " + original + ", founded " + other);
    }
}
