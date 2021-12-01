
package ex4;

/**
 *
 * @author dmanu
 */
public class CircularArrayQueue<T> implements QueueADT<T> {
    
    private T[] queue;
    private int size;
    private int front;
    private int rear;
    private final int DEFAULT_CAPACITY = 10;

    public CircularArrayQueue() {
        this.queue = (T[]) new Object[DEFAULT_CAPACITY];
        this.size = 0;
        this.front = 0;
        this.rear = 0;
    }
    

    @Override
    public void enqueue(T element) {
        
        if (size == this.queue.length) {
                
            expandQueue();
        }
        
        queue[rear] = element;
        rear = (rear+1) % queue.length;
        
        size++;
    }

    @Override
    public T dequeue() throws EmptyCollectionException {
        
        if(isEmpty()){
            throw new EmptyCollectionException(EmptyCollectionException.EMPTYCOLLECTION);
        }
        
        T tmp = queue[front];
        front = (front + 1) % queue.length;
        
        size--;
        
        return tmp;
    }

    @Override
    public T first() throws EmptyCollectionException {
        
        if (isEmpty()){
            throw new EmptyCollectionException(EmptyCollectionException.EMPTYCOLLECTION);
        }
        else{
            return queue[front];
        }
    }
    
    private void expandQueue() {
        
        T[] tmp = (T[]) new Object[queue.length + DEFAULT_CAPACITY];
        int tmpFront = this.front;
        
        for (int i = 0; i < queue.length; i++){
            
            tmp[i] = queue[tmpFront];
            tmpFront = (tmpFront+1) % queue.length;
        }
        this.front = 0;
        rear = size();
        
        queue = tmp;
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

        int tmp = this.front;

        while (tmp != rear) {
            text += "\n" + queue[tmp].toString();
            tmp = (tmp + 1) % queue.length;
        }

        return text;
        
    }

    public int getFront() {
        return front;
    }

    public int getRear() {
        return rear;
    }
    
    
    
}
