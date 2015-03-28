package parser;


public interface Parser<E> {
    E parse(final String s) throws ParseException;
}
