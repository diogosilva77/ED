package Exceptions;

/**
 *
 * @author dmanu
 */
public class EmptyCollectionException extends Exception{
    
    public final static String EMPTYCOLLECTION = "Coleção Vazia";

    public EmptyCollectionException() {
    }

    public EmptyCollectionException(String message) {
        super(message);
    }
}
