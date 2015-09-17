package ru.ifmo.ctddev.itegulov.mathlogic;

import ru.ifmo.ctddev.itegulov.mathlogic.exceptions.FalseExpressionException;
import ru.ifmo.ctddev.itegulov.mathlogic.exceptions.InvalidProofException;
import ru.ifmo.ctddev.itegulov.mathlogic.exceptions.ParseException;
import ru.ifmo.ctddev.itegulov.mathlogic.proof.Proof;
import ru.ifmo.ctddev.itegulov.mathlogic.propositionallogic.proofer.TertiumNonDaturProofer;
import ru.ifmo.ctddev.itegulov.mathlogic.propositionallogic.validator.LogicValidator;
import ru.ifmo.ctddev.itegulov.mathlogic.structure.LogicExpression;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author Daniyar Itegulov
 */
public class HW3 {

    public static void main(String[] args) throws FileNotFoundException, InvalidProofException,
            ParseException, FalseExpressionException {
        TertiumNonDaturProofer proofer = TertiumNonDaturProofer.getInstance();
        LogicValidator logicValidator = LogicValidator.getInstance();
        Proof<LogicExpression> p = proofer.proof(new Scanner(new File("task3.in")).nextLine());
        Proof proof = logicValidator.validate(p, null);
        PrintWriter pw = new PrintWriter("task3.out");
        pw.println(proof);
        pw.close();
    }
}
