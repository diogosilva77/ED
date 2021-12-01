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
public class Ex2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String t1 = "ola";
        String t2 = "ola1";
        String t3 = "ola2";
        
        LinkedListSentinela<String> test = new LinkedListSentinela<String>();
        
        test.add(t1);
        test.add(t2);
        test.add(t3);
        
        //test.printList();
        
        //test.remove(t1);
        //test.remove(t2);
        
        test.printList();
    }
    
}
