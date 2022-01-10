/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stack;

import Exceptions.EmptyCollectionException;
import Interfaces.StackADT;
import Queue.LinkNode;

/**
 *
 * @author dmanu
 */
public class LinkedStack<T> implements StackADT<T> {
    
    private int size;
    private LinkNode<T> top;

    public LinkedStack() {
        this.size = 0;
        this.top = null;
    }
   
    @Override
    public void push(T element) {
        
        if (top == null){
            top = new LinkNode(element, null);
        }
        else{
            LinkNode<T> tmp = new LinkNode<T>(element, top);
            
            top = tmp;
        }
        size++;
    }

    @Override
    public T pop() throws EmptyCollectionException {
        
        if(isEmpty()){
            throw new EmptyCollectionException(EmptyCollectionException.EMPTYCOLLECTION);
        }
        else{
            LinkNode<T> tmp = this.top;
            this.top = top.getNext();
            
            this.size--;
            
            return tmp.getElement();
        }
 
    }

    @Override
    public T peek() throws EmptyCollectionException {
        
        if(isEmpty()){
        throw new EmptyCollectionException(EmptyCollectionException.EMPTYCOLLECTION);
        }
        else{
            return this.top.getElement();
        }
         
    }

    @Override
    public boolean isEmpty() {
         return(this.size == 0);
    }

    @Override
    public int size() {
        
        return size;
    }

    @Override
    public String toString() {
        
        String text = "";

        LinkNode<T> tmp = this.top;

        while (tmp != null) {
            text += "Posição: " + tmp + " -------> " + "Conteúdo: " + tmp.getElement() + "\n";
            tmp = tmp.getNext();
        }

        return text;
        
    }

}
