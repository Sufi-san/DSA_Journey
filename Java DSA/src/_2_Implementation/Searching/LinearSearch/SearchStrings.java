package _2_Implementation.Searching.LinearSearch;

import java.util.Scanner;

public class SearchStrings {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a String to search in:");
        String str = in.nextLine();
        if(str.length() != 0) {
            System.out.println("Enter character to search for: ");
            try {
                char target = in.nextLine().strip().charAt(0);
                int index1 = stringLS(str, target);
                int index2 = stringLS2(str, target);
                System.out.println("Target element is at index " + index1 + "\nBy Second Method: " + index2);
            }
            catch(Exception e){
                System.out.println("Strings or Empty Character not allowed.");
            }
        }
        else{
            System.out.println("Empty String entered");
        }
    }

    static int stringLS(String str, int target){
        char[] arr = str.toCharArray();
        int i = 0;
        for(char element: arr){ // String does not allow for each loop. (Thus converted to char array)
            if(element == target) return i;
            i++;
        }
        return -1;
    }

    static int stringLS2(String str, int target){
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == target) return i;
        }
        return -1;
    }
}
