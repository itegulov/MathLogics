package parser;

import structure.Expression;
import structure.arithmetics.*;
import structure.logic.*;
import structure.predicate.*;

import java.util.ArrayList;

public class ArithmeticParser {
    private static String expression;
    private static int index;

    public Expression parse(String expression) throws ParseException {
        ArithmeticParser.expression = expression.replaceAll("\\s+", "") + ";";
        index = 0;
        return implication();
    }

    private static char getChar() {
        return expression.charAt(index++);
    }

    private static void returnChar() {
        index--;
    }

    protected Expression implication() throws ParseException {
        Expression s = Or();
        char nextChar = getChar();
        if (nextChar == '-') {
            if (getChar() != '>')
                throw new ParseException("cannot parse: " + expression);
            s = new Entailment(s, implication());
        } else
            returnChar();
        return s;
    }

    protected Expression Or() throws ParseException {
        Expression l = And();
        char nextChar = getChar();
        while (nextChar == '|') {
            l = new Or(l, And());
            nextChar = getChar();
        }
        returnChar();
        return l;
    }

    protected Expression And() throws ParseException {
        Expression l = unary();
        char nextChar = getChar();
        while (nextChar == '&') {
            l = new And(l, unary());
            nextChar = getChar();
        }
        returnChar();
        return l;
    }

    protected Expression unary() throws ParseException {
        char nextChar = getChar();
        if (Character.isLetter(nextChar) || Character.isDigit(nextChar)) {
            return predicate(Character.isUpperCase(nextChar));
        } else if (nextChar == '!') {
            return new Not(unary());
        } else if (nextChar == '(') {
            int saveIndex = index;
            Expression result;
            try {
                result = implication();
                if (getChar() != ')')
                    throw new ParseException("cannot parse: " + expression);
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
            throw new ParseException("cannot parse: " + expression);
        }
    }

    protected Expression predicate(boolean firstCharIsUpperCase) throws ParseException {
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
                    throw new ParseException("cannot parse: " + expression);
            } else
                returnChar();
            if (list.size() == 0) {
                return new Variable(name);
            }
            return new Predicate(name, list);
        } else {
            returnChar();
            ArrayList<Term> list = new ArrayList<>();
            list.add(term());
            if (getChar() != '=')
                throw new ParseException("cannot parse: " + expression);
            list.add(term());
            return new Equals(list);
        }
    }

    protected Term term() throws ParseException {
        Term t = summand();
        char nextChar = getChar();
        while (nextChar == '+') {
            ArrayList<Term> list = new ArrayList<Term>();
            list.add(t);
            list.add(summand());
            t = new Plus(list);
            nextChar = getChar();
        }
        returnChar();
        return t;
    }

    protected Term summand() throws ParseException {
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
                throw new ParseException("cannot parse: " + expression);
        } else {
            returnChar();
            t = variableOrNull();
            if (!"0".equals(t.getName())) {
                nextChar = getChar();
                if (nextChar == '(') {
                    ArrayList<Term> list = terms();
                    if (getChar() != ')')
                        throw new ParseException("cannot parse: " + expression);

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
                    // t = new Function(t.name, list);
                } else {
                    returnChar();
                }
            }
        }
        if (getChar() == '\'') {
            do {
                ArrayList<Term> list = new ArrayList<Term>();
                list.add(t);
                t = new Successor(list);
            }
            while (getChar() == '\'');
            returnChar();
        } else
            returnChar();
        return t;
    }

    private static Term variableOrNull() throws ParseException {
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
            throw new ParseException("cannot parse: " + expression);
        while (Character.isDigit(getChar()))
            end++;
        returnChar();
        String value = expression.substring(start, end);
        return new Term(value);
    }

    protected ArrayList<Term> terms() throws ParseException {
        ArrayList<Term> list = new ArrayList<Term>();
        list.add(term());
        while (getChar() == ',')
            list.add(term());
        returnChar();
        return list;
    }
}
