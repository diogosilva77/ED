/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author dmanu
 */
public class Ex4 {

    /**
     * @param args the command line arguments
     */
    public static void printCollection(Collection<?> c) {
        for (Object e: c) {
            System.out.println(e);
        }
    }
    
    public static void main (String[] args) {
        
        List<?> c = new ArrayList<String>();
        
        ((List<String>) c).add("hello world");
        ((List<Object>) c).add(new Object());
        ((List<Integer>) c).add(3);
        printCollection(c);
    }
    
}
