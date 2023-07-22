package _3_Assignments._3_ConditionalsAndLoops;
import java.util.Scanner;
public class VowelConsonant {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter alphabet to check vowel or consonant:");
        char ch = in.next().trim().charAt(0);
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U')
            System.out.println("Entered alphabet is a vowel.");
        else if((ch > 'a' && ch <= 'z') || (ch > 'A' && ch <= 'Z'))
            System.out.println("Entered alphabet is a consonant.");
        else
            System.out.println("Please Enter an alphabet.");
    }
}
