package parser;

import structure.FormalArithmeticExpression;
import structure.arithmetics.*;
import structure.predicate.Exists;
import structure.predicate.ForAll;
import structure.predicate.Predicate;
import structure.predicate.Term;
import structure.predicatelogic.*;

import java.util.ArrayList;

public final class ArithmeticParser implements Parser<FormalArithmeticExpression> {
    private static String expression;
    private static int index;

    private static char getChar() {
        return expression.charAt(index++);
    }

    private static void returnChar() {
        index--;
    }

    private static Term variablePOrNull() throws ParseException {
        if (getChar() == '0') {
            return new Zero();
        } else {
            returnChar();
            return variable();
        }
    }

    private static Term variable() throws ParseException {
        int start = index, end = index + 1;
        char nextChar = getChar();
        if (!Character.isLetter(nextChar) || !Character.isLowerCase(nextChar))
            throw new ParseException("canPNot parse: " + expression);
        while (Character.isDigit(getChar()))
            end++;
        returnChar();
        String value = expression.substring(start, end);
        return new Term(value);
    }

    @Override
    public FormalArithmeticExpression parse(String expression) throws ParseException {
        ArithmeticParser.expression = expression.replaceAll("\\s+", "") + ";";
        index = 0;
        FormalArithmeticExpression e = implication();
        if (index != expression.length()) {
            throw new ParseException("Illegal character: " + expression.charAt(index));
        }
        return e;
    }

    protected FormalArithmeticExpression implication() throws ParseException {
        FormalArithmeticExpression s = POr();
        char nextChar = getChar();
        if (nextChar == '-') {
            if (getChar() != '>')
                throw new ParseException("canPNot parse: " + expression);
            s = new PEntailment(s, implication());
        } else {
            returnChar();
        }
        return s;
    }

    protected FormalArithmeticExpression POr() throws ParseException {
        FormalArithmeticExpression l = PAnd();
        char nextChar = getChar();
        while (nextChar == '|') {
            l = new POr(l, PAnd());
            nextChar = getChar();
        }
        returnChar();
        return l;
    }

    protected FormalArithmeticExpression PAnd() throws ParseException {
        FormalArithmeticExpression l = unary();
        char nextChar = getChar();
        while (nextChar == '&') {
            l = new PAnd(l, unary());
            nextChar = getChar();
        }
        returnChar();
        return l;
    }

    protected FormalArithmeticExpression unary() throws ParseException {
        char nextChar = getChar();
        if (Character.isLetter(nextChar) || Character.isDigit(nextChar)) {
            return predicate(Character.isUpperCase(nextChar));
        } else if (nextChar == '!') {
            return new PNot(unary());
        } else if (nextChar == '(') {
            int saveIndex = index;
            FormalArithmeticExpression result;
            try {
                result = implication();
                if (getChar() != ')') {
                    throw new ParseException("canPNot parse: " + expression);
                }
            } catch (ParseException pe) {
                index = saveIndex;
                result = predicate(false);
            }
            return result;
        } else if (nextChar == '@') {
            {

                return new ForAll(variable(), unary());
            }
        } else if (nextChar == '?') {
            return new Exists(variable(), unary());
        } else {
            throw new ParseException("canPNot parse: " + expression);
        }
    }

    protected FormalArithmeticExpression predicate(boolean firstCharIsUpperCase) throws ParseException {
        if (firstCharIsUpperCase) {
            int start = index - 1, end = index;
            char nextChar;
            while (Character.isDigit(nextChar = getChar()))
                end++;
            String name = expression.substring(start, end);
            ArrayList<Term> list = new ArrayList<>();
            if (nextChar == '(') {
                list = terms();
                if (getChar() != ')')
                    throw new ParseException("canPNot parse: " + expression);
            } else
                returnChar();
            if (list.size() == 0) {
                return new PVariable(name);
            }
            return new Predicate(name, list);
        } else {
            returnChar();
            ArrayList<Term> list = new ArrayList<>();
            list.add(term());
            if (getChar() != '=')
                throw new ParseException("canPNot parse: " + expression);
            list.add(term());
            return new Equals(list);
        }
    }

    protected Term term() throws ParseException {
        Term t = summPAnd();
        char nextChar = getChar();
        while (nextChar == '+') {
            ArrayList<Term> list = new ArrayList<>();
            list.add(t);
            list.add(summPAnd());
            t = new Plus(list);
            nextChar = getChar();
        }
        returnChar();
        return t;
    }

    protected Term summPAnd() throws ParseException {
        Term t = multiplied();
        char nextChar = getChar();
        while (nextChar == '*') {
            ArrayList<Term> list = new ArrayList<>();
            list.add(t);
            list.add(multiplied());
            t = new Multiply(list);
            nextChar = getChar();
        }
        returnChar();
        return t;
    }

    protected Term multiplied() throws ParseException {
        char nextChar = getChar();
        Term t;
        if (nextChar == '(') {
            t = term();
            if (getChar() != ')')
                throw new ParseException("canPNot parse: " + expression);
        } else {
            returnChar();
            t = variablePOrNull();
            if (!"0".equals(t.getName())) {
                nextChar = getChar();
                if (nextChar == '(') {
                    ArrayList<Term> list = terms();
                    if (getChar() != ')')
                        throw new ParseException("canPNot parse: " + expression);

                    switch (t.getName()) {
                        case "+": {
                            t = new Plus(list);
                            break;
                        }
                        case "*": {
                            t = new Multiply(list);
                            break;
                        }
                        case "'": {
                            t = new Successor(list);
                            break;
                        }
                        case "0": {
                            t = new Zero();
                            break;
                        }
                        default: {
                            t = new Term(t.getName(), list);
                        }
                    }
                } else {
                    returnChar();
                }
            }
        }
        if (getChar() == '\'') {
            do {
                ArrayList<Term> list = new ArrayList<>();
                list.add(t);
                t = new Successor(list);
            }
            while (getChar() == '\'');
            returnChar();
        } else
            returnChar();
        return t;
    }

    protected ArrayList<Term> terms() throws ParseException {
        ArrayList<Term> list = new ArrayList<>();
        list.add(term());
        while (getChar() == ',')
            list.add(term());
        returnChar();
        return list;
    }
}
