package _2_Implementation.ConditionalsAndLoops;
import java.util.Scanner;
public class Q_OccurenceCount {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        System.out.println("Enter the character whose occurrence is to be checked: ");
        char find = s1.nextLine().charAt(0);
        System.out.println("Enter the sequence which needs to be checked: ");
        String sequence = s1.nextLine();
        int count = 0;
        for (int i = 0; i < sequence.length(); i++) { // .length() method returns the length of the string
            if(find == sequence.charAt(i)){
                count++;
            }
        }
        System.out.println(find+" has appeared "+count+" times in the sequence.");
/*              Alternative code using %10 logic, (for numbers only)
              Any number divided by 10 returns its last digit as remainder.
              Thus using this logic, we can check the sequence from units place.
        System.out.println("Enter number to check for occurrences: ");
        int num = s1.nextInt();
        System.out.println(("Enter sequence which needs to be checked: "));
        int seq = s1.nextInt();
        int count = 0;
        while(seq > 0){
            int rem = seq%10;
            seq = seq/10;  // No floating quotient as seq is of type int, thus one digit removed from units place.
            if(rem == num){
                count++;
            }
        }

        System.out.println(num+" has appeared "+count+" times in the sequence."); */
    }
}