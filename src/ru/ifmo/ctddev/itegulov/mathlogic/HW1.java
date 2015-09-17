package ru.ifmo.ctddev.itegulov.mathlogic;

import ru.ifmo.ctddev.itegulov.mathlogic.exceptions.InvalidProofException;
import ru.ifmo.ctddev.itegulov.mathlogic.proof.Proof;
import ru.ifmo.ctddev.itegulov.mathlogic.propositionallogic.validator.LogicValidator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * @author Daniyar Itegulov
 */
public class HW1 {

    public static void main(String[] args) throws FileNotFoundException, InvalidProofException {
        LogicValidator logicValidator = LogicValidator.getInstance();
        Proof proof = logicValidator.validate(new File("task1.in"));
        PrintWriter pw = new PrintWriter("task1.out");
        pw.println(proof);
        pw.close();
    }
}
