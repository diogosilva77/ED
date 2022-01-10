package Tree;

import Array.ArrayUnorderedList;
import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import Interfaces.BinaryTreeADT;
import Queue.LinkedQueue;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dmanu
 */
public class LinkedBinaryTree<T> implements BinaryTreeADT<T> {
    
    protected int count;
    public BinaryTreeNode<T> root;

    public LinkedBinaryTree() {
        this.count = 0;
        this.root = null;
    }
    
    public LinkedBinaryTree (T element) {
        this.count = 1;
        this.root = new BinaryTreeNode<T> (element);
    }
    
    /**
     * Retorna a referencia do elemento root
     * @return a referencia do root
     * @throws ElementNotFoundException 
     */
    @Override
    public T getRoot() throws ElementNotFoundException{
        
         if (isEmpty()){
             throw new ElementNotFoundException("Root is null");
         } 
         return this.root.element;
    }
    /**
     * Retorna true se a arvore binaria estiver vazia
     * @return true se a arvore binaria estiver vazia
     */
    @Override
    public boolean isEmpty() {
        
        return (size() == 0);
    }
    
    /**
     * Retorna o numero de elementos da arvore binaria
     * @return o numero inteiro de elementos da arvore
     */
    @Override
    public int size() {
        return count;
    }
    
    /**
     * Retorna true se a arvore binaria contiver um elemento que corresponda ao
     * elemento especifico procurado e falso se não contiver
     * @param targetElement o elemento especifico a ser procurado
     * @return true se econtrar o elemento
     * @throws ElementNotFoundException 
     */
    @Override
    public boolean contains(T targetElement) throws ElementNotFoundException {
        
        if (isEmpty()) {
            throw new ElementNotFoundException("Arvore vazia");
        }
        
        return (findAgain(targetElement, root) != null);
        
    }
    
    /**
     * Retorna a referencia do elemento especifico se este for encontrado
     * na arvore binaria. Lança uma NoScuhElementException se o elemento 
     * especifico não for encontrado.
     * @param targetElement elemento a ser procurado na arvore
     * @return a referencia do elemento especifico
     * @throws ElementNotFoundException se ocorrer uma exceção para o elemento 
     * não encontrado
     */
    @Override
    public T find(T targetElement) throws ElementNotFoundException {
        
        BinaryTreeNode<T> current = findAgain (targetElement, root);
        
        if (current == null){
            throw new ElementNotFoundException("Elemento não encontrado");
        }
        return (current.element);
    }
    
    /**
     * Retorna a referência do elemento especifico se este for encontrado
     * na arvore binaria.
     * @param targetElement o elemento a ser procurado na arvore
     * @param next elemento para começar a procurar
     * @return 
     */
    private BinaryTreeNode<T> findAgain(T targetElement, BinaryTreeNode<T> next) {
        
        if (next == null){
            return null;
        }
        if (next.element.equals(targetElement)){
            return next;
        }
        BinaryTreeNode<T> tmp = findAgain(targetElement, next.left);
        
        if (tmp == null){
            tmp = findAgain(targetElement, next.right);
        }
        return tmp;
    }
    
    /**
     * Executa uma travessia de ordem nesta árvore binária chamando um
     * método de ordem recursiva sobrecarregado que começa com a raiz
     * @return um iterador sobre os elementos desta árvore binária
     */
    @Override
    public Iterator<T> iteratorInOrder() {
        
        ArrayUnorderedList<T> tmpList = new ArrayUnorderedList<T>();
        inorder (root, tmpList);
        
        return tmpList.iterator();
    }
    
    /**
     * Executa uma travessia de ordem recursiva.
     * @param node o nó a ser usado como raiz para esta travessia
     * @param tmpList a lista temporária para uso nesta travessia
     */
    protected void inorder(BinaryTreeNode<T> node, ArrayUnorderedList<T> tmpList) {
        if (node != null) {
            inorder(node.left, tmpList);
            tmpList.addToRear(node.element);
            inorder(node.right, tmpList);
        }
    }
    
    /**
     * Executa uma travessia de pré-ordem nesta árvore binária chamando um
     * método de pré-encomenda recursivo sobrecarregado que começa com a raiz
     * @return um iterador sobre os elementos desta árvore binária
     */
    @Override
    public Iterator<T> iteratorPreOrder() {
        
        ArrayUnorderedList<T> tmpList = new ArrayUnorderedList<T>();
        preorder (root, tmpList);
        
        return tmpList.iterator();
    }
    
    /**
     * Executa um percurso de pré-ordem recursivo
     * @param node nó
     * @param tmpList lista temporaria
     */
    protected void preorder(BinaryTreeNode<T> node, ArrayUnorderedList<T> tmpList) {
        
        if (node != null) {
            tmpList.addToRear(node.element);
            preorder (node.left, tmpList);
            preorder (node.right, tmpList);
        }
    }

    /**
     * Executa uma travessia pós-ordem nesta árvore binária chamando um
     * método postorder recursivo sobrecarregado que começa com a raiz
     * @return um iterador sobre os elementos desta árvore binária
     */
    @Override
    public Iterator<T> iteratorPostOrder() {
        
        ArrayUnorderedList<T> tmpList = new ArrayUnorderedList<T>();
        postorder (root, tmpList);
        
        return tmpList.iterator();
    }
    
    /**
     * Executa uma passagem de pós-pedido recursiva.
     * @param node nó
     * @param tmpList lista temporaria
     */
     protected void postorder(BinaryTreeNode<T> node, ArrayUnorderedList<T> tmpList) {

        if (node != null) {
            postorder(node.left, tmpList);
            postorder(node.right, tmpList);
            tmpList.addToRear(node.element);
        }
    }
    
    /**
     * Excuta uma passagem de levelorder recursiva
     * @return
     * @throws ElementNotFoundException
     * @throws EmptyCollectionException 
     */
    @Override
    public Iterator<T> iteratorLevelOrder() throws ElementNotFoundException, EmptyCollectionException{
        
        LinkedQueue<T> nodes = new LinkedQueue<T>();
        ArrayUnorderedList<T> resultList = new ArrayUnorderedList<T>();
 
        if (isEmpty()) {
            throw new ElementNotFoundException("Arvore vazia");
        }
        
        nodes.enqueue((T) root);
        
        while (!nodes.isEmpty()) {
            
            BinaryTreeNode<T> tmpNode = (BinaryTreeNode<T>) nodes.dequeue();
            
            if (tmpNode != null) {
                
                resultList.addToRear(tmpNode.element);
                
                if (tmpNode.numChildren() > 0) {
                    nodes.enqueue((T) tmpNode.left);
                    nodes.enqueue((T) tmpNode.right);
                }
            }    
        }
        return resultList.iterator();
    }
}
