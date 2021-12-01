/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex4;

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
        
        ArrayUnorderedList<Integer> tmp = new ArrayUnorderedList<>();
        
        tmp.addToFront(1);
        tmp.addToRear(3);
        tmp.addToFront(2);
        tmp.addToRear(33);
        tmp.addAfter(7, 3);
        tmp.addAfter(15, 1);
        System.out.println(tmp.toString());
        
        Iterator<Integer> itr = tmp.iterator();
        
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        
        tmp.addAfter(66, 2);
        
        System.out.println(tmp.toString());
        
         Iterator<Integer> itr2 = tmp.iterator();
        
        while (itr2.hasNext()) {
            System.out.println(itr2.next());
        }
    }
    
}
