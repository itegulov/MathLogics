package formalarithmetic.deductor;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import exceptions.InvalidProofException;
import parser.ParseException;
import proof.Proof;
import proof.Statement;

import java.io.File;
import java.io.FileNotFoundException;

public interface Deductor {
    Proof deduct(@NotNull final File f, @Nullable final Statement[] proofed) throws FileNotFoundException, ParseException, InvalidProofException;
    Proof deduct(@NotNull Proof proof, @NotNull final Statement[] assumptions, @Nullable final Statement[] proofed) throws ParseException, InvalidProofException;
}
