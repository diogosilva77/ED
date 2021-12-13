package Tree;

import Array.ArrayUnorderedList;
import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import Interfaces.BinaryTreeADT;
import Queue.LinkedQueue;
import java.util.Iterator;

/**
 *
 * @author dmanu
 */
public class ArrayBinaryTree<T> implements BinaryTreeADT<T> {
    
    protected int count;
    protected T[] tree;
    private final int CAPACITY = 50;
    
    /**
     * Cria uma arvore binaria vazia
     */
    public ArrayBinaryTree() {
        count = 0;
        tree = (T[]) new Object[CAPACITY];
    }
    
    /**
     * Cria uma arvore binaria com um elemento especifico a root
     * @param element o elemento que vai ser root na nova arvore binaria
     */
    public ArrayBinaryTree (T element) {
        count = 1;
        tree = (T[]) new Object[CAPACITY];
        tree[0] = element;
    }
    
    /**
     * Retorna a referencia do elemento root
     * @return a referencia do root
     * @throws ElementNotFoundException 
     */
    @Override
    public T getRoot() throws ElementNotFoundException {
        
        if (isEmpty()) {
            throw new ElementNotFoundException("Root is null");
        }
        return tree[0];
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
        
        return targetElement == find(targetElement);
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
        
        T temp = null;
        boolean found = false;
        
        for (int ct = 0; ct < count && !found; ct++){
            
            if (targetElement.equals(tree[ct])) {
                
                found = true;
                temp = tree[ct];
            }
        }
        if (!found){
            throw new ElementNotFoundException("binary tree");
        }
        return temp;
    }   
    
    /**
     * Executa uma travessia de ordem nesta árvore binária chamando um
     * método de ordem recursiva sobrecarregado que começa com a raiz
     * @return um iterador sobre os elementos desta árvore binária
     */
    @Override
    public Iterator<T> iteratorInOrder() {
        
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
        inorder (0, tempList);
        
        return tempList.iterator();
    }
    
    /**
     * Executa uma travessia de ordem recursiva.
     * @param node o nó a ser usado como raiz para esta travessia
     * @param tmpList a lista temporária para uso nesta travessia
     */
    protected void inorder (int node, ArrayUnorderedList<T> temList) {
        
        if (node < tree.length) {
            if (tree[node] != null){
                inorder(node*2+1, temList);
                temList.addToRear(tree[node]); //left
                inorder((node+1)*2, temList); //right
            }
        }
    }
    
    /**
     * Executa uma travessia de pré-ordem nesta árvore binária chamando um
     * método de pré-encomenda recursivo sobrecarregado que começa com a raiz
     * @return um iterador sobre os elementos desta árvore binária
     */
    @Override
    public Iterator<T> iteratorPreOrder() {
        
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
        preorder (0, tempList);
        
        return tempList.iterator();
    }
    
    /**
     * Executa um percurso de pré-ordem recursivo
     * @param node nó
     * @param tmpList lista temporaria
     */
    protected void preorder (int node, ArrayUnorderedList<T> temList) {
        
        if (node < tree.length) {
            if (tree[node] != null){
                temList.addToRear(tree[node]);
                preorder(node*2+1, temList); //left
                preorder((node+1)*2, temList); //right
            }
        }
    }
    
    /**
     * Executa uma travessia pós-ordem nesta árvore binária chamando um
     * método postorder recursivo sobrecarregado que começa com a raiz
     * @return um iterador sobre os elementos desta árvore binária
     */
    @Override
    public Iterator<T> iteratorPostOrder() {
        
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
        postorder (0, tempList);
        
        return tempList.iterator();
    }
    
    /**
     * Executa uma passagem de pós-pedido recursiva.
     * @param node nó
     * @param tmpList lista temporaria
     */
    protected void postorder (int node, ArrayUnorderedList<T> temList) {
        
        if (node < tree.length) {
            if (tree[node] != null){
                postorder(node*2+1, temList); //left
                postorder((node+1)*2, temList); //right
                temList.addToRear(tree[node]);
            }
        }
    }
/**
    @Override
    public Iterator<T> iteratorLevelOrder() throws ElementNotFoundException, EmptyCollectionException {
        
        //LinkedQueue<T> nodes = new LinkedQueue<T>();
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<>();
        int ct = 0;
        int i = 0;
        
        if (isEmpty()) {
            throw new ElementNotFoundException("Arvore vazia");
        }
        
        while (ct < count) {
            if (tree[i] != null) {
                tempList.addToRear(tree[i]);
                ct++;
            }
            i++;
        }
        //nodes.enqueue(tree[0]);
        
        
        return tempList.iterator();
    }*/
    
    @Override
    public Iterator<T> iteratorLevelOrder() {
        ArrayUnorderedList<T> templist = new ArrayUnorderedList<>();
        
        for (int ct = 0; ct < this.count; ct++) {
            templist.addToRear(this.tree[ct]);
        }
        
        return templist.iterator();
    }
}