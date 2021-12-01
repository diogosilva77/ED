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
public class demoPair {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Pair<Integer> tmp = new Pair<>();
        
        tmp.setFirst(10);
        tmp.setSecond(15);
        
        System.out.println(tmp);
        System.out.println(tmp.getFirst().equals(tmp.getSecond()));
    }
    
}
