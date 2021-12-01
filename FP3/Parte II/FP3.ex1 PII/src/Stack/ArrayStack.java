/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stack;

import Stack.EmptyCollectionException;
import Stack.StackADT;

/**
 *
 * @author dmanu
 */
public class ArrayStack<T> implements StackADT<T>{
    
    private final int DEFAULT_CAPACITY = 50;
    private int top;
    private T[] stack;
    
    private void expandCapacity() {
    
        T[] tmp = (T[]) (new Object[stack.length + DEFAULT_CAPACITY]);

        for (int i = 0; i < stack.length; i++) {
            tmp[i] = stack[i];
        }

        stack = tmp;
    }

    @Override
    public void push(T element) {
        
        if(size() == stack.length)
            expandCapacity();
        
        stack[top] = element;
        top++;
    }

    @Override
    public T pop() throws EmptyCollectionException {
        
        if(isEmpty()) {
            throw new EmptyCollectionException(EmptyCollectionException.EMPTYCOLLECTION);
        }
        else{
            top--;
            T result = stack[top];
            stack[top] = null;
            
            return result;
        }

    }

    @Override
    public T peek() throws EmptyCollectionException {
        
        if(isEmpty()){
            throw new EmptyCollectionException(EmptyCollectionException.EMPTYCOLLECTION); 
        }
        else{
           return stack[top-1]; 
        }
    }

    @Override
    public boolean isEmpty() {
        
        return (this.top == 0);
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
    
}
