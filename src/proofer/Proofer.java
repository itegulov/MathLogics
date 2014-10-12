package proofer;

import proof.Proof;

public interface Proofer {
    Proof proof(String statement);
}
