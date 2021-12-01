package ex1;

/**
 *
 * @author dmanu
 */
public class LinkedList<T> {
    
    private LinkNode<T> head, tail;
    private long size;
    
    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    public boolean add(T element){
        if(head == null){
            
            LinkNode<T> current = new LinkNode<T>(element, null);
            this.head = current;
            this.tail = current;
            this.size++;
            return true;
            
        }else{
            
            LinkNode<T> current = this.tail;
            LinkNode<T> next = new LinkNode<>(element, null);
            current.setNext(next);
            this.tail = next;
            this.size++;
            return true;
        }    
    }
    
    public T remove(T element) throws LinkedListExceptions {
        
        if(this.head == null){
            throw new LinkedListExceptions(LinkedListExceptions.EMPTYLIST);
        }
        else{
            LinkNode<T> current = head;
            LinkNode<T> previous = null;

            boolean found = false;
            
            while(current != null && found == false){
                if(current.getElement().equals(element)){
                    found = true;
                    
                }else{
                    previous = current;
                    current = current.getNext();
                }
            }

            if(found == true){
                //Só existe um elemento na lista
                if(this.size == 1){
                    this.head = null;
                    this.tail = null;
                
                    /**
                     * Quando o elemento que queremos remover é o primeiro da lista:
                     * O head aponta para o seguinte
                     * O elemento a receber recebe null
                     */
                }else if(current.getElement().equals(head.getElement())){
                    LinkNode<T> currentHead = current;
                    head = head.getNext();
                    currentHead.setNext(null);
                    
                    /**
                     * Quando o elemento que queremos remover é o último da lista:
                     * O next recebe null
                     * O last aponta para o nó auxiliar chamado previous
                     */     
                }else if(current.getElement().equals(tail.getElement())){
                    previous.setNext(null);
                    tail = previous;
                    
                }else {
                    /**
                     * Quando o element que queremos remover se encontra "no meio" da lista:
                     * O previous recebe o next do atual
                     * E fazemos um set para null
                     */
                    previous.setNext(current.getNext());
                    current.setNext(null);
                }
                
                this.size--;
                return current.getElement();
                
            }else {
                throw new LinkedListExceptions(LinkedListExceptions.NOTFOUND);
            }
        }
    }
    
    private void info() {
        
        System.out.println("Head: " + this.head.getElement());
        System.out.println("Tail: " + this.tail.getElement());
        System.out.println("Nº de elementos: " + this.size);
    }
    
    public void printList(){
        LinkNode<T> current = head;
        
        while(current!=null){
            
            System.out.println(current.toString());
            current= current.getNext();
        }
        info();
    }
}
