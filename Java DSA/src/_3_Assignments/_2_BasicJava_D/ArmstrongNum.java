package _3_Assignments._2_BasicJava_D;
import java.util.Scanner;


public class ArmstrongNum {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        System.out.print("Enter an integer to check whether it is an armstrong number: ");
        int num = s1.nextInt();
        System.out.println(checkArmstrong(num));
        System.out.print("How many Armstrong numbers are to be printed?: ");
        int num2 = s1.nextInt();
        int count = 0;
        int i = 0;
        while (count < num2){
            if(checkArmstrong(i)) {
                System.out.print(i+", ");
                count++;
            }
            i++;
        }
    }
    static boolean checkArmstrong(int n){
        int power = Integer.toString(n).length();
        int numbSum = 0;
        int value = n;
        while(n > 0){
            int c = n % 10;
            numbSum = numbSum + (int)Math.pow(c, power);
            n /= 10;
        }
        return numbSum == value;
    }
}
