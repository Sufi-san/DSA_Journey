package _2_Implementation.FunctionsAndMethods;
import java.util.Scanner;
public class StringReturn {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        System.out.println("Do you want to display greeting?: (Type Yes or No)");
        String choice = s1.next();
        if(choice.equals("Yes")){
            String text = greet();
            System.out.println(text);
        }else{
            System.out.println("As you wish.");
        }
        System.out.println("Enter your name: ");
        String name = s1.nextLine();
        String text2 = greet2(name);
        System.out.println(text2);
    }

    static String greet2(String p_name) {
        return "Hello, "+p_name;
    }

    static String greet(){
        return "Hello my friend!";
    }
}
