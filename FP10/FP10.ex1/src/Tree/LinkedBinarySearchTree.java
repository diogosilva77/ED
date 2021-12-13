package Tree;

import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import Interfaces.BinarySearchTreeADT;

/**
 *
 * @author dmanu
 */
public class LinkedBinarySearchTree<T> extends LinkedBinaryTree<T> implements BinarySearchTreeADT<T> {

    public LinkedBinarySearchTree() {
        super();
    }

    public LinkedBinarySearchTree(T element) {
        super(element);
    }
    
    /**
     * Adiciona um, objeto especifico a arvore de pesquisa binaria,
     * na posição apropriada de acordo com o seu valor-chave.
     * Elementos iguais são adicionados à direita
     * @param element o elemento a ser adicionado na arvore de pesquisa binaria
     */
    @Override
    public void addElement(T element) {
        
        BinaryTreeNode<T> temp = new BinaryTreeNode<T> (element);
        Comparable<T> comprableElement = (Comparable<T>) element;
        
        /**
         * Se a árvore estiver vazia, o elemento a adicionar torna-se no 
         * elemento root
         */
        if (isEmpty()){
            root = temp;
        }
        
        /**
         * Se não, o elemento atual(current) é a root
         */
        else{
            BinaryTreeNode<T> current = root;
            boolean added = false;
    
            while (!added) { //Se o elemento não estiver adicionado
                
                //se o elemento a adicionar for menor que o elemento atual
                if (comprableElement.compareTo(current.element) < 0) { 
                    
                    //se o elemento à esquerda do atual estiver nulo, essa posição fica com o elemento a adicionar
                    if (current.left == null) {
                        
                        current.left = temp;
                        added = true;
                    }
                    else{ //Se não, o elemento atual passa a ser o elemento à esquerda
                        current = current.left;
                    }
                }
                /**
                 * Se não, se o elemento à direita do atual estiver nulo, toma o
                 * valor do elemento a adicionar
                 */
                else{
                    if (current.right == null) {
                        
                        current.right = temp;
                        added = true;
                    }
                    else{ //Se não, o elemento atual passa a ser o elemento à direita
                        current = current.right;
                    }
                }
            }
        }
        count++;
    }

    /**
     * Remove o primeiro elemento que corresponde ao elemento especifico da arvore
     * de pesquisa binaria e retorna uma referencia deste
     * @param targetElement o elemento a ser procurado na arvore de pesquisa binaria
     * @return
     * @throws ElementNotFoundException se o elemento não for encontrado ocorre exceção
     */
    @Override
    public T removeElement(T targetElement) throws ElementNotFoundException {
        
        T result = null;
        
        /**
         * Se a árvore não estiver vazia, o elemento passado por parâmetro é 
         * comparado com a raíz da árvore. Caso seja igual, result obtem o valor
         * do elemento root, a root é substituída e é diminuído o número de
         * elementos da árvore
         */
        if (!isEmpty()) {
            
            if (((Comparable) targetElement).equals(root.element)) {
                
                result = root.element;
                root = replacement (root);
                count--;
            
            }
            else{
                BinaryTreeNode<T> current, parent = root;
                boolean found = false;
                
                /**
                 * Se o targetElement for menor que o elemento root, passamos
                 * para o elemento que está à esquerda do root
                 */
                if (((Comparable) targetElement).compareTo(root.element) < 0) { //retorna -1 se for menor, 1 se for maior, 0 se for igual

                    current = root.left;
                }
                
                /**
                 * Se o targetElement for maior que o elemento root, passamos
                 * para o elemento que está à esquerda do root
                 */
                else{
                    current = root.right;
                }
                //Enquanto o valor for null e não for encontrado o elemento para remover
                while (current != null && !found) {
                   
                     //Se o targetElement for igual ao elemento atual (current)

                    if (targetElement.equals(current.element)) {

                        found = true;
                        count--;
                        result = current.element;
                        
                        /**
                         * Se o targetElement for igual ao elemento a esquerda 
                         * do elemento pai, substituimos esse pelo targetElement
                         */
                        if (current == parent.left) { 
                            parent.left = replacement (current);
                        }
                        /**
                         * Se o targetElement for igual ao elemento da direita 
                         * do elemento pai, substituimos esse pelo targetElement
                         */
                        else{
                            parent.right = replacement (current);
                        }
                    }
                    /**
                     * Se não, o elemento pai fica o elemento atual.
                     * Se o targetElement for maior que o elemento atual,
                     * passamos para o elemento à esquerda
                     */
                    else{
                        parent = current;

                        if (((Comparable) targetElement).compareTo(current.element) < 0) {

                            current = current.left;
                        }
                        else{ //Se não, passamos para o elemento à direira
                            current = current.right;
                        }
                    }
                } 
                //Se não for encontrado lança exceção
                if (!found){
                    throw new ElementNotFoundException("Binary Search Tree");
                }
        
            }
        }    
        return result;
    }
    
