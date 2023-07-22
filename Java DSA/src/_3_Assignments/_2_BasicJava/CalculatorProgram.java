package _3_Assignments._2_BasicJava;
import java.util.Scanner;
public class CalculatorProgram {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        double ans = 0;
        while(true){
            System.out.println("Select any basic operator (+, -, *, /, %): (Press X or x to stop) ");
            char op = s1.next().trim().charAt(0);
            if (op == '+' || op == '-' || op == '*' || op == '/' || op == '%'){
                System.out.println("Enter first number: ");
                double num1 = s1.nextDouble();
                System.out.println("Enter second number: ");
                double num2 = s1.nextDouble();
                if(op == '+'){
                    ans = num1 + num2;
                }else if(op == '-'){
                    ans = num1 - num2;
                }else if(op == '*'){
                    ans = num1 * num2;
                }else if(op == '/'){
                    if(num2 != 0) {
                        ans = num1 / num2;
                    }
                    else {
                        System.out.println("Cannot divide by zero.");
                    }
                }else{
                    ans = num1 % num2;
                }
                System.out.println("Result is: "+ans);
            }else if(op == 'x' || op == 'X'){
                break;
            }else{
                System.out.println("Please enter valid operator.");
            }
        }

    }
}
