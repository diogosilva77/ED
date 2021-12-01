package fp7.ex1;

import Interfaces.LinkedListADT;

/**
 *
 * @author dmanu
 */
public class LinkedListRecursive<T> implements LinkedListADT<T> {

    LinkNode<T> head, tail;
    private long size;
    
    @Override
    public void add(T element) {
        
        if (this.head == null){
            
            LinkNode<T> current = new LinkNode<T>(element, null);
            
            this.head = current;
            this.tail = current;
            
            size++;
        }
        else{
            LinkNode<T> olderTail = this.tail;
            LinkNode<T> next = new LinkNode<>(element, null);
            
            olderTail.setNext(next);
            this.tail = next;
            
            size++;
        }
        
    }
    
    @Override
    public String toString() {
        
        return printRecursive(head);
    }
    
    private String printRecursive(LinkNode<T> current) {
        
        String result = "";
        
        //criterio de paragem
        if (current.getNext() == null) {
            
            result += current.toString();
        }
        //caso especifico
        else{
            result += current.toString() + printRecursive(current.getNext());
        }
        return result;
    }
}
