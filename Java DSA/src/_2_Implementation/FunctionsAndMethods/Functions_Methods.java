package _2_Implementation.FunctionsAndMethods;
import java.util.Scanner;
public class Functions_Methods {
    /* As Java is a mostly Object-Oriented Programming Language,
       functions are always created inside classes.
       These functions are known as methods.
     */
    public static void main(String[] args) {
        sumMethod();  // Calling the method
        System.out.println();
        System.out.println("The sum is: "+sum2());  // Getting the value from another method
        sum3(34, 56);  // Passing parameters
    }
 /* Basic Syntax:
    access_modifier return_type name(arguments){
        // body
        return statement;
    }
  */
    public static void sumMethod(){  // Method created outside of main function
        Scanner s1 = new Scanner(System.in);
        double num1, num2, sum;
        System.out.print("Enter the first number: ");
        num1 = s1.nextDouble();
        System.out.print("Enter the second number: ");
        num2 = s1.nextDouble();
        sum = num1 + num2;
        System.out.println("The sum is: "+sum);
    }

    public static double sum2(){  // return value instead of display, type is now 'double'
        Scanner s1 = new Scanner(System.in);
        double num1, num2, sum;
        System.out.print("Enter the first number: ");
        num1 = s1.nextDouble();
        System.out.print("Enter the second number: ");
        num2 = s1.nextDouble();
        sum = num1 + num2;
        return sum;  // Function ends here
    }

    public static void sum3(int a, int b){System.out.println("Parameter Sum = "+(a+b));}
}
