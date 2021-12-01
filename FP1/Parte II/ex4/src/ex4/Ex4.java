/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author dmanu
 */
public class Ex4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        List<String> tmp = new ArrayList();
        
        tmp.add("Estg");
        tmp.add("Diogo");
        tmp.add("ED");
        tmp.add("Silva");
        
        //Classe Anonima
        Collections.sort(tmp, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        }
                
        );
        System.out.println(tmp);
    }
    
}
