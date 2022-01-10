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
        
        String A = "A", B = "B", C = "C", D = "D";
        
        graph.addVertex(A);
        graph.addVertex(B);
        graph.addVertex(C);
        graph.addVertex(D);
        
        graph.addEdge(A, B);
        graph.addEdge(B, A);
        graph.addEdge(A, C);
        graph.addEdge(C, A);
        graph.addEdge(B, C);
        graph.addEdge(C, B);
        graph.addEdge(B, D);
        graph.addEdge(D, B);

        System.out.println(graph.toString());
        
        
        Iterator itr = graph.IteratorDFS(C);
        
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
    
}