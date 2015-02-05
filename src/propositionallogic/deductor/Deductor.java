package propositionallogic.deductor;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import parser.ParseException;
import proof.Proof;
import proof.Statement;

import java.io.File;
import java.io.FileNotFoundException;

public interface Deductor {
    //TODO: javadoc
    Proof deduct(@NotNull final File f, @Nullable final Statement[] proofed) throws FileNotFoundException, ParseException;
    Proof deduct(@NotNull Proof proof, @NotNull final Statement[] assumptions, @Nullable final Statement[] proofed) throws ParseException;
}
