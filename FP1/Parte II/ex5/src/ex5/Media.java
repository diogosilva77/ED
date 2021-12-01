
package ex5;

/**
 *
 * @author dmanu
 */
public abstract class Media {
    
    /**
     * atributo name
     */
    private String name;
    
    /**
     * metodo construtor
    */
    public Media() {
    }
    
    /**
     * Metodo construtor
     * @param name 
     */
    public Media(String name) {
        this.name = name;
    }
    
    
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        
        String text = "";
        
        text += "Nome: " + this.getName()+ "\n";
        return text;
    }
    
    
}
