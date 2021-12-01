/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

/**
 *
 * @author dmanu
 */
public class demo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws EmptyCollectionException {
        
        ArrayStack <Integer> tmp = new ArrayStack<>();
        
        
        tmp.push(10);
        tmp.push(3);
        tmp.push(22);
        
        System.out.println(tmp.toString());
        System.out.println(tmp.peek());
        
        tmp.pop();
        
        System.out.println(tmp.toString());
        System.out.println(tmp.size());
        System.out.println(tmp.isEmpty());
    }
    
}
