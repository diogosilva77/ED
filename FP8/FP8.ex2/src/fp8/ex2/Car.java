/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fp8.ex2;

/**
 *
 * @author dmanu
 */
public class Car implements Comparable{
    
    private String marca;
    private String modelo;
    private int ano;

    public Car(String marca, String modelo, int ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }

    @Override
    public int compareTo(Object o) {
        
        try{
            Car tmp = (Car) o;
            
            if (this.ano < tmp.ano){
                return -1;
            }
            else if (this.ano == tmp.ano){
                return 0;
            }
            else{
                return 1;
            }   
        }
        catch (Exception e) {
            throw new ClassCastException();
        }
    }

    @Override
    public String toString() {
        return "Car{" + "marca=" + marca + ", modelo=" + modelo + ", ano=" + ano + '}';
    }

    
}
