package parser;

import expression.*;

public final class ExpressionParser {
    //TODO: javadoc
    private static String s;
    private static int next;

    private static char getChar() {
        if (next < 0 || next >= s.length()) {
            next++;
            return '>';
        }
        return s.charAt(next++);
    }

    private static void returnChar() {
        next--;
    }

    private static boolean isChar(char c) {
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    private static Variable getVariable(char c) {
        StringBuffer sb = new StringBuffer();
        do {
            sb.append(c);
            c = getChar();
        } while (isChar(c));
        returnChar();
        return new Variable(sb.toString());
    }

    private static void skipWhitespaces() throws ParseException {
        char c = getChar();
        while (Character.isWhitespace(c)) {
            c = getChar();
        }
        returnChar();
    }

    private static Expression parseFactor() throws ParseException {
        skipWhitespaces();
        char c = getChar();

        if (isChar(c)) {
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

    private static Expression parseAnd(Expression left) throws ParseException {
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

    private static Expression parseOr(Expression left) throws ParseException {
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



    private static Expression parseEntailment(Expression left) throws ParseException {
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

    private static Expression parseFormula() throws ParseException {
        return parseEntailment(parseOr(parseAnd(parseFactor())));
    }

    public static Expression parse(String str) throws ParseException {
        s = str;
        next = 0;
        Expression expression = parseFormula();
        if (next < s.length()) {
            throw new ParseException("Unexpected symbol on " + next);
        }
        return expression;
    }
}