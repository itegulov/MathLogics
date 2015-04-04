package ru.ifmo.ctddev.itegulov.functional;

@FunctionalInterface
public interface SupplierThatThrows<T, X extends Exception> {
    T get() throws X;
}
