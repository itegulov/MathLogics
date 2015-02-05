package formalarithmetic.validator;

import proof.Proof;

public interface Validator {
    /**
     * Validates proof in formal arithmetic. It marks errors, but believes, that they are true
     * @param proofText     string representation of proof
     * @return              validated proof in formal arithmetic
     */
    Proof validate(String proofText);
}
