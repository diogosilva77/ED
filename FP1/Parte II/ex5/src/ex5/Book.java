/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex5;

/**
 *
 * @author dmanu
 */
public class Book extends Media{
    
    private String autor;

    public Book(String autor, String name) {
        super(name);
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }

    @Override
    public String toString() {
        
        String text = "";
        
        text += super.toString() + "Autor: " + getAutor() + "\n";
        return text;
    }
    
    
    
}
