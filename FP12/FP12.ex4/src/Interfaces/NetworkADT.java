package Interfaces;

import Exceptions.GraphExceptions;

/**
 *
 * @author dmanu
 */
public interface NetworkADT<T> extends GraphADT<T> {
    
    /**
     * Insere uma aresta entre dois vértices do grafo
     * @param vertex1 o primeito vértice
     * @param vertex2 o segundo vértice
     * @param weight o peso
     */
    public void addEdge (T vertex1, T vertex2, double weight) throws GraphExceptions;
    
    /**
     * Retorna o peso do caminho mais curto
     * @param vertex1 o primeiro vértice
     * @param vertex2 o segundo vértice
     * @return o peso do caminho mais curto na network
     */
    public double shortestPathWeight (T vertex1, T vertex2);
}
