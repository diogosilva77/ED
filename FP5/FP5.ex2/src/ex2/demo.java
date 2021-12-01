/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2;

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
        
        DoubleLinkedOrderedList<Integer> list = new DoubleLinkedOrderedList<>();
        
        try{
            list.add(3);
            list.add(1);
            list.add(7);
            list.add(13);
            list.add(5);
            list.add(23);
            list.add(16);
            
            Iterator<Integer> itr = list.iterator();
            
            while (itr.hasNext()) {
                System.out.println(itr.next());
            }
            
            System.out.println("-----------------------");
            
            list.add(10);
            list.add(20);
            list.removeFirst();
            System.out.println(list.toString());
            
            Iterator<Integer> itr2 = list.iterator();
            
            while (itr2.hasNext()) {
                System.out.println(itr2.next());
            }
             
       }
        catch(Exception ex){
            System.out.println("Erro: " + ex.getMessage());
        }
        
    }  
}
