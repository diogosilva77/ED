
package Interfaces;

import java.util.Iterator;


/**
 *
 * @author dmanu
 */
public interface ListADT<T> extends Iterable<T> {
    
    /**
     * Remove e retorna o primeiro elemento da lista
     * @return o primeiro elemento da lista
     */
    public T removeFirst() throws EmptyCollectionException;
    
    /**
     * Remove e retorna o último elemento da lista
     * @return o último elemento da lista
     */
    public T removeLast() throws EmptyCollectionException;
    
    /**
     * Remove e retorna um elemento especifico da lista
     * @param element o elemento a ser removido da lista
     * @return 
     */
    public T remove (T element) throws EmptyCollectionException;
    
    /**
     * Retorna a referencia do primeiro elemento da lista
     * @return a referencia do primeiro elemento da lista
     */
    public T first() throws EmptyCollectionException;
    
    /**
     * Retorna a referencia do ultimo elemento da lista
     * @return a referencia do ultimo elemento da lista
     */
    public T last() throws EmptyCollectionException;
    
    /**
     * Retorna true se a lista conter um especifico elemento
     * @param target elemento que está a ser procurado
     * @return true se a lista contiver o elemento
     */
    public boolean contains(T target) throws EmptyCollectionException;
    
    /**
     * Retorna true se a lista não conter elementos
     * @return true se a lista nao conter elementos
     */
    public boolean isEmpty();
    
    /**
     * Retorna o número de elementos da lista
     * @return o número de elementos da lista
     */
    public int size();
    
    /**
     * Retorna um iterador para os elementos da lista
     * @return um iterador sobre os elementos da lista
     */
    public Iterator<T> iterator();
    
    /**
     * Retorna uma string se representação da lista
     * @return a string de representação da lista
     */
    @Override
    public String toString();

}
