/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

/**
 *
 * @author dmanu
 */
public class TwoTypePair <T1, T2>{

    private T1 first;
    private T2 second;
    //construtor que define as variaveis como null
    public TwoTypePair() {
        first = null;
        second = null;
    }
    //construtor que define as variaveis com um valor 
    public TwoTypePair(T1 firstItem, T2 secondItem) {
        first = firstItem;
        second = secondItem;
    }
    //permite obter o valor de first 
    public T1 getFirst() {
        return first;
    }
    //permite alterar o valor de first
    public void setFirst(T1 first) {
        this.first = first;
    }
    //permite obter o valor de second
    public T2 getSecond() {
        return second;
    }
    //permite alterar o valor de second
    public void setSecond(T2 second) {
        this.second = second;
    }
    //permite imprimir o resultado de ambos os tipos
    public String toString() {
        return ("first: " + first.toString() + "\n"
        + "second: " + second.toString());
    }

    public boolean equals(Object otherObject) {
        if (otherObject == null) {
        return false;
    } else if (getClass() != otherObject.getClass()) {
        return false;
    } else {
        TwoTypePair otherPair = (TwoTypePair) otherObject;
        return (first.equals(otherPair.first) && second.equals(otherPair.second));
        }
    }
}
