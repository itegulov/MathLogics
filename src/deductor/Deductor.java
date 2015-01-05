package deductor;

import parser.ParseException;
import proof.Proof;
import proof.Statement;

import java.io.File;
import java.io.FileNotFoundException;

public interface Deductor {
    //TODO: javadoc
    Proof deduct(final File f) throws FileNotFoundException, ParseException;
    Proof deduct(final String s) throws FileNotFoundException, ParseException;
    Proof deduct(final Proof proof, final Statement[] assumptions) throws FileNotFoundException, ParseException;
}
