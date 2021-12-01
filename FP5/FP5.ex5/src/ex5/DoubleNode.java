
package ex5;

/**
 *
 * @author dmanu
 */
public class DoubleNode<T> {
    
    private DoubleNode<T> next;
    private T element;
    private DoubleNode<T> previous;

    public DoubleNode() {
        this.next = null;
        this.element = null;
        this.previous = null;
    }

    
    public DoubleNode(T elem) {
        this.next = null;
        this.element = elem;
        this.previous = null;
    }
    
    /**
     * Retorna o nó seguinte a este
     * @return o nó seguinte a este
     */
    public DoubleNode<T> getNext(){
        return next;
    }

    public DoubleNode<T> getPrevious() {
        return previous;
    }

    public void setNext(DoubleNode<T> next) {
        this.next = next;
    }

    /**
     * Define o nó que precede este
     * @param dnode nó a ser definido como precedente
     */
    public void setPrevious (DoubleNode<T> dnode){
        previous = dnode;
    }
    
    /**
     * Retorna o elemento armazenado no nó
     * @return o elemento armazenado no nó
     */
    public T getElement() {
        return element;
    }
    
    /**
     * Define o elemento armazenado neste nó
     * @param elem o elemento armazenado neste nó
     */
    public void setElement(T elem) {
        element = elem;
    }
}
