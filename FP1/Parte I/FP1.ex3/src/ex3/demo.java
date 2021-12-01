/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex3;

/**
 *
 * @author dmanu
 */
public class demo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        UnorderedPair<String> p1 = new UnorderedPair<String> ("peanuts", "beer");
        UnorderedPair<String> p2 = new UnorderedPair<String>("beer", "peanuts");
        
        System.out.println(p1.getFirst() + " " +  p1.getSecond());
        
        if (p1.equals(p2)) {
            System.out.println(p1.getFirst() + " and " + p1.getSecond() + " is the same as");
            System.out.println(p2.getFirst() + " and " + p2.getSecond());
        }
    }
    
}
