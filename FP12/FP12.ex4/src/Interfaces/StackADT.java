
package Interfaces;

import Exceptions.EmptyCollectionException;

/**
 *
 * @author dmanu
 */
public interface StackADT<T>{ 
    
    /**
     * Adiciona o elemento ao topo da stack
     * @param element 
     */
    public void push(T element);
    
    /**
     * Remove e retorna o elemento que esta no topo da stack
     * @return o elemento removido do topo da stack
     * @throws EmptyCollectionException 
     */
    public T pop() throws EmptyCollectionException;
    
    /**
     * Retorna o elemento que esta no topo da stack
     * @return o elemento do topo da stack
     * @throws EmptyCollectionException 
     */
    public T peek() throws EmptyCollectionException;
    
    /**
     * Retorna true se a stack conter elementos
     * @return boolean se a stack está vazia ou não
     */
    public boolean isEmpty();
    
    /**
     * Retorna o número de elementos da stack
     * @return int o numero de elementos da stack
     */
    public int size();

    /**
     * Retorna uma string que representa a stack
     * @return String que representa a stack
     */
    @Override
    public String toString();
}
