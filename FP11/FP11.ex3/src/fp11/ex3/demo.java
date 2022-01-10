package fp11.ex3;

import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import Tree.LinkedHeap;
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
        
        LinkedHeap<Integer> heap = new LinkedHeap<>();
        
        heap.addElement(10);
        heap.addElement(12);
        heap.addElement(5);
        heap.addElement(3);
        heap.addElement(15);
        
        System.out.println("Root: " + heap.getRoot());
        //heap.removeMin();
        
        Iterator itr = heap.iteratorPreOrder();
        
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
    
}
