/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex3;


/**
 *
 * @author dmanu
 * @param <T>
 */
public class UnorderedPair<T extends Comparable> extends Pair<T> {
    
    public UnorderedPair() {
        setFirst(null);
        setSecond(null);
    }
    
    public UnorderedPair(T firstItem, T secondItem) {
        setFirst(firstItem);
        setSecond(secondItem);
    }
    
    @Override
    public boolean equals (Object otherObject) {
        if (otherObject == null) {
            return false;
        }
        else if (getClass() != otherObject.getClass()) {
            return false;
        }
        else {
            UnorderedPair<T> otherPair = (UnorderedPair<T>) otherObject;
        
            return (getFirst().equals(otherPair.getFirst())
                    && getSecond().equals(otherPair.getSecond()))
                    || (getFirst().equals(otherPair.getSecond())
                    && getSecond().equals(otherPair.getFirst()));
        }
    }
    
    
}
