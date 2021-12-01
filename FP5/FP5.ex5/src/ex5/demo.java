/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex5;

import Interfaces.EmptyCollectionException;
import java.util.Iterator;

/**
 *
 * @author dmanu
 */
public class demo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws EmptyCollectionException {
        
        DoubleLinkedUnorderedList<Integer> list = new DoubleLinkedUnorderedList<>();
        
        list.addToFront(3);
        list.addToFront(5);
        list.addToRear(10);
        list.addToRear(8);
        list.addAfter(20, 10);
        System.out.println(list.toString()); 
        
        Iterator<Integer> itr = list.iterator();
        
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        
        list.addToFront(44);
        list.remove(8);
        System.out.println(list.toString());
        System.out.println("--------------------");
        System.out.println(list.invert());
        
    }
    
}
