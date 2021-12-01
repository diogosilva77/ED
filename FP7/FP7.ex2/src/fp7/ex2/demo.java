/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fp7.ex2;

/**
 *
 * @author dmanu
 */
public class demo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        DoubleLinkedListRecursive<Integer> tmp = new DoubleLinkedListRecursive<>();
        
        tmp.add(1);
        tmp.add(2);
        tmp.add(3);
        
        System.out.println(tmp.toString());
        System.out.println(tmp.toStringReverse());
    }
    
}
