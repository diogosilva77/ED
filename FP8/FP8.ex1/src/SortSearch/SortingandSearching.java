package SortSearch;

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
    public static <T extends Comparable<? super T>> boolean linearSearch (T[] data, int min, int max, T target) {
        
        int index = min;
        boolean found = false;
        
        while (!found && index <= max) {
            
            if (data[index].compareTo(target) == 0) { //retorna 1 se for maior que o elemento, -1 se for menor, 0 se for igual
                found = true;
            }
            index++;
        }
        return found;
    }
    
    /**
     * 
     * @param <T> 
     * @param data array a ser procurado
     * @param min a representação inteira do valor mínimo
     * @param max a representação inteira do valor máximo
     * @param target elemento a ser procurado
     * @return true se o elemento procurado for encontrado
     */
    public static <T extends Comparable<? super T>> boolean binarySearch (T[] data, int min, int max, T target) {
        
        boolean found = false;
        int midpoint = (min + max) / 2; // determina o midpoint
        
        if (data[midpoint].compareTo(target) == 0) { //retorna 1 se for maior que o elemento, -1 se for menor, 0 se for igual
            
            found = true;
        }
        else if (data[midpoint].compareTo(target) > 0) {
            if (min <= midpoint - 1){
                found = binarySearch(data, min, midpoint - 1, target);
            }
        }
        else if (midpoint + 1 <= max) {
            
            found = binarySearch(data, midpoint + 1, max, target);
        }
        return found;
    }
}
