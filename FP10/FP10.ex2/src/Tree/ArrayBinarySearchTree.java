
package Tree;

import Array.ArrayUnorderedList;
import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import Interfaces.BinarySearchTreeADT;
import java.util.Iterator;

/**
 *
 * @author dmanu
 */
public class ArrayBinarySearchTree<T> extends ArrayBinaryTree<T> implements BinarySearchTreeADT<T> {
    
    protected int height;
    protected int maxIndex;

    public ArrayBinarySearchTree() {
        super();
        height = 0;
        maxIndex = -1;
    }

    public ArrayBinarySearchTree(T element) {
       super(element);
       height = 1;
       maxIndex = 0;
    }
    /**
     * Adiciona o objeto especifico na árvore de pesquisa binaria, na posição 
     * apropriada de acordo com o seu valor chave. Observar que elementos iguais são
     * adicionados a direita. O indice do filho esquerdo do currentIndex, pode ser
     * encontrado dobrando o currentIndex e adicionando 1. Para encontrar o indice
     * do filho direito, dobra-se o currentIndex e adiciona-se 2.
     * @param element o elemento a ser adicionado na árvore de pesquisa
     */
    @Override
    public void addElement(T element) {

        if (tree.length < maxIndex * 2 + 3) {

            expandCapacity();
        }

        Comparable<T> tempelement = (Comparable<T>) element;

        if (isEmpty()) {

            tree[0] = element;
            maxIndex = 0;
        } else {
            boolean added = false;
            int currentIndex = 0;

            while (!added) {
                if (tempelement.compareTo((tree[currentIndex])) < 0) {
                    //go left
                    if (tree[currentIndex * 2 + 1] == null) {

                        tree[currentIndex * 2 + 1] = element;
                        added = true;

                        if (currentIndex * 2 + 1 > maxIndex) {
                            maxIndex = currentIndex * 2 + 1;
                        }
                    } else {
                        currentIndex = currentIndex * 2 + 1;
                    }
                } else {
                    //go right
                    if (tree[currentIndex * 2 + 2] == null) {

                        tree[currentIndex * 2 + 2] = element;
                        added = true;

                        if (currentIndex * 2 + 2 > maxIndex) {
                            maxIndex = currentIndex * 2 + 2;
                        }
                    } else {
                        currentIndex = currentIndex * 2 + 2;
                    }
                }
            }
        }
        height = (int)(Math.log(maxIndex + 1) / Math.log(2)) + 1;
        count++;
    }

    private void expandCapacity() {
        
        T[] tmp = (T[]) new Object[tree.length + CAPACITY];
        
        for (int i = 0; i < tree.length; i++) {
            tmp[i] = tree[i];
        }
        tree = tmp;
    }

    @Override
    public T removeElement(T targetElement) throws ElementNotFoundException, EmptyCollectionException {
        
        T result = null;
        boolean found = false;
        
        if (isEmpty()) {
            
            throw new ElementNotFoundException(EmptyCollectionException.EMPTYCOLLECTION);
        }
        
        Comparable<T> tempElement = (Comparable<T>) targetElement;
        
        int targetIndex = findIndex (tempElement, 0);
        
        result = tree[targetIndex];
        replace(targetIndex);
        count--;
        
        int temp = maxIndex;
        maxIndex = -1;
        
        for (int i = 0; i <= temp; i++) {
            
            if (tree[i] != null) {
                maxIndex = i;
            }
        }
        height = (int)(Math.log(maxIndex + 1) / Math.log(2)) + 1;
        
        return result;
    }
    
