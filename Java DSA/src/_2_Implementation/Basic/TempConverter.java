package _2_Implementation.Basic;
import java.util.Scanner;
public class TempConverter {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        System.out.println("Enter temperature in Celsius: ");
        double celsius =  s1.nextDouble();
        double fahrenheit = celsius * 9 / 5 + 32;
        System.out.println("Temperature in Fahrenheit is: "+fahrenheit);
    }
}
