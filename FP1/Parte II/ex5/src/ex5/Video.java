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
public class Video extends Media{
    
    private int duracao;

    public Video(int duracao, String name) {
        super(name);
        this.duracao = duracao;
    }

    public int getDuraçao() {
        return duracao;
    }

    @Override
    public String toString() {
        
        String text = "";
        
        text += super.toString() + "Duracao: " + getDuraçao()+ "\n";
        return text;
    }

    

    
    
}
