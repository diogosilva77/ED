package Graph;

import Array.ArrayUnorderedList;
import Exceptions.EmptyCollectionException;
import Interfaces.GraphADT;
import java.util.Iterator;
import Exceptions.GraphExceptions;
import Queue.LinkedQueue;
import Stack.LinkedStack;

/**
 *
 * @author dmanu
 */
public class Graph<T> implements GraphADT<T> {
    
    protected final int DEFAULT_CAPACITY = 10;
    protected int numVertices; //numero de vértices do grafo
    protected boolean[][] adjMatrix; //matriz de adjacência
    protected T[] vertices; //values of vertices
    
    /**
     * Cria um grafo vazio.
     */
    public Graph() {
        numVertices = 0;
        this.adjMatrix = new boolean[DEFAULT_CAPACITY][DEFAULT_CAPACITY];
        this.vertices = (T[])(new Object[DEFAULT_CAPACITY]);
    }
    
    /**
     * Adiciona um vértice ao grafo, expandindo a capacidade do gráfico se for
     * necessário. Também associa im objeto ao vértice.
     * @param vertex o vértice a ser adicionado ao grafo
     */
    @Override
    public void addVertex(T vertex) {
        
        if (numVertices == vertices.length) {
            expandCapacity();
        }
        
        vertices[numVertices] = vertex;
        
        for (int i = 0; i <= numVertices; i++) {
            
            adjMatrix[numVertices][i] = false;
            adjMatrix[i][numVertices] = false;
        }
        numVertices++;
    }
    
    /**
     * Cria novas matrizes para armazenar o conteúdo do grafo com o dobro da
     * capacidade.
     */
    protected void expandCapacity() {
        
        T[] largerVertices = (T[]) (new Object[vertices.length * 2]);
        
        boolean[][] largerAdjMatrix = new boolean[vertices.length * 2][vertices.length * 2];
        
        for (int i = 0; i < numVertices; i++) {
            
            for (int j = 0; j < numVertices; j++) {
                
                largerAdjMatrix[i][j] = adjMatrix[i][j];
            }
            largerVertices[i] = vertices[i];
        }
        vertices = largerVertices;
        adjMatrix = largerAdjMatrix;
    }

    @Override
    public void removeVertex(T vertex) throws GraphExceptions {
        
        if (isEmpty()) {
            throw new GraphExceptions(GraphExceptions.EMPTY_GRAPH);
        }
        
        int index = getIndex(vertex);
        
        if (index == -1) {
            throw new GraphExceptions(GraphExceptions.ELEMENT_NOT_FOUND);
        }
        
        for (int i = index; i < numVertices - 1; i++) {
            vertices[i] = vertices[i + 1];
        }
        
        for (int i = index; i < numVertices - 1; i++) {
            
            for (int j = 0; j <= numVertices; j++) {
                adjMatrix[i][j] = adjMatrix[i + 1][j];
            }
        }
        
        for (int i = index; i < numVertices - 1; i++) {
            
            for (int j = 0; j < numVertices; j++) {
                adjMatrix[j][i] = adjMatrix[j][i + 1];
            }
        }
        
        numVertices--;
    }

    /**
     * Insere uma aresta entre dois vértices do grafo.
     * @param vertex1 o primeiro vértice
     * @param vertex2 o segundo vértice
     */
    @Override
    public void addEdge(T vertex1, T vertex2) {
        
        addEdge(getIndex(vertex1), getIndex(vertex2));
    }
    
    /**
     * Insere uma aresta entre dois vértices do grafo.
     * @param index1 o primeiro índice
     * @param index2 o segundo índice
     */
    public void addEdge(int index1, int index2) {
        
        if (indexIsValid(index1) && indexIsValid(index2)) {
            adjMatrix[index1][index2] = true;
            adjMatrix[index2][index1] = true;
        }
    }
    
