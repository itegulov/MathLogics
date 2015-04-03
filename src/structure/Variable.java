package structure;

/**
 * @author Daniyar Itegulov
 */
public interface Variable<E extends Expression> extends Expression<E> {
    String getName();
}
