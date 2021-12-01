/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2;

/**
 *
 * @author dmanu
 */
public class demo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws EmptyCollectionException {
        
        LinkedStack<Integer> tmp1 = new LinkedStack<>();
        
        tmp1.push(1);
        tmp1.push(2);
        tmp1.push(3);
        tmp1.push(4);
        tmp1.push(5);
        
        System.out.println(tmp1.toString());       
        System.out.println("Top: " + tmp1.peek());
        System.out.println();
        tmp1.pop();
        
        System.out.println(tmp1.toString()); 
        System.out.println("Tamanho: " + tmp1.size());
    }
    
}
