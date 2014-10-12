package validator;

import proof.Proof;
import proof.Statement;
import scanner.FastLineScanner;

import java.io.File;
import java.io.FileNotFoundException;

public interface Validator {
    //TODO: javadoc
    Proof validate(final File f) throws FileNotFoundException;
    Proof validate(final File f, final Statement[] assumptions) throws FileNotFoundException;
    Proof validate(final FastLineScanner in, final Statement[] assumptions);
    Proof validate(final Proof proof, final Statement[] assumptions);
}
