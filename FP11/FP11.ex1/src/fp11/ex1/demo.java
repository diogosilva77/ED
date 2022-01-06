package fp11.ex1;

import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import Tree.ArrayHeap;
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
        
        ArrayHeap<Integer> heap = new ArrayHeap<>();
        
        heap.addElement(9);
        heap.addElement(7);
        heap.addElement(8);
        heap.addElement(4);
        heap.addElement(5);
        heap.addElement(3);
        
        
        //System.out.println("Min: " + heap.findMin());
        //heap.removeMin();
        //heap.removeMin();
        //heap.removeMin();
        System.out.println("Root: " + heap.getRoot());
        
        Iterator itr = heap.iteratorLevelOrder();
        
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
    
}
