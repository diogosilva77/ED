package Queue;

/**
 *
 * @author dmanu
 */
public class LinkNode<T> {
    
    private T element;
    private LinkNode<T> next;
    
    public LinkNode() {
        next = null;
        element = null;
    }
    
    public LinkNode(T element, LinkNode<T> next){
        
        this.element = element;
        this.next = next;
    }
    
    public LinkNode<T> getNext() {
        return next;
    }
    
    public void setNext(LinkNode<T> next) {
        
        this.next = next;
    }
    
    public T getElement() {
        
        return element;
    }
    
    public void setElement(T data) {
        this.element = element;
    }

    @Override
    public String toString() {
        return "LinkNode {" + "element = " + element + '}';
    }
    
}
