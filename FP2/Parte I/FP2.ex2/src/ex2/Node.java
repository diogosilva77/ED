/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2;

/**
 *
 * @author dmanu
 */
public class Node<T> {
    
    private T element;
    private Node<T> next;
    private Node<T> previous;
    
    public Node(T element){
        
        this.element = element;
        this.next = next;
        this.previous = previous;
    }
    
    public Node<T> getNext() {
        return next;
    }
    
    public void setNext(Node<T> next) {
        
        this.next = next;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }
   
    public T getElement() {
        
        return element;
    }
    
    public void setElement(T data) {
        this.element = element;
    }

    @Override
    public String toString() {
        return "LinkNode {" + "element = " + element + '}';
    }
    
}
