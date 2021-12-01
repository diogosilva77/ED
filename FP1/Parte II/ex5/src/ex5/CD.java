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
public class CD extends Media{
    
    private String editora;

    public CD(String name) {
        super(name);
    }
    
    public CD(String editora, String name) {
        super(name);
        this.editora = editora;
    }

    public String getEditora() {
        return editora;
    }

    @Override
    public String toString() {
       
        String text = "";
        
        text += super.toString() + "Editora: " + getEditora()+ "\n";
        return text;
    }
    
    
}