    /**
     * Retorna o valor do índice da primeira ocorrência do vértice.
     * @param vertex
     * @return -1 se o vértice não for encontrado
     */
    private int getIndex (T vertex) {
        
        for (int i = 0; i < numVertices; i++) {
            
            if (vertices[i].equals(vertex)) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * @param index
     * @return true se o índice fornecido for válido
     */
    public boolean indexIsValid (int index) {
        
        if (index < numVertices && index >= 0) {
            return true;
        }
        return false;
    }
    
    @Override
    public void removeEdge(T vertex1, T vertex2) {
  
    }

    @Override
    public Iterator IteratorBFS(T startVertex) throws EmptyCollectionException {
        return IteratorBFS(getIndex(startVertex));
    }
    
    private Iterator IteratorBFS(int startIndex) throws EmptyCollectionException {
        
        Integer x;
        LinkedQueue<Integer> traversalQueue = new LinkedQueue<Integer>();
        ArrayUnorderedList<T> resultList = new ArrayUnorderedList<T>();
        
        if (!indexIsValid(startIndex)) {
            return resultList.iterator();
        }
        
        boolean[] visited = new boolean[numVertices];
        
        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
        }
        
        traversalQueue.enqueue(new Integer(startIndex));
        visited[startIndex] = true;
        
        while (!traversalQueue.isEmpty()) {
            
            x = traversalQueue.dequeue();
            resultList.addToRear(vertices[x.intValue()]);
            
            /** Find all vertices adjacent to x that have
            not been visited and queue them up */
            for (int i = 0; i < numVertices; i++) {
                
                if (adjMatrix[x.intValue()][i] && !visited[i]) {
                    
                    traversalQueue.enqueue(new Integer(i));
                    visited[i] = true;
                }
            }
        }
        return resultList.iterator();
    }
    
    @Override
    public Iterator IteratorDFS(T startVertex) throws EmptyCollectionException{
        return IteratorDFS(getIndex(startVertex));
    }
    
    private Iterator IteratorDFS(int startIndex) throws EmptyCollectionException {
        
        Integer x;
        boolean found;
        LinkedStack<Integer> traversalStack = new LinkedStack<Integer>();
        ArrayUnorderedList<T> resultList = new ArrayUnorderedList<T>();
        boolean[] visited = new boolean[numVertices];
        
        if (!indexIsValid(startIndex)) {
            return resultList.iterator();
        }
        
        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
        }
        
        traversalStack.push(new Integer(startIndex));
        resultList.addToRear(vertices[startIndex]);
        visited[startIndex] = true;
        
        while (!traversalStack.isEmpty()) {
            
            x = traversalStack.peek();
            found = false;
            
            /** Find a vertex adjacent to x that has not been visited
            and push it on the stack */
            for (int i = 0; (i < numVertices) && !found; i++) {
                
                if (adjMatrix[x.intValue()][i] && !visited[i]) {
                    
                    traversalStack.push(new Integer(i));
                    resultList.addToRear(vertices[i]);
                    visited[i] = true;
                    found = true;
                }
            }
            if (!found && !traversalStack.isEmpty()) {
                traversalStack.pop();
            }
        }
        return resultList.iterator();
    }
    
    @Override
    public Iterator iteratorShortesPath(T startVertex, T targetVertex) throws EmptyCollectionException{
        
        Integer x;
        LinkedQueue<Integer> traversalQueue = new LinkedQueue<Integer>();
        ArrayUnorderedList<T> resultList = new ArrayUnorderedList<>();
        int startIndex = getIndex(startVertex);
        int targetIndex = getIndex(targetVertex);
        int[][] info = new int[vertices.length][3];
        boolean found = false;
        int counter = 0;

        if (!indexIsValid(startIndex) || !indexIsValid(targetIndex)) {
            return resultList.iterator();
        }

        boolean[] visited = new boolean[numVertices];
        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
        }

        traversalQueue.enqueue(new Integer(startIndex));
        //Index of Vertex
        info[counter][0] = startIndex;
        //PathLength
        info[counter][1] = 0;
        //LastVertex
        info[counter][2] = -1;
        visited[startIndex] = true;

        while (!found && !traversalQueue.isEmpty()) {
            x = traversalQueue.dequeue();
            /** Find all vertices adjacent to x that have
             not been visited and queue them up */
            for (int i = 0; i < numVertices; i++) {
                if (adjMatrix[x.intValue()][i] && !visited[i]) {
                    traversalQueue.enqueue(new Integer(i));
                    counter++;
                    info[counter][0] = i;
                    info[counter][1] = info[x.intValue()][1] + 1;
                    info[counter][2] = info[x.intValue()][0];
                    visited[i] = true;
                    if (i == targetIndex) {
                        found = true;
                    }
                }
            }
        }

        if (found) {
            resultList.addToFront(vertices[info[counter][0]]);
            int lastIndex = info[counter][2];
            while (lastIndex != -1) {
                resultList.addToFront(vertices[info[lastIndex][0]]);
                lastIndex = info[lastIndex][2];
            }

        }
        return resultList.iterator();
    }

    @Override
    public boolean isEmpty() {
        return (numVertices == 0);
    }

    @Override
    public boolean isConnected() throws GraphExceptions, EmptyCollectionException {
        
        if (isEmpty()) {
            throw new GraphExceptions(GraphExceptions.EMPTY_GRAPH);
        }

        Iterator itr = IteratorBFS(0);
        int count = 0;

        while (itr.hasNext()) {
            itr.next();
            count++;
        }

        return (count == numVertices);
    }

    @Override
    public int size() {
        return numVertices;
    }

    @Override
    public String toString() {
        
        String text = " ";
        
        for(int i = 0; i < numVertices; i++) {
            text += "  " + vertices[i].toString();
        }
        
        text += "\n";
        
        for (int i = 0; i < numVertices; i++) {
            
            text += "" + vertices[i].toString() + "|";
            
            for (int j = 0; j < numVertices; j++) {
                
                text += " ";
                
                if (adjMatrix[i][j] == true) {
                    text += "T ";    
                }
                else {
                    text += "F ";
                }
            }
            text += "\n";
        }
        return text;
    }    
}