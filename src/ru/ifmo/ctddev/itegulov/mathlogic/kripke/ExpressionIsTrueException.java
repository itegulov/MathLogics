package ru.ifmo.ctddev.itegulov.mathlogic.kripke;

/**
 * @author Daniyar Itegulov
 */
public class ExpressionIsTrueException extends Exception {

    public ExpressionIsTrueException() {
    }

    public ExpressionIsTrueException(String message) {
        super(message);
    }

    public ExpressionIsTrueException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExpressionIsTrueException(Throwable cause) {
        super(cause);
    }

    public ExpressionIsTrueException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
