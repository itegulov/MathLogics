package deductor;

import parser.ParseException;
import proof.Proof;

import java.io.File;
import java.io.FileNotFoundException;

public interface Deductor {
    //TODO: javadoc
    Proof deduct(final File f) throws FileNotFoundException, ParseException;
}
