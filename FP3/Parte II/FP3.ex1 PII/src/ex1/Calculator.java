/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import Stack.ArrayStack;
import Stack.EmptyCollectionException;
import java.util.Scanner;

/**
 *
 * @author dmanu
 */
public class Calculator {
    
    ArrayStack<Integer> stack = new ArrayStack<>();

    public Calculator() {
    }
    
    public void ask() throws EmptyCollectionException{
        
        String input;
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduzir expressão: ");
        
        input = scanner.nextLine();
        processInput(input);
    }
    
    public void processInput(String input) throws EmptyCollectionException {
            String[] inarray = input.split("");
            for(int x = 0; x < inarray.length; x++){
                try {
                    Integer tmp = Integer.parseInt(inarray[x]);
                    if (tmp instanceof Integer) {
                        stack.push(tmp);
                    }
                }catch(Exception e){
                    calculate(inarray[x]);
                }
            }
        System.out.println("stack: \n" + stack.toString());
    }
    
    
    public void calculate(String op) throws EmptyCollectionException {

        int num1 = 0, num2 = 0, result = 0;

        String operation = op;

        try {
            switch (operation) {
                case "+":
                    num1 = stack.pop();
                    num2 = stack.pop();
                    result = num1 + num2;
                    stack.push(result);
                    System.out.println("Result: " + result);
                    break;

                case "-":
                    num1 = stack.pop();
                    num2 = stack.pop();
                    result = num1 - num2;
                    stack.push(result);
                    System.out.println("Result: " + result);
                    break;

                case "/":
                    num1 = stack.pop();
                    num2 = stack.pop();
                    result = num1 / num2;
                    stack.push(result);
                    System.out.println("Result" + result);
                    break;

                case "*":
                    num1 = stack.pop();
                    num2 = stack.pop();
                    result = num1 * num2;
                    stack.push(result);
                    System.out.println("Result: " + result);
                    break;

                default:
                    break;
            }
        } catch (EmptyCollectionException e) {

            e.printStackTrace();

        }

    }
    
}
