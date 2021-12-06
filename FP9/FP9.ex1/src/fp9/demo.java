package fp9;

import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import Tree.BinaryTreeNode;
import Tree.LinkedBinaryTree;
import java.util.Iterator;

/**
 *
 * @author dmanu
 */
public class demo {

    public static void main(String[] args) throws ElementNotFoundException, EmptyCollectionException {
        
        LinkedBinaryTree<String> tree = new LinkedBinaryTree<>("A");
        
        BinaryTreeNode<String> n1 = new BinaryTreeNode<>("B");
        BinaryTreeNode<String> n2 = new BinaryTreeNode<>("C");
        BinaryTreeNode<String> n3 = new BinaryTreeNode<>("D");
        BinaryTreeNode<String> n4 = new BinaryTreeNode<>("E");
        //BinaryTreeNode<String> n5 = new BinaryTreeNode<>("F");
        //BinaryTreeNode<String> n6 = new BinaryTreeNode<>("G");
        
        tree.root.setLeft(n1);
        tree.root.setRight(n2);
        n1.setLeft(n3);
        n1.setRight(n4);
        //n3.setLeft(n5);
        //n3.setRight(n6);
        
        Iterator itr = tree.iteratorLevelOrder();
        
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
    }
    
}
