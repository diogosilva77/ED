package ex1;

import Queue.EmptyCollectionException;
import Queue.LinkNode;
import Queue.QueueADT;

/**
 *
 * @author dmanu
 */
public class LinkedQueue<T> implements QueueADT<T> {
    
    private int size;
    private LinkNode<T> front;
    private LinkNode<T> rear;

    public LinkedQueue() {
        this.size = 0;
        this.front = null;
        this.rear = null;
    }
    

    @Override
    public void enqueue(T element) {
        
        if (size == 0){
            front = new LinkNode<>(element, null);
            rear = front;
        }
        else{
           LinkNode<T> tmp = new LinkNode<>(element, null);
           rear.setNext(tmp);
           rear = rear.getNext();
        }
        size++;
    }

    @Override
    public T dequeue() throws EmptyCollectionException {
        
        T tmp = null;
        
        if(isEmpty()){
            throw new EmptyCollectionException(EmptyCollectionException.EMPTYCOLLECTION);
        }
        else if (size == 1){
            tmp = front.getElement();
            this.front = null;
            this.rear = null;
            size--;
        }
        else{
            tmp = front.getElement();
            this.front = front.getNext();
            size--;
        }
        return tmp;
    }

    @Override
    public T first() throws EmptyCollectionException {
        
        if(isEmpty()){
            throw new EmptyCollectionException(EmptyCollectionException.EMPTYCOLLECTION);
        }
        else{
            return this.front.getElement();
        }
    }

    @Override
    public boolean isEmpty() {
        
        return (this.size == 0);
    }

    @Override
    public int size() {
        
        return size;
    }
    
    @Override
    public String toString() {
        
        String text = "";

        LinkNode<T> tmp = this.front;

        while (tmp != null) {
            text += tmp.toString();
            tmp = tmp.getNext();
        }

        return text;
        
    }
}
