package ru.ifmo.ctddev.itegulov.mathlogic;

import ru.ifmo.ctddev.itegulov.mathlogic.exceptions.InvalidProofException;
import ru.ifmo.ctddev.itegulov.mathlogic.exceptions.ParseException;
import ru.ifmo.ctddev.itegulov.mathlogic.formalarithmetic.deductor.FormalArithmeticDeductor;
import ru.ifmo.ctddev.itegulov.mathlogic.kripke.ExpressionIsTrueException;
import ru.ifmo.ctddev.itegulov.mathlogic.kripke.innovative.InnovativeKripkeBuilder;
import ru.ifmo.ctddev.itegulov.mathlogic.kripke.innovative.KripkeBuilder;
import ru.ifmo.ctddev.itegulov.mathlogic.kripke.innovative.Model;
import ru.ifmo.ctddev.itegulov.mathlogic.proof.Proof;
import ru.ifmo.ctddev.itegulov.mathlogic.propositionallogic.parser.LogicParser;
import ru.ifmo.ctddev.itegulov.mathlogic.scanner.FastLineScanner;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.LogicExpression;
import sun.rmi.runtime.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Collections;

/**
 * @author Daniyar Itegulov
 */
public class HW5 {

    public static void main(String[] args) throws FileNotFoundException, InvalidProofException, ParseException {
        LogicParser parser = LogicParser.getInstance();
        FastLineScanner fastLineScanner = new FastLineScanner(new File("task5.in"));
        PrintWriter pw = new PrintWriter("task5.out");
        LogicExpression expression = parser.parse(fastLineScanner.next());
        Model model = new InnovativeKripkeBuilder().build(expression, Collections.emptyList());
        if (model == null) {
            pw.println("Формула общезначима");
            pw.close();
        } else {
            pw.println(model);
            pw.close();
            if (model.check(expression)) {
                throw new IllegalStateException("Looks like I can't solve this task :(");
            }
        }
    }
}
