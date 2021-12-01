package SortSearch;

import List.LinkNode;
import List.LinkedList;

/**
 *
 * @author dmanu
 */
public class SortingandSearching {
    
    /**
     * 
     * @param <T> 
     * @param data array a ser procurado
     * @param min a representação inteira do valor mínimo
     * @param max a representação inteira do valor máximo
     * @param target elemento a ser procurado
     * @return true se o elemento procurado for encontrado
     */
    public static <T extends Comparable<? super T>> boolean linearSearch (LinkedList<T> data, T target) {
        
        LinkNode<T> current = data.getHead();
        boolean found = false;
        
        while (current != null) {
            
            if (current.getElement().compareTo(target) == 0) { //retorna 1 se for maior que o elemento, -1 se for menor, 0 se for igual
                found = true;
            }
            current = current.getNext();
        }
        return found;
    }
    
    public static <T extends Comparable<? super T>> boolean binarySearch (LinkedList<T> data, int min, int max, T target) {
        
        int i = 0;
        LinkNode<T> current = data.getHead();
        T[] array = (T[]) new Comparable[data.getSize()];

        while (current != null) {
            array[i] = (T) current.getElement();
            current = current.getNext();
            i++;
        }

        return BinarySearch.binarySearch(array, 0, data.getSize(), target);
    }
}