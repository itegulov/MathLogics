package ru.ifmo.ctddev.itegulov.mathlogic;

import ru.ifmo.ctddev.itegulov.mathlogic.exceptions.InvalidProofException;
import ru.ifmo.ctddev.itegulov.mathlogic.formalarithmetic.deductor.FormalArithmeticDeductor;
import ru.ifmo.ctddev.itegulov.mathlogic.proof.Proof;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * @author Daniyar Itegulov
 */
public class HW4 {

    public static void main(String[] args) throws FileNotFoundException, InvalidProofException {
        FormalArithmeticDeductor deductor = FormalArithmeticDeductor.getInstance();
        Proof proof = deductor.deductLast(new File("task4.in"), null);
        PrintWriter pw = new PrintWriter("task4.out");
        pw.println(proof);
        pw.close();
    }
}
