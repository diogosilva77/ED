package Interfaces;

import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import java.util.Iterator;

/**
 *
 * @author dmanu
 */
public interface BinaryTreeADT<T> {
    
    /**
     * Retorna a referencia do elemento root
     * @return a referencia do elemento root
     */
    public T getRoot() throws ElementNotFoundException;
    
    /**
     * Retorna true se a arvore binaria tiver vazia e false se tiver elementos
     * @return true se a arvore binaria tiver vazia
     */
    public boolean isEmpty();
    
    /**
     * Retorna o numero de elementos da arvore binaria
     * @return o inteirto do numero de elementos da arvore
     */
    public int size();
    
    /**
     * Retorna true se a arvore binaria conter o elemento especifico e false se não encontrar
     * @param targetElement o elemento a ser procurado na arvore binaria 
     * @return true se a arvore binaria contiver o elemento
     */
    public boolean contains(T targetElement) throws ElementNotFoundException;
    
    /**
     * Retorna a referencia do elemento especifico se for encontrado.
     * Lança uma exceção se o elemento especifico não for encontrado
     * @param targetElement o elemento a ser procurado na arvore binaria
     * @return a referencia do elemento especifico
     */
    public T find (T targetElement) throws ElementNotFoundException;
    
    /**
     * Retorna uma string que representa a arvore binaria
     * @return a string de representação da arvore binaria
     */
    public String toString();
    
    /**
     * Executa uma travessia InOrder na arvore binaria,
     * chamando um metodo recursivo InOrder que começa na raiz
     * @return o iterador com os elementos da arvore binaria
     */
    public Iterator<T> iteratorInOrder();
    
    /**
     * Executa uma travessia PreOrder na arvore binaria,
     * chamando um metodo recursivo PreOrder que começa na raiz
     * @return o iterador com os elementos da arvore binaria
     */
    public Iterator<T> iteratorPreOrder();
    
    /**
     * Executa uma travessia PostOrder na arvore binaria,
     * chamando um metodo recursivo PostOrder que começa na raiz
     * @return o iterador com os elementos da arvore binaria
     */
    public Iterator<T> iteratorPostOrder();
    
    /**
     * Executa uma travessia LevelOrder na arvore binaria, usando uma queue
     * @return o iterador com os elementos da arvore binaria
     */
    public Iterator<T> iteratorLevelOrder() throws ElementNotFoundException, EmptyCollectionException;
}
