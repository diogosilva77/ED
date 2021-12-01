
package ex2;

import Interfaces.EmptyCollectionException;
import Interfaces.ListADT;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author dmanu
 */
public class DoubleLinkedList<T> implements ListADT<T>{
    
    protected DoubleNode<T> head;
    protected DoubleNode<T> tail;
    protected int size;
    protected int modCount;

    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
        this.modCount = 0;
    }

    @Override
    public T removeFirst() throws EmptyCollectionException {
        
        if (isEmpty()){
            throw new EmptyCollectionException(EmptyCollectionException.EMPTYCOLLECTION);
        }
         
        DoubleNode<T> tmp = head;
        
        if (size() == 1) {
            this.head = null;
            this.tail = null;
            
        }else{
            this.head = this.head.getNext();
            this.head.setPrevious(null);
        }
        size--;
        modCount++;
        return tmp.getElement();
    }

    @Override
    public T removeLast() throws EmptyCollectionException {
        
        if (isEmpty()){
            throw new EmptyCollectionException(EmptyCollectionException.EMPTYCOLLECTION);
        }
        
        DoubleNode<T> tmp = tail;
        
        if (size() == 1) {
            this.head = null;
            this.tail = null;
        }
        else{
            this.tail = this.tail.getPrevious();
            this.tail.setNext(null);
        }
        size--;
        modCount++;
        return tmp.getElement();
    }

    @Override
    public T remove(T element) throws EmptyCollectionException {
            
        if (isEmpty()){
            throw new EmptyCollectionException(EmptyCollectionException.EMPTYCOLLECTION);
        }
        
        DoubleNode<T> current = search(element);
        
        if (current == this.head){
            return removeFirst();
        }
        else if (current == this.tail){
            return removeLast();
        }
        else{
            DoubleNode<T> previous = current.getPrevious();
            DoubleNode<T> next = current.getNext();
            
            previous.setNext(current.getNext());
            next.setPrevious(current.getPrevious());
        }
        
        size--;
        modCount++;
        return current.getElement();
    }

    @Override
    public T first() throws EmptyCollectionException {
        
        if (isEmpty()){
            throw new EmptyCollectionException(EmptyCollectionException.EMPTYCOLLECTION);
        }
        else{
            return head.getElement();
        }
    }

    @Override
    public T last() throws EmptyCollectionException {
        
        if (isEmpty()){
            throw new EmptyCollectionException(EmptyCollectionException.EMPTYCOLLECTION);
        }
        else{
            return tail.getElement();
        }
    }

    @Override
    public boolean contains(T target) throws EmptyCollectionException{
        
        return (search(target) != null);
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
        
         DoubleLinkedListIterator itr = new DoubleLinkedListIterator();
        
        return itr;
    }
 
    private DoubleNode<T> search(T element) throws EmptyCollectionException {
        
        DoubleNode<T> current = this.head;
        
        if(isEmpty()) {
            throw new EmptyCollectionException(EmptyCollectionException.EMPTYCOLLECTION);
        }
        
        while (current != null){
            
            if (current.getElement().equals(element)){
                return current;
            }
            else{
                current = current.getNext();
            }        
        }
        return null;
    }
    
    public String toString(){
        String text = "";
        
        DoubleNode<T> tmp = this.head;
        
        while (tmp != null){
            text += "Conteúdo: " + tmp.getElement() + "\n";
            tmp = tmp.getNext();
        }
        return text;
    }
    
    private class DoubleLinkedListIterator implements Iterator<T> {
        
        private DoubleNode<T> current;
        private int expectedModCount;
        private boolean okToRemove;

        public DoubleLinkedListIterator() {
            this.current = (DoubleNode<T>) head;
            this.expectedModCount = modCount;
            this.okToRemove = false;
        }
        
        @Override
        public boolean hasNext() {
            
             if (expectedModCount != modCount) {
                throw new ConcurrentModificationException("Coleção alterada");
            }
            this.okToRemove = false;

            return (current != null);
        }

        @Override
        public T next() {
            
            if (!hasNext()) {
                throw new NoSuchElementException();         
            }
            T tmp = current.getElement();
            current = current.getNext();
            
            return tmp;
        }
        
        public void remove() throws UnsupportedOperationException {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            
            if (!okToRemove) {
                throw new RuntimeException("Não é possível remover");
            }
            
            try{
               
                DoubleLinkedList.this.remove((T) current.getElement());
            }
            catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            this.okToRemove = false;
            this.expectedModCount++;
        }
    }
}