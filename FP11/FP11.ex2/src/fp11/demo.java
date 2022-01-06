package fp11;

import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import PriorityQueue.PriorityQueue;
import java.util.Iterator;

/**
 *
 * @author dmanu
 */
public class demo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ElementNotFoundException, EmptyCollectionException {
        
        PriorityQueue<Integer> q1 = new PriorityQueue<>();
        
        q1.addElement(10, 1);
        q1.addElement(8, 2);
        q1.addElement(12, 2);
        q1.addElement(5, 3);
        q1.addElement(3, 1);
        
        System.out.println("Root: " + q1.getRoot());
        
        Iterator itr = q1.iteratorInOrder();
        
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }
        
        System.out.println("Expected: 10 | Result: " + q1.removeNext());
        System.out.println("Expected: 3 | Result: " + q1.removeNext());
        System.out.println("Expected: 8 | Result: " + q1.removeNext());
        System.out.println("");
        
        Iterator itr2 = q1.iteratorLevelOrder();
        
        while(itr2.hasNext()) {
            System.out.println(itr2.next());
        }
    }
    
}
