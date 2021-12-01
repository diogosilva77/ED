
package ex4;

/**
 *
 * @author dmanu
 */
public class Cifra {
    
    CircularArrayQueue<Integer> queue = new CircularArrayQueue<>();
    
    public void addKeys (String key) throws EmptyCollectionException{
        
        String[] numbers = key.split(" ");
        
        for (int i = 0; i < numbers.length; i++){
            try{
                int result = Integer.parseInt(numbers[i]);
                queue.enqueue(result);
            }
            catch(Exception ex){
                System.out.println("Erro: " + ex.getMessage());
            }
    }
    }
}
