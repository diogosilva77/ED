package fp8.ex2;

import List.LinkedList;
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
        
        LinkedList<Car> list = new LinkedList<>();
        
        list.add(c1);
        list.add(c2);
        list.add(c3);
        list.add(c4);
        list.add(c5);
        
        list.printList();
        System.out.println("-----------------------");
        
        System.out.println("Resultado LinearSearch: " + SortingandSearching.linearSearch(list, c3));
        System.out.println("Resultado BinarySearch: " + SortingandSearching.binarySearch(list, 0, 0, c4));
        
    }
    
}
