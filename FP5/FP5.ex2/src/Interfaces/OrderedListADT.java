/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;


/**
 *
 * @author dmanu
 */
public interface OrderedListADT<T> extends ListADT<T> {
    
    /**
     * Adiciona um elemento na lista no local adequado
     * @param element elemento a ser adicionado na lista
     */
    public void add (T element) throws EmptyCollectionException;
    
        
}
