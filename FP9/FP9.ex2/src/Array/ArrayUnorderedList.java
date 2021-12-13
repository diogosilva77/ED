/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Array;

import Exceptions.EmptyCollectionException;
import Interfaces.UnorderedListADT;

/**
 *
 * @author dmanu
 */
public class ArrayUnorderedList<T> extends ArrayList<T> implements UnorderedListADT<T>{

    public ArrayUnorderedList() {
    }

    @Override
    public void addToFront(T element) {
        
        int index = 0;
        
        if (isEmpty()) {
            array[0] = element;
        }
       
        if (this.array.length == size()){
            expandList();
        }

        for (int i = 0; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[0] = element;
        
        size++;
        modCount++;
    }

    @Override
    public void addToRear(T element) {
        
        if (isEmpty()) {
            array[0] = element;
        }
        
        if (this.array.length == size()){
            expandList();
        }
        
        array[size] = element;
        
        size++;
        modCount++;
    }

    @Override
    public void addAfter(T element, T target) throws EmptyCollectionException {
        
        if (this.array.length == size()){
            expandList();
        }
        
        if (isEmpty()) {
            array[0] = element;
        }
        
        boolean found = false;
        int current = 0;
        
        while (current < size() && found == false) {
            
            if (array[current].equals(target)){
                 found = true;
            }
            else{
                current++;
            }
        }
        
        if (found == true){
            
            for (int i = size - 1; i > current; i--) {
                array[i + 1] = array[i];
            }
            array[current + 1] = element;
        }
        size++;
        modCount++;
    }
    
    private void expandList() {

        T[] tmp = (T[]) new Object[array.length + DEFAULT_SIZE];

        for (int i = 0; i < size(); i++) {

            tmp[i] = array[i];
        }
        array = tmp;
    }
}
