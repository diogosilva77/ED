package Tree;

/**
 *
 * @author dmanu
 */
public class BinaryTreeNode<T> {
    
    protected T element;
    protected BinaryTreeNode<T> left, right;
    
    /**
     * Cria um novo nó na arvore com dados especificos
     * @param obj o elemento que vai fazer parte do novo nó da arvore
     */
    public BinaryTreeNode (T obj) {
        element = obj;
        left = null;
        right = null;
    }

    public T getElement() {
        return element;
    }

    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public BinaryTreeNode<T> getRight() {
        return right;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }
    
    /**
     * Retorna o numero de filhos não nulos neste nó.
     * Este metodo pode ser escrito com mais eficiência
     * @return o número inteiro de filhos não nulos deste nó
     */
    public int numChildren() {
        
        int children = 0;
        
        if (left != null){
            children = 1 + left.numChildren();
        }
        if (right != null){
            children = children + 1 + right.numChildren();
        }
        return children;
    }
}
