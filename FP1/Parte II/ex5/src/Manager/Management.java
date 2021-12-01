/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import ex5.Media;
import java.util.ArrayList;

/**
 *
 * @author dmanu
 */
public class Management<T extends Media>{
    
    private ArrayList<T> list = new ArrayList<>();

    public Management() {
    }
    
    public void addList(T media){
        list.add(media);
    }
    
    public T getFromList(int position) {
        return list.get(position);
    }
    
    public void getList(){
        for (T tmp : list)
            if (tmp != null){
                System.out.println(tmp.toString());
            }
    }
}
