package fp10.ex2;

import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import Tree.ArrayBinarySearchTree;
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
        
        ArrayBinarySearchTree<Integer> tree = new ArrayBinarySearchTree<>();
        
        tree.addElement(10);
        tree.addElement(5);
        tree.addElement(15);
        tree.addElement(3);
        tree.addElement(7);
        tree.addElement(13);
        tree.addElement(2);
        tree.addElement(4);
        tree.addElement(7);
        tree.addElement(1);
        tree.addElement(17);
        tree.addElement(24);
        tree.addElement(12);
        tree.addElement(16);
       
        //tree.removeAllOccurrences(7);
        
        System.out.println("Min: " + tree.findMin());
        System.out.println("Max: " + tree.findMax());
        //tree.removeMin();
        //tree.removeMax();
               
        Iterator itr = tree.iteratorPreOrder();
        
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }    
}
