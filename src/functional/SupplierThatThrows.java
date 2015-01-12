package functional;

@FunctionalInterface
public interface SupplierThatThrows<T, X extends Exception> {
    T get() throws X;
}
