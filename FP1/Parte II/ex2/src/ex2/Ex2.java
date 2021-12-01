/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2;

import java.util.ArrayList;

/**
 * Exercício 2 e 3 da Parte II
 * @author dmanu
 */
public class Ex2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       /* 
        Point[] a = new Point[10];
        Object [] b;
        b[0] = new Point(10,20);
        
        
        Point[] a = new Point[10];
        Object [] b;
        b[0] = new Point(10,20);
        b[0] = "Magical Mystery Tour";
        
        
        Point[] a = new Point[10];
        Object [] b;
        b[0] = new Point(10,20);
        a[0] = "Magical Mystery Tour";  */
       
       
       ArrayList<Point> a = new ArrayList<Point>();
       ArrayList<Point> b = new ArrayList<Point>();
       //ArrayList<Object> b;
       
       a.add(new Point(10,20));
       a.add(new Point(3,5));
       
       b.add(new Point(1,2));
       
       
       System.out.println(a.toString());
       System.out.println(b.toString());
    }
    
}
