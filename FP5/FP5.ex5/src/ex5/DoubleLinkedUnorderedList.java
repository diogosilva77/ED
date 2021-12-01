/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex5;

import Interfaces.EmptyCollectionException;
import Interfaces.UnorderedListADT;

/**
 *
 * @author dmanu
 */
public class DoubleLinkedUnorderedList<T> extends DoubleLinkedList<T> implements UnorderedListADT<T>{
    

    @Override
    public void addToFront(T element) {
        
        DoubleNode<T> newNode = new DoubleNode<>(element);
        
        if (isEmpty()) {
            
             this.head = newNode;
             this.tail = this.head;
        }
        else{
            DoubleNode<T> olderHead = this.head;
            
            this.head = newNode;
            this.head.setNext(olderHead);
            olderHead.setPrevious(this.head);
        }
        size++;
        modCount++;
   
    }

    @Override
    public void addToRear(T element) {
        
        DoubleNode<T> newNode = new DoubleNode<>(element);
        
        if (isEmpty()) {
            addToFront(element);
        }
        else{
            DoubleNode<T> olderTail = this.tail;
            
            this.tail = newNode;
            this.tail.setPrevious(olderTail);
            olderTail.setNext(this.tail);
        }
        size++;
        modCount++;
    }

    @Override
    public void addAfter(T element, T target) throws EmptyCollectionException {
        
        DoubleNode<T> current = this.head;
        
        if (isEmpty()) {
            throw new EmptyCollectionException("Coleção vazia");
        }
        
        boolean found = false;
        
        while (current != null && found == false) {
            
            if (current.getElement().equals(target)) {
                found = true;
            }
            else{
                current = current.getNext();
            }
        }
        
        if (found == true) {
            
            DoubleNode<T> newNode = new DoubleNode<>(element);
            DoubleNode<T> previous = current.getPrevious();
            
            previous.setNext(newNode);
            current.setPrevious(newNode);
            newNode.setNext(current);
            newNode.setPrevious(previous);
        }
        else{
            addToRear(element);
        }
    }
    
    public String invert(){
        String text = "";
        
        DoubleNode<T> tmp = this.tail;
        
        while (tmp != null){
            text += "Conteúdo: " + tmp.getElement() + "\n";
            tmp = tmp.getPrevious();
        }
        return text;
    }
    
}
