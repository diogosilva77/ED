package fp9.ex2;

import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import Tree.ArrayBinaryTree;
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
        
        String[] elements = {"A", "B", "C", "D", "E"};
        
        ArrayBinaryTree<String[]> tree = new ArrayBinaryTree<>(elements);
        
        Iterator itr = tree.iteratorLevelOrder();
        
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
    
}
