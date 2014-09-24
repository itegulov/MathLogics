package parser;

import com.sun.istack.internal.NotNull;

public interface Parser<E> {
    E parse(@NotNull String s) throws ParseException;
}
