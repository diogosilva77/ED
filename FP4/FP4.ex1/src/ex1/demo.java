package ex1;

import Queue.EmptyCollectionException;

/**
 *
 * @author dmanu
 */
public class demo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws EmptyCollectionException {
        
        LinkedQueue<Integer> q1 = new LinkedQueue<> ();
        
        q1.enqueue(1);
        q1.enqueue(2);
        //q1.enqueue(3);
        //q1.enqueue(4);
        
        try{
            System.out.println("Tamanho: " + q1.size());
            System.out.println("First: " + q1.first());
            System.out.println(q1.toString());
        }catch(Exception ex){
            System.out.println("Erro: " + ex.getMessage());
        }
        
        q1.dequeue();
        q1.dequeue();
        
        try{
            System.out.println(q1.toString());
            System.out.println("Tamanho: " + q1.size());
            System.out.println("First: " + q1.first());
            System.out.println(q1.isEmpty());
        }catch(Exception ex){
            System.out.println("Erro: " + ex.getMessage());
        }
        

    }
    
}