    protected void replace(int targetIndex) throws EmptyCollectionException {
        
        int currentIndex, parentIndex, temp, oldIndex, newIndex;

        ArrayUnorderedList<Integer> oldlist = new ArrayUnorderedList<Integer>();
        ArrayUnorderedList<Integer> newlist = new ArrayUnorderedList<Integer>();
        ArrayUnorderedList<Integer> templist = new ArrayUnorderedList<Integer>();
        Iterator<Integer> oldIt, newIt;

        // if target node has no children
        if ((targetIndex * 2 + 1 >= tree.length) || (targetIndex * 2 + 2 >= tree.length)) {
            tree[targetIndex] = null;
            
        } // if target node has no children
        else if ((tree[targetIndex * 2 + 1] == null) && (tree[targetIndex * 2 + 2] == null)) {
            tree[targetIndex] = null;
            
        } // if target node only has a left child
        else if ((tree[targetIndex * 2 + 1] != null) && (tree[targetIndex * 2 + 2] == null)) {

            // fill newlist with indices of nodes that will replace 
            // the corresponding indices in oldlist
            // fill newlist
            currentIndex = targetIndex * 2 + 1;
            templist.addToRear(new Integer(currentIndex));
            
            while (!templist.isEmpty()) {
                
                currentIndex = ((Integer) templist.removeFirst()).intValue();
                newlist.addToRear(new Integer(currentIndex));
                
                if ((currentIndex * 2 + 2) <= (Math.pow(2, height) - 2)) {
                    
                    templist.addToRear(new Integer(currentIndex * 2 + 1));
                    templist.addToRear(new Integer(currentIndex * 2 + 2));
                }
            }
            // fill oldlist
            currentIndex = targetIndex;
            templist.addToRear(new Integer(currentIndex));
            
            while (!templist.isEmpty()) {
                
                currentIndex = ((Integer) templist.removeFirst()).intValue();
                oldlist.addToRear(new Integer(currentIndex));
                
                if ((currentIndex * 2 + 2) <= (Math.pow(2, height) - 2)) {
                    
                    templist.addToRear(new Integer(currentIndex * 2 + 1));
                    templist.addToRear(new Integer(currentIndex * 2 + 2));
                }
            }
            // do replacement
            oldIt = oldlist.iterator();
            newIt = newlist.iterator();
            
            while (newIt.hasNext()) {
                
                oldIndex = oldIt.next();
                newIndex = newIt.next();
                tree[oldIndex] = tree[newIndex];
                tree[newIndex] = null;
            }
        } // if target node only has a right child
        else if ((tree[targetIndex * 2 + 1] == null) && (tree[targetIndex * 2 + 2] != null)) {

            // fill newlist with indices of nodes that will replace 
            // the corresponding indices in oldlist
            // fill newlist
            currentIndex = targetIndex * 2 + 2;
            templist.addToRear(new Integer(currentIndex));
            
            while (!templist.isEmpty()) {
                
                currentIndex = ((Integer) templist.removeFirst()).intValue();
                newlist.addToRear(new Integer(currentIndex));
                
                if ((currentIndex * 2 + 2) <= (Math.pow(2, height) - 2)) {
                    
                    templist.addToRear(new Integer(currentIndex * 2 + 1));
                    templist.addToRear(new Integer(currentIndex * 2 + 2));
                }
            }
            // fill oldlist
            currentIndex = targetIndex;
            templist.addToRear(new Integer(currentIndex));
            
            while (!templist.isEmpty()) {
                currentIndex = ((Integer) templist.removeFirst()).intValue();
                oldlist.addToRear(new Integer(currentIndex));
                
                if ((currentIndex * 2 + 2) <= (Math.pow(2, height) - 2)) {
                    
                    templist.addToRear(new Integer(currentIndex * 2 + 1));
                    templist.addToRear(new Integer(currentIndex * 2 + 2));
                }
            }
            // do replacement
            oldIt = oldlist.iterator();
            newIt = newlist.iterator();
            
            while (newIt.hasNext()) {
                
                oldIndex = oldIt.next();
                newIndex = newIt.next();
                tree[oldIndex] = tree[newIndex];
                tree[newIndex] = null;
            }
        } // target node has two children
        else {
            currentIndex = targetIndex * 2 + 2;

            while (tree[currentIndex * 2 + 1] != null) {
                currentIndex = currentIndex * 2 + 1;
            }

            tree[targetIndex] = tree[currentIndex];

            // the index of the root of the subtree to be replaced
            int currentRoot = currentIndex;

            // if currentIndex has a right child
            if (tree[currentRoot * 2 + 2] != null) {

                // fill newlist with indices of nodes that will replace 
                // the corresponding indices in oldlist
                // fill newlist
                currentIndex = currentRoot * 2 + 2;
                templist.addToRear(new Integer(currentIndex));
                
                while (!templist.isEmpty()) {
                    
                    currentIndex = ((Integer) templist.removeFirst()).intValue();
                    newlist.addToRear(new Integer(currentIndex));
                    
                    if ((currentIndex * 2 + 2) <= (Math.pow(2, height) - 2)) {
                        
                        templist.addToRear(new Integer(currentIndex * 2 + 1));
                        templist.addToRear(new Integer(currentIndex * 2 + 2));
                    }
                }

                // fill oldlist
                currentIndex = currentRoot;
                templist.addToRear(new Integer(currentIndex));
                
                while (!templist.isEmpty()) {
                    currentIndex = ((Integer) templist.removeFirst()).intValue();
                    oldlist.addToRear(new Integer(currentIndex));
                    
                    if ((currentIndex * 2 + 2) <= (Math.pow(2, height) - 2)) {
                        
                        templist.addToRear(new Integer(currentIndex * 2 + 1));
                        templist.addToRear(new Integer(currentIndex * 2 + 2));
                    }
                }

                // do replacement
                oldIt = oldlist.iterator();
                newIt = newlist.iterator();
                
                while (newIt.hasNext()) {
                    
                    oldIndex = oldIt.next();
                    newIndex = newIt.next();
                    tree[oldIndex] = tree[newIndex];
                    tree[newIndex] = null;
                }
            } else {
                tree[currentRoot] = null;
            }
        }
    }
    
