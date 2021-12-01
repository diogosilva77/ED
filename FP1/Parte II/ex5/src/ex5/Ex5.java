/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex5;

import Manager.Management;

/**
 *
 * @author dmanu
 */
public class Ex5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Book b1 = new Book("Pessoa 1", "Book1");
        Book b2 = new Book("Pessoa 2", "Book2");
        
        CD cd1 = new CD("editora 1", "CD1");
        CD cd2 = new CD("editora 2", "CD2");
        
        Video v1 = new Video(560, "Video1");
        Video v2 = new Video(1560, "Video2");
        
        Management list = new Management();
        
        list.addList(b1);
        list.addList(b2);
        list.addList(cd1);
        list.addList(cd2);
        list.addList(v1);
        list.addList(v2);
        
        Management<Book> m1 = new Management<>();
        System.out.println(b1);
        
        Management<CD> m2 = new Management<>();
        System.out.println(cd1);
    }
    
}
