package ru.ifmo.ctddev.itegulov.mathlogic;

import ru.ifmo.ctddev.itegulov.mathlogic.exceptions.InvalidProofException;
import ru.ifmo.ctddev.itegulov.mathlogic.exceptions.ParseException;
import ru.ifmo.ctddev.itegulov.mathlogic.formalarithmetic.deductor.FormalArithmeticDeductor;
import ru.ifmo.ctddev.itegulov.mathlogic.kripke.ExpressionIsTrueException;
import ru.ifmo.ctddev.itegulov.mathlogic.kripke.innovative.KripkeBuilder;
import ru.ifmo.ctddev.itegulov.mathlogic.kripke.innovative.Model;
import ru.ifmo.ctddev.itegulov.mathlogic.proof.Proof;
import ru.ifmo.ctddev.itegulov.mathlogic.propositionallogic.parser.LogicParser;
import ru.ifmo.ctddev.itegulov.mathlogic.scanner.FastLineScanner;
import sun.rmi.runtime.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * @author Daniyar Itegulov
 */
public class HW5 {

    public static void main(String[] args) throws FileNotFoundException, InvalidProofException, ParseException {
        LogicParser parser = LogicParser.getInstance();
        FastLineScanner fastLineScanner = new FastLineScanner(new File("task5.in"));
        PrintWriter pw = new PrintWriter("task5.out");
        try {
            KripkeBuilder kripkeBuilder = new KripkeBuilder(parser.parse(fastLineScanner.next()));
            Model model = kripkeBuilder.build();
            pw.println(model);
        } catch (ExpressionIsTrueException e) {
            pw.println("Формула общезначима");
        }
        pw.close();
    }
}
