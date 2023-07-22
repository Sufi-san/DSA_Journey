package _3_Assignments._2_BasicJava;
import java.util.Scanner;

public class ArmstrongRange {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter two whole number as lower limit and upper limit respectively: ");
        int lowLim = in.nextInt();
        int upLim = in.nextInt();
        giveAllArmstrongs(lowLim, upLim);
    }

    static void giveAllArmstrongs(int low, int up) {
        int numSum, digit, numLen, temp;
        System.out.println("\nThe Armstrong numbers between given range are:");
        for (int i = low; i <= up; i++) {
            numLen = Integer.toString(i).length();
            numSum = 0;
            temp = i;
            do {
                digit = temp % 10;
                numSum = numSum + (int) Math.pow(digit, numLen);
                temp = temp / 10;
            } while (temp != 0);
            if (numSum == i)
                System.out.print(i+" ");
        }
    }
}
