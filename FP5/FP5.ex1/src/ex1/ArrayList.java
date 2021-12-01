
package ex1;

import Interfaces.EmptyCollectionException;
import Interfaces.ListADT;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author dmanu
 */
public abstract class ArrayList<T> implements ListADT<T> {
    
    protected static final int DEFAULT_SIZE = 2;
    protected T[] array;
    protected int size;
    protected int modCount;
    

    public ArrayList() {
        this.array = (T[]) new Object[DEFAULT_SIZE];
        this.size = 0;
        this.modCount = 0;
    }
    

    @Override
    public T removeFirst() throws EmptyCollectionException {
        
        if (isEmpty() == true){
            throw new EmptyCollectionException(EmptyCollectionException.EMPTYCOLLECTION);
        }
        
        T tmp = array[0];
        size--;
        //shift
        for (int i = 0; i < size(); i++){
            
            array[i] = array[i + 1];
        }
        modCount++;
        return tmp;
    }

    @Override
    public T removeLast() throws EmptyCollectionException {
        
        if (isEmpty()){
            throw new EmptyCollectionException(EmptyCollectionException.EMPTYCOLLECTION);
        }
        
        T tmp = array[size - 1];
        array[size - 1] = null;
        size--;
       
       modCount++;
       return tmp;
    }

    @Override
    public T remove(T element) throws EmptyCollectionException {
        
        int position = search(element);
        
        if (isEmpty()){
            throw new EmptyCollectionException(EmptyCollectionException.EMPTYCOLLECTION);
        }
        
        if (position == -1){
            throw new EmptyCollectionException("Elemento não encontrado");
        }
        else if(position == 0){
            return removeFirst();
        }
        else if(position == size() - 1){
            return removeLast();
        }
        
        T tmp = array[position];
        size--;
        
        for (int i = 0; i < size(); i++){
            
            array[i] = array[i + 1];
        }
        modCount++;
        return tmp;
    }

    @Override
    public T first() throws EmptyCollectionException {
        
        if(isEmpty()){
            throw new EmptyCollectionException(EmptyCollectionException.EMPTYCOLLECTION);
        }
        return array[0];
    }

    @Override
    public T last() throws EmptyCollectionException{
        
        if (isEmpty()){
            throw new EmptyCollectionException(EmptyCollectionException.EMPTYCOLLECTION);
        }
        else{
            return array[size - 1];
        }
   
    }

    @Override
    public boolean contains(T target) {
        
        return (search(target) != -1);
    }

    @Override
    public boolean isEmpty() {
        
        return (size() == 0);
    }

    @Override
    public int size() {
        
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        
        ArrayIterator itr = new ArrayIterator();
        
        return itr;
    }
    
    private int search(T element){
        
        int position = -1;
        
        for (int i = 0; i < size(); i++){
            if (this.array[i].equals(element)){
                position = i;
            }
           
        }
        return position;
    }
    
    public String toString() {
        String result = "";

        for (int i = 0; i < size(); i++) {
            result += "Posição: " + i + "->" + array[i].toString() + "\n";
        }

        return result;
    }
    
     private class ArrayIterator<T> implements Iterator<T> {
        
        private int current;
        private int expectedModCount;
        private boolean okToRemove;
        
        public ArrayIterator() {
            this.current = 0;
            this.expectedModCount = modCount;
            this.okToRemove = false;
        }

        @Override
        public boolean hasNext() {
            
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException("Coleção alterada");
            }
            this.okToRemove = false;

            return (current < size);
        }

        @Override
        public T next() {
            
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T tmp = (T) array[current];
            current++;
            okToRemove = true;
            
            return tmp;
        }
        
        public void remove() throws UnsupportedOperationException
        {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            
            if (!okToRemove) {
                throw new RuntimeException("Não é possível remover");
            }
            
            try{
                ArrayList.this.remove(array[current]);
            }
            catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            this.okToRemove = false;
            this.expectedModCount++;
        }
    }
}