package Interfaces;

import Exceptions.EmptyCollectionException;

/**
 *
 * @author dmanu
 */
public interface HeapADT<T> extends BinaryTreeADT<T>{
    
    public void addElement (T obj);
    
    public T removeMin() throws EmptyCollectionException;
    
    public T findMin();
}
