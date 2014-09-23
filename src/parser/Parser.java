package parser;

public interface Parser<E> {
    E parse(String s) throws ParseException;
}