    /**
     * Retorna a referencia do node que irá substituir o elemento especifico
     * para remoção. No caso em que o nó removido tem dois filhos, o
     * inorder successor é usado como seu substituto.
     * @param node o node a ser removido
     * @return a referencia do node de substituição
     */
    protected BinaryTreeNode<T> replacement (BinaryTreeNode<T> node) {
        
        BinaryTreeNode<T> result = null;
        
        if ((node.left == null) && node.right == null) {
            result = null;
        }
        else if ((node.left != null) && (node.right == null)) {
            result = node.left;
        }
        else if ((node.left == null) && (node.right != null)) {
            result = node.right;
        }
        else{
            BinaryTreeNode<T> current = node.right;
            BinaryTreeNode<T> parent = node;
            
            while (current.left != null) {
                parent = current;
                current = current.left;
            }
            
            if (node.right == current) {
                current.left = node.left;
            }
            else{
                parent.left = current.right;
                current.right = node.right;
                current.left = node.left;
            }
            result = current;
        }
        return result;
    }
    
    /**
     * Remove os elementos que correspondem ao targetElement 
     * da árvore de pesquisa binária. Lança um ElementNotFoundException se o
     * targetElement não for encontrado na árvore de pesquisa binária.
     * @param targetElement o elemento a ser procurado na arvore binária
     * @throws ElementNotFoundException se o elemento não for encontrado ocorre exceção
     */
    @Override
    public void removeAllOccurrences(T targetElement) throws ElementNotFoundException{
        
        removeElement(targetElement);
        
        try{
            while (contains ((T) targetElement)){
                removeElement(targetElement);
            }
        }
        catch (Exception ElementNotFoundException){
            System.out.println(ElementNotFoundException.toString());
        }
    }
    
    /**
     * Remove o node com menor valor da arvore de pesquisa binaria e 
     * retorna uma referencia do elemento.
     * @return a referencia do node com menor valor
     * @throws EmptyCollectionException se estiver vazia ocorre exceção
     */
    @Override
    public T removeMin() throws EmptyCollectionException {
        
        T result = null;
        
        if (isEmpty()) {
            throw new EmptyCollectionException("Binary Search Tree");
        }
        else{
            if (root.left == null) {
                
                result = root.element;
                root = root.right;
            }
            else{
                BinaryTreeNode<T> parent = root;
                BinaryTreeNode<T> current = root.left;
                
                while (current.left != null) {
                    
                    parent = current;
                    current = current.left;
                }
                result = current.element;
                parent.left = current.right;
            }
            count--;
        }
        return result;
    }
    
    /**
     * Remove o node com maior valor da arvore de pesquisa binaria e 
     * retorna uma referencia do elemento.
     * @return a referencia do node com maior valor
     * @throws EmptyCollectionException se estiver vazia ocorre exceção
     */
    @Override
    public T removeMax() throws EmptyCollectionException {
        
        T result = null;
        
        if (isEmpty()) {
            throw new EmptyCollectionException("Binary Search Tree");
        }
        else {
            
            if (root.right == null) {
                
                result = root.element;
                root = root.left;
            }
            else{
                BinaryTreeNode<T> parent = root;
                BinaryTreeNode<T> current = root.right;
                
                while (current.right != null) {
                    
                    parent = current;
                    current = current.right;
                }
                result = current.element;
                parent.right = current.left;
            }
            count--;
        }
        return result;
    }
    
    /**
     * Retorna o elemento com menor valor da arvore de pesquisa binária.
     * @return a referencia do node com menor valor
     * @throws EmptyCollectionException se estiver vazia ocorre exceção
     */
    @Override
    public T findMin() throws EmptyCollectionException {
        
        T result = null;
        
        if (isEmpty()) {
            throw new EmptyCollectionException("binary tree");
        }
        else{
            BinaryTreeNode<T> current = root;
            
            while (current.left != null) {
                current = current.left;
            }
            result = current.element;
        }
        return result;
    }
    
    /**
     * Retorna o elemento com menor valor da arvore de pesquisa binária.
     * @return a referencia do node com maior valor
     * @throws EmptyCollectionException se estiver vazia ocorre exceção
     */
    @Override
    public T findMax() throws EmptyCollectionException {
        
        T result = null;
        
        if (isEmpty()) {
            throw new EmptyCollectionException("binary tree");
        }
        else{
            BinaryTreeNode<T> current = root;
            
            while (current.right != null) {
                current = current.right;
            }
            result = current.element;
        }
        return result;
    }  
}