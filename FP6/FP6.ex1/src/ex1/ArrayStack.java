/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import Interfaces.EmptyCollectionException;
import Interfaces.SmackStackADT;

/**
 *
 * @author dmanu
 */
public class ArrayStack<T> implements SmackStackADT<T> {
    
    private final int DEFAULT_CAPACITY = 100; 

    private int top; 

    private T[] stack;
    
    public ArrayStack()
    {
    top = 0;
    stack = (T[])(new Object[DEFAULT_CAPACITY]);
    }
    
    public ArrayStack (int initialCapacity)
    {
    top = 0;
    stack = (T[])(new Object[initialCapacity]);
    }
    
    private void expandCapacity() {
    
        T[] tmp = (T[]) (new Object[stack.length + DEFAULT_CAPACITY]);

        for (int i = 0; i < stack.length; i++) {
            tmp[i] = stack[i];
        }

        stack = tmp;
    }

    @Override
    public void push(T element) {
        
        if (size() == stack.length)
            expandCapacity();
        stack[top] = element;
        top++;
        
    }

    @Override
    public T pop() throws EmptyCollectionException {
       
        if (isEmpty()){
            throw new EmptyCollectionException(EmptyCollectionException.EMPTYCOLLECTION);
        }
        
        top--;
        T result = stack[top];
        stack[top] = null;
        
        return result; 
    }

    @Override
    public T peek() throws EmptyCollectionException {
       
        if (isEmpty()) {
            throw new EmptyCollectionException(EmptyCollectionException.EMPTYCOLLECTION);
        }
        
        return stack[top-1]; 
    }

    
    @Override
    public boolean isEmpty() {
        
        return (this.top == 0 );
    }

    @Override
    public int size() {
        
        return top;
    }

    @Override
    public String toString() {
        
        String text = "";

        int lastPosition = size() - 1;

        while (lastPosition != -1) {
            text += "Posição: " + lastPosition + " -------> " + "Conteúdo: " + stack[lastPosition] + "\n";
            lastPosition--;
        }

        return text;
    }
    
    public T smack() throws EmptyCollectionException {
        
        if (isEmpty()) {
            throw new EmptyCollectionException(EmptyCollectionException.EMPTYCOLLECTION);
        }
        
        T result = stack[0];
        stack[0] = null;
        top--;
        
        for (int i = 0; i < size(); i++) {
            stack[i] = stack[i + 1];
        }
        
        return result;
    }
}