/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

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
        
       ArrayOrderedList<String> tmp = new ArrayOrderedList<>();
       
        try {
            tmp.add("O");
            tmp.add("B");
            tmp.add("D");
            tmp.add("V");
            tmp.add("W");
            tmp.add("E");
            //System.out.println(tmp.toString());
            //tmp.removeFirst();
            //tmp.removeLast();
            
            Iterator<String> itr = tmp.iterator();
            
            while (itr.hasNext()){
                System.out.println(itr.next());
            }
            
            tmp.add("Z");
            tmp.add("F");
            System.out.println(tmp.toString());
            //tmp.removeLast();
            
            Iterator<String> itr2 = tmp.iterator();
            
            while (itr2.hasNext()){
                System.out.println(itr2.next());
            }
            
        }
        catch(Exception ex){
            System.out.println("Erro: " + ex.getMessage());
        }
    }
    
}
