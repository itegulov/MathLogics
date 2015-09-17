package ru.ifmo.ctddev.itegulov.mathlogic;

import ru.ifmo.ctddev.itegulov.mathlogic.exceptions.InvalidProofException;
import ru.ifmo.ctddev.itegulov.mathlogic.proof.Proof;
import ru.ifmo.ctddev.itegulov.mathlogic.propositionallogic.deductor.LogicDeductor;
import ru.ifmo.ctddev.itegulov.mathlogic.propositionallogic.validator.LogicValidator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * @author Daniyar Itegulov
 */
public class HW2 {

    public static void main(String[] args) throws FileNotFoundException, InvalidProofException {
        LogicDeductor logicDeductor = LogicDeductor.getInstance();
        Proof proof = logicDeductor.deductLast(new File("task2.in"), null);
        PrintWriter pw = new PrintWriter("task2.out");
        pw.println(proof);
        pw.close();
    }
}
