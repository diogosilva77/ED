package fp7.ex2;

import Interfaces.DoubleLinkedListADT;


/**
 *
 * @author dmanu
 */
public class DoubleLinkedListRecursive<T> implements DoubleLinkedListADT<T> {

    DoubleNode<T> head, tail;
    private long size;
    
    @Override
    public void add(T element) {
        
        DoubleNode<T> newNode = new DoubleNode<>(element);
        
        if (this.head == null){

            this.head = newNode;
            this.tail = newNode;
            
        }
        else{
            DoubleNode<T> olderTail = this.tail;
            
            this.tail = newNode;
            this.tail.setPrevious(olderTail);
            olderTail.setNext(this.tail);
        }
        size++;
    }
    
    @Override
    public String toString() {
        
        return printRecursiveFromHead(head);
    }
    
    public String toStringReverse() {
        
        return printRecursiveFromTail(tail);
    }
    
    private String printRecursiveFromHead(DoubleNode<T> current) {
        
        String result = "";
        
        //criterio de paragem
        if (current.getNext() == null) {
            
            result += current.toString();
        }
        //caso especifico
        else{
            result += current.toString() + printRecursiveFromHead(current.getNext());
        }
        return result;
    }
    
     private String printRecursiveFromTail(DoubleNode<T> current) {
        
        String result = "";
        
        //criterio de paragem
        if (current.getPrevious() == null) {
            
            result += current.toString();
        }
        //caso especifico
        else{
            result += current.toString() + printRecursiveFromTail(current.getPrevious());
        }
        return result;
    }
}