    protected int findIndex (Comparable<T> targetElement, int n) throws ElementNotFoundException {
        
        int result = 0;
        
        if (n > tree.length) { //Se o index for maior que o tamanho da arvore
            throw new ElementNotFoundException("Index não existe!");
        }
        if (tree[n] == null) { //Se o elemento na posição "n" for null
            throw new ElementNotFoundException("Elemento é null");
        }
        if (targetElement.compareTo(tree[n]) == 0) { //Se o elemento na posição "n" for 0
            result = n;
        }
        else{
            if (targetElement.compareTo(tree[n]) > 0) {
                result = findIndex(targetElement, (2 * (n + 1)));
            }
            else{
                result = findIndex(targetElement, (2 * n + 1));
            }
        }
        return result;
    }
    
    @Override
    public void removeAllOccurrences(T targetElement) throws ElementNotFoundException, EmptyCollectionException {
        
        removeElement(targetElement);
        
        try{
            while (contains ((T)targetElement)) {
                removeElement(targetElement);
            }
        }
        catch (Exception e) {  
        }
    }

    @Override
    public T removeMin() throws EmptyCollectionException, ElementNotFoundException {
        
        if (isEmpty()) {
            throw new EmptyCollectionException(EmptyCollectionException.EMPTYCOLLECTION);
        }

        return removeElement(findMin());
    }

    @Override
    public T removeMax() throws EmptyCollectionException, ElementNotFoundException {
        
        if (isEmpty()) {
            throw new EmptyCollectionException(EmptyCollectionException.EMPTYCOLLECTION);
        }
        return removeElement(findMax());
    }

    @Override
    public T findMin() throws EmptyCollectionException {
        
        T result = null;
        
        if (isEmpty()) {
            throw new EmptyCollectionException(EmptyCollectionException.EMPTYCOLLECTION);
        }
        else {
            int currentIndex = 0;
            
            while ((currentIndex * 2 + 1 <= maxIndex) && (tree[currentIndex * 2 + 1] != null)) {
                
                currentIndex = currentIndex * 2 + 1;
            }
            result = tree[currentIndex];
        }
        return result;
    }

    @Override
    public T findMax() throws EmptyCollectionException {
        
        T result = null;
        
        if (isEmpty()) {
            throw new EmptyCollectionException(EmptyCollectionException.EMPTYCOLLECTION);
        }
        else {
            int curretIndex = 0;
            
            while ((curretIndex * 2 + 2 <= maxIndex) && (tree[curretIndex * 2 + 2]) != null) {
                
                curretIndex = curretIndex * 2 + 2;
            }
            result = tree[curretIndex];
        }
        return result;
   }  
}
