/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fp7.ex1;

/**
 *
 * @author dmanu
 */
public class demo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        LinkedListRecursive<Integer> tmp = new LinkedListRecursive<>();
        
        tmp.add(1);
        tmp.add(2);
        tmp.add(5);
        tmp.add(10);
        tmp.add(8);
        
        System.out.println(tmp.toString());
    }
    
}
