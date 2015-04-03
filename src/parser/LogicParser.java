package parser;

import structure.LogicExpression;
import structure.purelogic.*;

/**
 * Implementation of {@link Parser}, that
 * //TODO: javadoc it
 */
public final class LogicParser implements Parser<LogicExpression> {
    private static LogicParser ourInstance = new LogicParser();
    private String s;
    private int next;

    //No instances for you
    private LogicParser() {
    }

    public static LogicParser getInstance() {
        return ourInstance;
    }

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

    private NVariable getVariable(char c) {
        StringBuilder sb = new StringBuilder();
        do {
            sb.append(c);
            c = getChar();
        } while (Character.isDigit(c));
        returnChar();
        return new NVariable(sb.toString());
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

    private LogicExpression parseFactor() throws ParseException {
        skipWhitespaces();
        char c = getChar();

        if (Character.isDigit(c)) {
            return getGap(c);
        }

        if (Character.isUpperCase(c)) {
            return getVariable(c);
        }

        LogicExpression result;
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

    private LogicExpression parseAnd(LogicExpression left) throws ParseException {
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

    private LogicExpression parseOr(LogicExpression left) throws ParseException {
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



    private LogicExpression parseEntailment(LogicExpression left) throws ParseException {
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

    private LogicExpression parseFormula() throws ParseException {
        return parseEntailment(parseOr(parseAnd(parseFactor())));
    }

    @Override
    public LogicExpression parse(String str) throws ParseException {
        s = str;
        next = 0;
        LogicExpression expression = parseFormula();
        if (next < s.length()) {
            throw new ParseException("Unexpected symbol on " + next);
        }
        return expression;
    }
}