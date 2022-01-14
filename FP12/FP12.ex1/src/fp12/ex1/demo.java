package fp12.ex1;

import Exceptions.EmptyCollectionException;
import Exceptions.GraphExceptions;
import Graph.GraphMatrix;
import java.util.Iterator;

/**
 *
 * @author dmanu
 */
public class demo {

    public static void main(String[] args) throws EmptyCollectionException, GraphExceptions {
        tests(1);
    }
    
    public static void tests(int test) throws GraphExceptions, EmptyCollectionException {
        
        GraphMatrix<String> graph = new GraphMatrix<>();
        
        String A = "A", B = "B", C = "C", D = "D", E = "E", G = "G";

        switch (test) {
            //Add test
            case 1:
                try {
                    graph.addVertex(A);
                    graph.addVertex(B);
                    graph.addVertex(C);
                    graph.addVertex(D);
                    //graph.addVertex(E);
                    //graph.addVertex(G);

                    graph.addEdge(A, B);
                    graph.addEdge(B, C);
                    graph.addEdge(B, D);
                    graph.addEdge(A, C);
                    graph.addEdge(C, A);
                
                    System.out.println(graph.toString());
                    }
                    catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                
                break;
                
            //Remove test  
            case 2:
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
                graph.removeVertex(B);
                System.out.println(graph.toString());
                break;
                
            //Connected test    
            case 3:
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
                System.out.println("Connected: " + graph.isConnected());
                break;
                
            //Iterator BFS test    
            case 4:
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
                
                Iterator itrBFS = graph.IteratorBFS(C);
                
                while (itrBFS.hasNext()) {
                    System.out.println(itrBFS.next());
                }
                break;
            
            //Iterator DFS test
            case 5:
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
                
                Iterator itrDFS = graph.IteratorDFS(C);
                
                while (itrDFS.hasNext()) {
                    System.out.println(itrDFS.next());
                }
                break;
            
            //ShotestPath not found test
            case 6:
                try {
                    graph.addVertex(A);
                    graph.addVertex(B);
                    graph.addVertex(C);
                    graph.addVertex(D);
                    graph.addVertex(E);
                    //graph.addVertex(G);


                    graph.addEdge(A, B);
                    graph.addEdge(B, C);
                    graph.addEdge(B, D);
                    graph.addEdge(C, D);
                    graph.addEdge(C, E);
                    graph.addEdge(D, E);
                    //graph.addEdge(D, G);
                    //graph.addEdge(E, G);
                
                    System.out.println(graph.toString());

                    Iterator itrSPFound = graph.iteratorShortesPath(B, G);

                    while (itrSPFound.hasNext()) {
                        System.out.println(itrSPFound.next());
                        }
                    }
                    catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                
                break;
                
                //ShotestPath found test
                case 7:
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
                
                Iterator itrSP = graph.iteratorShortesPath(B, G);
                
                while (itrSP.hasNext()) {
                    System.out.println(itrSP.next());
                }
                break;
        }  
    }
}