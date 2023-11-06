package _2_Implementation.ConditionalsAndLoops;
import java.util.Scanner;
public class EnhancedSwitch {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        System.out.println("Enter the name of day: ");
        String day = s1.next();
        switch (day) {
            case "Monday" -> System.out.println("Back to work!");  // No breaks required
            case "Tuesday" -> System.out.println("You got whole week ahead !");
            case "Wednesday" -> System.out.println("When is this gonna end?!");
            case "Thursday" -> System.out.println("Halfway through hell.");
            case "Friday" -> System.out.println("The good days are coming.");
            case "Saturday" -> System.out.println("Today is my day.");
            case "Sunday" -> System.out.println("The feelings are bittersweet.");
            default -> System.out.println("Enter a valid name for day of the week.");
            // for multiple lines of code, {} curly braces can be used after ->
            // Switch cases can also be nested.
        }
    }
}
