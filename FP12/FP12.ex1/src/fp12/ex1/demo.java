package fp12.ex1;

import Exceptions.EmptyCollectionException;
import Graph.Graph;
import java.util.Iterator;

/**
 *
 * @author dmanu
 */
public class demo {

    public static void main(String[] args) throws EmptyCollectionException {
        
        Graph<String> graph = new Graph<>();
        
        String A = "A", B = "B", C = "C", D = "D", E = "E", G = "G";
        
        graph.addVertex(A);
        graph.addVertex(B);
        graph.addVertex(C);
        graph.addVertex(D);
        graph.addVertex(E);
        graph.addVertex(G);
        
        graph.addEdge(A, B);
        graph.addEdge(B, C);
        graph.addEdge(B, D);
        graph.addEdge(C, D);
        graph.addEdge(C, E);
        graph.addEdge(D, E);
        graph.addEdge(D, G);
        graph.addEdge(E, G);
        
   
        System.out.println(graph.toString());
        
        
        Iterator itr = graph.IteratorDFS(D);
        
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
    
}