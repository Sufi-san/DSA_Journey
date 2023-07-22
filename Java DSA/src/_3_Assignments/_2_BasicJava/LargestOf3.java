package _3_Assignments._2_BasicJava;
import java.util.Scanner;
public class LargestOf3 {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        System.out.println("Enter three numbers: ");
        int num1 = s1.nextInt();
        int num2 = s1.nextInt();
        int num3 = s1.nextInt();
        if(num1 >= num2 && num1 >= num3) {
            System.out.println(num1+" is the greatest.");
        }else if(num2 >= num3){
            System.out.println(num2+" is the greatest.");
        }else{
            System.out.println(num3+" is the greatest.");
        }

        /* Alternative Code:
        int max = num1;
        if(num2 > max){
            max = num2;
        }
        if(num3 > max){
            max = num3;
        }
        System.out.println(max+" is the greatest number.");
        //OR
        int max = Math.max(num3, Math.max(num1, num2));  // Math.max() returns maximum value out of 2 numbers.
         */
    }
}
