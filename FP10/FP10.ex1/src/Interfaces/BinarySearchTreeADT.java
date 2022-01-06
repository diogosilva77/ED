package Interfaces;

import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;

/**
 *
 * @author dmanu
 */
public interface BinarySearchTreeADT<T> extends BinaryTreeADT<T> {
    
    /**
     * Adiciona um elemento especifico a local proprio desta arvore
     * @param element elemento a ser adicionado a arvore
     */
    public void addElement (T element);
    
    /**
     * Remove e retorna um elemento especifico da arvore
     * @param targetElement elemento a ser removido da arvore
     */
    public T removeElement (T targetElement) throws ElementNotFoundException;
    
    /**
     * Remove todas as ocorrencias do elemento especifico na arvore
     * @param targetElement o elemento que tera todas as instancias 
     * da lista removidas
     */
    public void removeAllOccurrences (T targetElement) throws ElementNotFoundException;
    
    /**
     * Remove e retorna o elemento menor da arvore
     * @return o elemento menor da arvore
     */
    public T removeMin() throws EmptyCollectionException, ElementNotFoundException;
    
    /**
     * Remove e retorna o elemento maior da arvore
     * @return o maior elemento da arvore
     */
    public T removeMax() throws EmptyCollectionException, ElementNotFoundException;
    
    /**
     * Retorna a referencia do elemento menor da arvore
     * @return a referencia do elemento menor da arvore
     */
    public T findMin() throws EmptyCollectionException;
    
    /**
     * Retorna a referencia do elemento maior da arvore
     * @return a referencia do elemento maior da arvore
     */
    public T findMax() throws EmptyCollectionException;
}
