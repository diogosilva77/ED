package ex1;

import Interfaces.EmptyCollectionException;

/**
 *
 * @author dmanu
 */
public class demo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws EmptyCollectionException {
   
        ArrayStack<Integer> tmp = new ArrayStack<>();
        
        try{
            tmp.push(1);
            tmp.push(2);
            tmp.push(3);
            tmp.push(4);
            tmp.push(5);

            tmp.smack();
            tmp.smack();
            tmp.smack();
            System.out.println(tmp.peek());

            System.out.println(tmp.toString());
            System.out.println("Size: " + tmp.size());
        }
        catch(Exception ex){
            System.out.println("Exception: " + ex.getMessage());
        }
        
    }
    
}
