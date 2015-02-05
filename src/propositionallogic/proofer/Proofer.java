package propositionallogic.proofer;

import parser.ParseException;
import proof.Proof;

public interface Proofer {
    Proof proof(String statement) throws ParseException;
}
