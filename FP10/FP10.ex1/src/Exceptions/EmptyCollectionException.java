package Exceptions;

/**
 *
 * @author dmanu
 */
public class EmptyCollectionException extends Exception{
    
    public final static String EMPTYCOLLECTION = "Árvore Vazia";

    public EmptyCollectionException() {
    }

    public EmptyCollectionException(String message) {
        super(message);
    }
}
