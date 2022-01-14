package Network;

import Exceptions.GraphExceptions;
import Graph.GraphMatrix;
import Interfaces.NetworkADT;

/**
 *
 * @author dmanu
 */
public class NetworkMatrix<T> extends GraphMatrix<T> implements NetworkADT<T> {
    
    protected double[][] weightMatrix;

    public NetworkMatrix(double[][] weightMatrix) {
        this.weightMatrix = new double[DEFAULT_CAPACITY][DEFAULT_CAPACITY];
    }

    @Override
    public void addVertex(T vertex) {
        
        if (numVertices == vertices.length) {
            expandCapacity();
        }
        vertices[numVertices] = vertex;
        
        for(int i = 0; i < adjMatrix.length; i++) {
            adjMatrix[numVertices][i] = false;
            adjMatrix[i][numVertices] = false;
        }
        numVertices++;
    }

    protected void expandCapacity() {
        
        super.expandCapacity();
        
        double[][] tmpWeightMatrix = new double[vertices.length * 2][vertices.length * 2];
        
        for (int i = 0; i < weightMatrix.length; i++) {
            for (int j = 0; j < weightMatrix.length; j++) {
                tmpWeightMatrix[i][j] = weightMatrix[i][j];
            }
        }
        weightMatrix = tmpWeightMatrix;
    }

    @Override
    public void removeVertex(T vertex) throws GraphExceptions {
        
        int index = getIndex(vertex);
        
        super.removeVertex(vertex);
        
        for (int i = index; i < numVertices; i++) {
            for (int j = 0; j < numVertices + 1; j++) {
                weightMatrix[i][j] = weightMatrix[i + 1][j];
            }
        }
        
        for (int i = index; i < numVertices; i++) {
            for (int j = 0; j < numVertices + 1; j++) {
                weightMatrix[j][i] = weightMatrix[j][i + 1];
            }
        }
    }
    
    @Override
    public void addEdge(T vertex1, T vertex2, double weight) throws GraphExceptions{
        
        int indexVertex1 = getIndex(vertex1);
        int indexVertex2 = getIndex(vertex2);
        
        super.addEdge(vertex1, vertex2);
        
        weightMatrix[indexVertex1][indexVertex2] = weight;
        weightMatrix[indexVertex2][indexVertex1] = weight;
    }

    @Override
    public void removeEdge(T vertex1, T vertex2) throws GraphExceptions {
        
        int indexVertex1 = getIndex(vertex1);
        int indexVertex2 = getIndex(vertex2);
        
        super.removeEdge(vertex1, vertex2);
        
        weightMatrix[indexVertex1][indexVertex2] = 0;
        weightMatrix[indexVertex2][indexVertex1] = 0;
    }

    @Override
    public double shortestPathWeight(T vertex1, T vertex2) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
