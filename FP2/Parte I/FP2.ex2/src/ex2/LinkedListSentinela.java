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
public class LinkedListSentinela<T> {
    
    private Node<T> head;
    private Node<T> tail;
    private long size;
    
    public LinkedListSentinela() {
        this.head = new Node<>(null);
        this.tail = new Node<>(null);
        this.size = 0;
    }

    public long getSize() {
        return size;
    }
 
    
    public void add(T element) {
        
        Node<T> newNode = new Node<>(element);
        
        if (head == null){
             
            this.head = newNode;
            this.tail = newNode;
        }
        else{
            //newNode.setNext(this.head);
            //this.head = newNode;
            
            newNode.setNext(this.head.getNext());
            this.head.setNext(newNode);
            
        }
        this.size++;
        
    }
    
    public boolean remove(T element){
       
        Node<T> current = this.head.getNext();
        Node<T> previous = this.head;
        
        while(current.getElement() != null) {
            
            if(current.getElement().equals(element)) {
                
                previous.setNext(current.getNext());  
                this.size--;
                return true;
                
            }else{
                previous = current;
                current = current.getNext();
            }
            
        }
        return false;
    }
    
        
            
    public void printList(){
        Node<T> current = head.getNext();
        
        while(current != null){
            
            System.out.println(current.toString());
            current= current.getNext();
        }
        
        
        System.out.println("Last: " + tail.getPrevious());
        System.out.println("Nº elementos: " + this.size);
        
    }
    
   
}
