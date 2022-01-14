package Interfaces;

import Exceptions.EmptyCollectionException;
import java.util.Iterator;
import Exceptions.GraphExceptions;
/**
 *
 * @author dmanu
 */
public interface GraphADT<T> {
    
    /**
     * Adiciona um vértice ao grafo, associando objeto a vértice.
     * @param vertex o vértice a ser adicionado a este grafo
     */
    public void addVertex (T vertex);
    
    /**
     * Remove o único vértice do grafo com o valor fornecido.
     * @param vertex o vértice a ser removido no grafo
     */
    public void removeVertex(T vertex) throws GraphExceptions;
    
    /**
     * Insere uma aresta entre dois vértices do grafo.
     * @param vertex1 o primeiro vértice
     * @param vertex2 o segundo vértice
     */
    public void addEdge (T vertex1, T vertex2) throws GraphExceptions;
    
    /**
     * Remove uma aresta entre dois vértices do grafo. 
     * @param vertex1 o primeiro vértice
     * @param vertex2 o segundo vértice
     */
    public void removeEdge (T vertex1, T vertex2) throws GraphExceptions;
    
    /**
     * Retorna o primeiro iterador de largura começando com o vértice fornecido.
     * @param startVertex o vértice inicial
     * @return o primeiro iterador de larfura começando no determinado
     * vértice
     */
    public Iterator IteratorBFS (T startVertex) throws EmptyCollectionException;
    
    /**
     * Retorna o primeiro iterador de profundidade começando com o vértice fornecido.
     * @param startVertex o vértice inicial
     * @return o primeiro iterador de profundidade começando no determinado
     */
    public Iterator IteratorDFS (T startVertex) throws EmptyCollectionException;
    
    /**
     * Retorna um iterador que contém o caminho mais curto entre os dois vértices.
     * @param startVertex o vértice inicial
     * @param targetVertex o vértice final
     * @return um iterador que contém o caminho mais curto entre os dois vértices.
     */
    public Iterator iteratorShortesPath (T startVertex, T targetVertex) throws EmptyCollectionException;
    
    /**
     * Retorna true se o grafo estiver vazio, e falso em caso contrário.
     * @return true se o grafo estiver vazio
     */
    public boolean isEmpty();
    
    /**
     * Retorna true se o grado estiver conectado, e falso em caso contrário.
     * @return true se o grado estiver conectado
     * @throws Exceptions.GraphExceptions
     */
    public boolean isConnected() throws GraphExceptions, EmptyCollectionException;

    /**
     * Retorna o número de vértices do grafo.
     * @return o número inteiro de vértices do grafo.
     */
    public int size();
    
    /**
     * Retorna uma representação de string da matriz de adjacência.
     * @return uma representação de string da matriz de adjacência
     */
    public String toString();
}