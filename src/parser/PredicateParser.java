package parser;

import structure.Expression;
import structure.logic.Not;
import structure.logic.Variable;
import structure.predicate.Exists;
import structure.predicate.ForAll;
import structure.predicate.Predicate;
import structure.predicate.Term;

import java.util.ArrayList;
import java.util.List;

public class PredicateParser extends LogicParser {
    @Override
    protected Expression parseFactor() throws ParseException {
        skipWhitespaces();
        char c = getChar();

        if (Character.isDigit(c)) {
            return getGap(c);
        }

        Expression result;
        switch (c) {
            case '!':
                return new Not(parseFactor());
            case '(':
                int prevNext = next;
                result = parseFormula();
                skipWhitespaces();
                if (getChar() == ')') {
                    return result;
                } else {
                    next = prevNext;
                    return parsePredicate();
                }
            case '@':
                skipWhitespaces();
                c = getChar();
                if (isChar(c)) {
                    Variable variable = getVariable(c);
                    return new ForAll(variable, parseFactor());
                } else {
                    throw new ParseException("Expected variable, but got " + c + " on " + (next - 1));
                }
            case '?':
                skipWhitespaces();
                c = getChar();
                if (isChar(c)) {
                    Variable variable = getVariable(c);
                    return new Exists(variable, parseFactor());
                } else {
                    throw new ParseException("Expected variable, but got " + c + " on " + (next - 1));
                }
            default:
                returnChar();
                return parsePredicate();
                //throw new ParseException("Unexpected symbol on " + (next - 1));
        }

    }

    protected Predicate parsePredicate() throws ParseException {
        char c = getChar();
        if (Character.isUpperCase(c)) {
            Variable variable = getVariable(c);
            if (getChar() == '(') {
                List<Term> arguments = new ArrayList<>();
                arguments.add(parseTerm());
                while (getChar() == ',') {
                    arguments.add(parseTerm());
                }
                returnChar();
                if (getChar() != ')') {
                    throw new ParseException("Expected closing bracket on " + (next - 1));
                }
                return new Predicate(variable.getName(), arguments.toArray(new Term[arguments.size()]));
            } else {
                returnChar();
                return new Predicate(variable.getName());
            }
        } else {
            throw new ParseException("Expected uppercase latin letter, but got " + c + " on " + (next - 1));
        }
    }

    protected Term parseTerm() throws ParseException {
        char c = getChar();
        if (Character.isLowerCase(c)) {
            Variable variable = getVariable(c);
            if (getChar() == '(') {
                List<Term> arguments = new ArrayList<>();
                arguments.add(parseTerm());
                while (getChar() == ',') {
                    arguments.add(parseTerm());
                }
                returnChar();
                if (getChar() != ')') {
                    throw new ParseException("Expected closing bracket on " + (next - 1));
                }
                return new Term(variable.getName(), arguments.toArray(new Term[arguments.size()]));
            } else {
                returnChar();
            }
            return new Term(variable.getName());
        } else {
            throw new ParseException("Expected term name (lower case letter) on " + (next - 1));
        }
    }
}
