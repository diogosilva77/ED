
package ex1;

/**
 *
 * @author dmanu
 */
public class demo {

    public String getGreeting() {
        return "Hello world.";
    }
    
    public static void main(String[] args) {
        
        LinkedList<String> test = new LinkedList<String>();
        
        //String trash = "ola";
        //String trash2 = "adeus";
        //String trash3 = "ate ja";

        test.add("ola");
        test.add("adeus");
        test.add("ate ja");
        test.add("estg");
        test.add("2021");

        test.printList();
        try {
            System.out.println("Removido: "+ test.remove("ola"));
        } catch (Exception ex) {
            System.out.println("Erro: "+ ex.getMessage());
        }
        test.printList();
        
        try {
            System.out.println("Removido: "+test.remove("adeus"));
        } catch (Exception ex) {
            System.out.println("Erro: "+ ex.getMessage());
        }
        test.printList();
        
    }
    
}
