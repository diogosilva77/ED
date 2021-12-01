
package ex1;

import Interfaces.EmptyCollectionException;
import Interfaces.OrderedListADT;

/**
 *
 * @author dmanu
 * @param <T>
 */
public class ArrayOrderedList<T> extends ArrayList<T> implements OrderedListADT<T>{

    public ArrayOrderedList() {
    }

   
    @Override
    public void add(T element) throws EmptyCollectionException {
        
        if (this.array.length == size()) {

            expandList();
        }
        
        if (element instanceof Comparable) {
            //adiciona na primeira posição se tiver vazio
            if (isEmpty()) {
                array[0] = element;
            }
            else { //adiciona no meio se encontrar elementos com valor maior
                boolean found = false;
                int index = 0;

                while (index < size() && found == false) {

                    Comparable<T> tmp = (Comparable<T>) array[index];

                    if (tmp.compareTo(element) > 0) { //retorna 1 se for maior que o elemento, -1 se for menor

                        found = true;
                    } else {
                        index++;
                    }
                }

                if (found == true) {

                    for (int i = size - 1; i >= index; i--) {
                        array[i + 1] = array[i];
                    }
                    array[index] = element;
                }
                else{ //adiciona no fim se os casos anteriores nao se verificarem
                    array[size] = element;
                }

            }
            size++;
            modCount++;
        }
        else{
            throw new EmptyCollectionException("Não é instância de Comparable");
        }
    }
    
    private void expandList() {

        T[] tmp = (T[]) new Object[array.length + DEFAULT_SIZE];

        for (int i = 0; i < size(); i++) {

            tmp[i] = array[i];
        }
        array = tmp;
    }
    
}