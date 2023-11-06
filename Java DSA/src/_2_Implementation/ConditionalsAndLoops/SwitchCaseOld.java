package _2_Implementation.ConditionalsAndLoops;
import java.util.Scanner;
public class SwitchCaseOld {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        System.out.println("Enter the name of fruit: ");
        String fruit = s1.next();
        switch(fruit){
            case "mango":
                System.out.println("King of fruits.");
                break;  // If no break is present all below cases are executed till a break is encountered.
            case "apple":
                System.out.println("A sweet juicy fruit.");
                break;
            case "grape":
                System.out.println("Lot of liquid inside.");
                break;
            case "banana":
                System.out.println("Be careful with this one...(Needs proper context)");
                break;
            default:  // runs when no case is true
                System.out.println("Either it isn't a fruit or not one we have a description for.");
        }
    }
}
