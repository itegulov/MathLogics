package parser;

import com.sun.istack.internal.NotNull;
import structure.Expression;
import structure.logic.*;

/**
 * Implementation of {@link Parser}, that
 * //TODO: javadoc it
 */
public final class LogicParser implements Parser<Expression> {
    private String s;
    private int next;

    private char getChar() {
        if (next < 0 || next >= s.length()) {
            next++;
            return '>';
        }
        return s.charAt(next++);
    }

    private void returnChar() {
        next--;
    }

    private boolean isChar(char c) {
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    private Variable getVariable(char c) {
        StringBuilder sb = new StringBuilder();
        do {
            sb.append(c);
            c = getChar();
        } while (Character.isDigit(c));
        returnChar();
        return new Variable(sb.toString());
    }

    private Gap getGap(char c) {
        StringBuilder sb = new StringBuilder();
        do {
            sb.append(c);
            c = getChar();
        } while (Character.isDigit(c));
        returnChar();
        return new Gap(Integer.parseInt(sb.toString()));
    }

    private void skipWhitespaces() throws ParseException {
        char c = getChar();
        while (Character.isWhitespace(c)) {
            c = getChar();
        }
        returnChar();
    }

    private Expression parseFactor() throws ParseException {
        skipWhitespaces();
        char c = getChar();

        if (Character.isDigit(c)) {
            return getGap(c);
        }

        if (Character.isUpperCase(c)) {
            return getVariable(c);
        }

        Expression result;
        switch (c) {
            case '!':
                return new Not(parseFactor());
            case '(':
                result = parseFormula();
                skipWhitespaces();
                if (getChar() == ')') {
                    return result;
                }
                throw new ParseException("Unexpected symbol on " + (next - 1));
            default:
                throw new ParseException("Unexpected symbol on " + (next - 1));
        }
    }

    private Expression parseAnd(@NotNull Expression left) throws ParseException {
        skipWhitespaces();
        char c = getChar();

        switch (c) {
            case '&':
                return parseAnd(new And(left, parseFactor()));
            default:
                returnChar();
                return left;
        }
    }

    private Expression parseOr(@NotNull Expression left) throws ParseException {
        skipWhitespaces();
        char c = getChar();

        switch (c) {
            case '|':
                return parseOr(new Or(left, parseAnd(parseFactor())));
            default:
                returnChar();
                return left;
        }
    }



    private Expression parseEntailment(@NotNull Expression left) throws ParseException {
        skipWhitespaces();
        char c = getChar();

        switch (c) {
            case '-':
                //TODO: check (warning)
                if (getChar() == '>') {
                    return new Entailment(left, parseEntailment(parseOr(parseAnd(parseFactor()))));
                } else {
                    throw new ParseException("Unexpected symbol on " + (next - 1));
                }
            default:
                returnChar();
                return left;
        }
    }

    private Expression parseFormula() throws ParseException {
        return parseEntailment(parseOr(parseAnd(parseFactor())));
    }

    @Override
    public Expression parse(@NotNull String str) throws ParseException {
        s = str;
        next = 0;
        Expression expression = parseFormula();
        if (next < s.length()) {
            throw new ParseException("Unexpected symbol on " + next);
        }
        return expression;
    }
}