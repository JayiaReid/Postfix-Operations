/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package operation.stacks;

import java.util.Stack;

/**
 *
 * @author jayia
 */
public class OperationStacks {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
//have and read postfix expression

    String exp = "1 2 / 3 *";
    
    Stack<Double> stack = new Stack();
    
    double num = 0;
    
    for (int i=0; i < exp.length(); i++){
        char el = exp.charAt(i);
        
        if(Character.isDigit(el)){
            // push a digit to stack
            stack.push((double)Character.getNumericValue(el));
        }else if(!Character.isSpaceChar(el)){
            // encounter operator apply to top 2 elements in stack
            double n1 = stack.pop();
            double n2 = stack.pop();
            
            num = applyOperand(n2, n1, el);
            if(num == 0){
                System.out.println("Invalid Operand");
                break;
            }else{
               //replace top 2 with new result
            stack.push(num); 
            }
        }else{
            continue;
        }
        
         System.out.println(stack);
    }

    }
    
    static double applyOperand(double num1, double num2, char operand){
        
//        can be modified to float to accout for division
        
        return switch (operand) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> num1/ num2;
            default -> 0;
        };
    }
    
}


