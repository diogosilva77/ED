package Interfaces;

import Exceptions.EmptyCollectionException;


/**
 *
 * @author dmanu
 */
public interface QueueADT<T> {
    
    /**
     * Adiciona um elemento ao final da fila
     * @param element o elemento a ser adicionado ao final desta fila
     */
    public void enqueue (T element);
    
    /**
     * Remove e retorna o elemento na frente da fila
     * @return o elemento na frente da fila
     */
    public T dequeue() throws EmptyCollectionException;
    
    /**
     * * Retorna sem remover o elemento na frente da fila
     * @return o primeiro elemento na fila
     */
    public T first() throws EmptyCollectionException;
    
    /**
     * Retorna verdadeiro se a fila não conter elementos
     * @return true se a fila estiver vazia
     */
    public boolean isEmpty();
    
    /**
     * Retorna o número de elementos na fila.
     * @return a representação inteira do tamanho da fila
     */
    public int size();
    
    /**
     * Retorna uma representação de string da fila.
     * @return a representação de string da fila
     */
    public String toString();
}
