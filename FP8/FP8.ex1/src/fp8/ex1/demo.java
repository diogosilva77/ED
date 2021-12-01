package fp8.ex1;

import SortSearch.SortingandSearching;

/**
 *
 * @author dmanu
 */
public class demo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Car c1 = new Car("VW", "Golf", 2011);
        Car c2 = new Car("BMW", "M4", 2012);
        Car c3 = new Car("Mercedes", "A45", 2013);
        Car c4 = new Car("Peugeot", "308", 2014);
        Car c5 = new Car("Ferrari", "F40", 2015);
        
        Car cararray[] = new Car[10];
        
        cararray[0] = c1;
        cararray[1] = c2;
        cararray[2] = c3;
        cararray[3] = c4;
        cararray[4] = c5;
        
        System.out.println("Resultado LinearSearch: " + SortingandSearching.linearSearch(cararray, 0, 4, c5));
        System.out.println("Resultado BinarySearch: " + SortingandSearching.binarySearch(cararray, 0, 4, c3));
    } 
}