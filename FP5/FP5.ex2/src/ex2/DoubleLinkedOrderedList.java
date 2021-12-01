
package ex2;

import Interfaces.EmptyCollectionException;
import Interfaces.OrderedListADT;

/**
 *
 * @author dmanu
 */
public class DoubleLinkedOrderedList<T> extends DoubleLinkedList<T> implements OrderedListADT<T> {

    public DoubleLinkedOrderedList() {
    }
    
    @Override
    public void add(T element) throws EmptyCollectionException {
        
        if(element instanceof Comparable){
            
            DoubleNode<T> current = this.head;
            DoubleNode<T> newNode = new DoubleNode<>(element);
            
            if (isEmpty()){
                
                this.head = newNode;
                this.tail = this.head;
            }
            else{
                boolean found = false;
                
                while (current != null && found == false) {
                    
                    Comparable<T> tmp = (Comparable<T>) current.getElement();
                    
                    if (tmp.compareTo(element) > 0) { //retorna 1 se for maior que o elemento, -1 se for menor, 0 se for igual
                        
                        found = true;
                    }
                    else{
                        current = current.getNext();
                    }
                }
                if (found == true) {
                    
                    if (current == this.head) {
                        
                        DoubleNode<T> olderHead = this.head;
                        this.head = newNode;
                        this.head.setNext(olderHead);
                        olderHead.setPrevious(this.head);
                    }
                    else{
                        DoubleNode<T> previous = current.getPrevious();
                        
                        previous.setNext(newNode);
                        current.setPrevious(newNode);
                        
                        newNode.setPrevious(previous);
                        newNode.setNext(current);   
                    }
                    
                }else{
                    DoubleNode<T> olderTail = this.tail;
                    
                    this.tail = newNode;
                    this.tail.setPrevious(olderTail);
                    olderTail.setNext(this.tail);
                }
            }
            size++;
            modCount++;
        }
        else{
            throw new EmptyCollectionException("Não é instância de Comparable");
        }
    }
    
}
