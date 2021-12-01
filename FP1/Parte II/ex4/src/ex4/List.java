
package ex4;

import java.util.ArrayList;

/**
 *
 * @author dmanu
 */
public class List <T>{
    
    private ArrayList<T> lista = new ArrayList<T>();

    public List() {
    }
    
    public void addLista(T text) {
        lista.add(text);
    }
    
    public void printLista(){
        System.out.println("Index: \n" + lista);
    }
}
