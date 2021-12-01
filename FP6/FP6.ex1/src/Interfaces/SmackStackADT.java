/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

/**
 *
 * @author dmanu
 */
public interface SmackStackADT<T> {
    
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
     * Remove e retorna o primeiro elemento da stack
     * @return o primeiro elemento da stack
     * @throws EmptyCollectionException 
     */
    public T smack() throws EmptyCollectionException;
    
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
