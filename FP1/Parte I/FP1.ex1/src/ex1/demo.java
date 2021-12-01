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
    public static void main(String[] args) {
        
        TwoTypePair<String, String> pair1 = new TwoTypePair<String, String> ("Diogo", "Silva");
        TwoTypePair<String, String> pair2 = new TwoTypePair<String, String> ("ED", "Estg");
        
        pair1.setSecond("SILVA");
        pair2.setFirst("Estrutura de Dados");
        
        System.out.println(pair1.getSecond());
        System.out.println(pair2.getFirst());
        System.out.println(pair1.equals(pair2));
        System.out.println(pair1.toString());
    }
    
}
    
