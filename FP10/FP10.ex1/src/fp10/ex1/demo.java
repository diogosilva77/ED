package fp10.ex1;

import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import Tree.LinkedBinarySearchTree;
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
        
        LinkedBinarySearchTree<Integer> tree = new LinkedBinarySearchTree<>();
        
        tree.addElement(10);
        tree.addElement(5);
        tree.addElement(15);
        tree.addElement(3);
        tree.addElement(7);
        tree.addElement(13);
        tree.addElement(2);
        tree.addElement(4);
        
        //tree.removeElement(5);
        
        System.out.println("Min: " + tree.findMin());
        System.out.println("Max: " + tree.findMax());
        System.out.println("Size: " + tree.size());
        
        tree.removeMin();
        tree.removeMax();
        
        Iterator itr = tree.iteratorLevelOrder();
        
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        
        System.out.println("Min: " + tree.findMin());
        System.out.println("Max: " + tree.findMax());
        System.out.println("Size: " + tree.size());
    }
    
}
