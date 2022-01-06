package Exceptions;

/**
 *
 * @author dmanu
 */
public class EmptyCollectionException extends Exception{
    
    public final static String EMPTYCOLLECTION = "Árvore vazia";

    public EmptyCollectionException() {
    }

    public EmptyCollectionException(String message) {
        super(message);
    }
}
