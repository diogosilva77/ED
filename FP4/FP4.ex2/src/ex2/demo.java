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
public class demo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws EmptyCollectionException {
        
        CircularArrayQueue<Integer> tmp = new CircularArrayQueue<>();
        
       
        try{
            tmp.enqueue(1);
            tmp.enqueue(2);
            tmp.enqueue(3);
            tmp.enqueue(8);
            tmp.dequeue();
            tmp.enqueue(5);
            tmp.dequeue();
            tmp.enqueue(7);
            //tmp.enqueue(11);
           
            System.out.println("First: " + tmp.first());
            System.out.println(tmp.toString());
            System.out.println("Front: " + tmp.getFront());
            System.out.println("Rear: " + tmp.getRear());
        }catch(Exception ex){
            System.out.println("Erro: " + ex.getMessage());
        }
    }
    
}
