package ru.ifmo.ctddev.itegulov.mathlogic.formalarithmetic.parser;

import ru.ifmo.ctddev.itegulov.mathlogic.interfaces.Parser;
import ru.ifmo.ctddev.itegulov.mathlogic.exceptions.ParseException;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.FormalArithmeticExpression;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.arithmetics.*;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.predicate.Exists;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.predicate.ForAll;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.predicate.Predicate;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.predicate.Term;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.predicatelogic.*;

import java.util.ArrayList;

public final class FormalArithmeticParser implements Parser<FormalArithmeticExpression> {
    private static FormalArithmeticParser ourInstance = new FormalArithmeticParser();
    private String expression;
    private int index;

    //No instances for you
    private FormalArithmeticParser() {
    }

    public static FormalArithmeticParser getInstance() {
        return ourInstance;
    }

    private char getChar() {
        return expression.charAt(index++);
    }

    private void returnChar() {
        index--;
    }

    private Term variablePOrNull() throws ParseException {
        if (getChar() == '0') {
            return new Zero();
        } else {
            returnChar();
            return variable();
        }
    }

    private PGap gap() throws ParseException {
        int start = index, end = index + 1;
        char nextChar = getChar();
        if (Character.isDigit(nextChar)) {
            while (Character.isDigit(getChar())) {
                end++;
            }
            returnChar();
            return new PGap(Integer.parseInt(expression.substring(start, end)));
        }
        returnChar();
        throw new ParseException("cannot parse: " + expression);
    }

    private Term variable() throws ParseException {
        int start = index, end = index + 1;
        char nextChar = getChar();
        if (!Character.isLetter(nextChar) || !Character.isLowerCase(nextChar)) {
            if (Character.isDigit(nextChar)) {
                while (Character.isDigit(getChar())) {
                    end++;
                }
                returnChar();
                return new PGap(Integer.parseInt(expression.substring(start, end)));
            }
            returnChar();
            throw new ParseException("cannot parse: " + expression);
        }
        while (Character.isDigit(getChar())) {
            end++;
        }
        returnChar();
        String value = expression.substring(start, end);
        return new Term(value);
    }

    @Override
    public FormalArithmeticExpression parse(String expression) throws ParseException {
        this.expression = expression.replaceAll("\\s+", "") + ";";
        index = 0;
        FormalArithmeticExpression e = implication();
        if (index != this.expression.length() - 1) {
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
            try {
                return predicate(Character.isUpperCase(nextChar));
            } catch (ParseException e) {
                return gap();
            }
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
            int prev = index;
            list.add(term());
            if (getChar() != '=') {
                index = prev;
                throw new ParseException("canPNot parse: " + expression);
            }
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
            if (!t.getName().equals("0")) {
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
