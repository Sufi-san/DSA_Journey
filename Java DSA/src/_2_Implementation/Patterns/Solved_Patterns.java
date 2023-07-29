package _2_Implementation.Patterns;

public class Solved_Patterns {
    public static void main(String[] args) {
        System.out.println("\nPattern 1:");
        pattern1(5);
        System.out.println("\nPattern 2:");
        pattern2(5);
        System.out.println("\nPattern 3:");
        pattern3(5);
        System.out.println("\nPattern 4:");
        pattern4(5);
        System.out.println("\nPattern 5:");
        pattern5(5);
        System.out.println("\nPattern 5: (Loop combination)");
        altPattern5(5);
        System.out.println("\nPattern 6:");
        pattern6(5);
        System.out.println("\nPattern 7:");
        pattern7(5);
        System.out.println("\nPattern 8:");
        pattern8(5);
        System.out.println("\nPattern 8: (Loop combination)");
        altPattern8(5);
        System.out.println("\nPattern 9:");
        pattern9(4);
        System.out.println("\nPattern 9: (Easy)");
        altPattern9(4);
        System.out.println("\nPattern 10:");
        pattern10(4);
        System.out.println("\nPattern 10: (another approach)");
        altPattern10(4);
    }

    static void pattern1(int n){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void pattern2(int n){
        for(int i = 0; i < n; i++){
            // for every row, run the col
            for(int j = 0; j <= i; j++){
                System.out.print("*");
            }
            // when one row is printed, we need to add a newline
            System.out.println();
        }
    }

    static void pattern3(int n){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n - i; j++){  // alternative: for(int j = n; j > i; j--)
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void pattern4(int n){
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){ //
                System.out.print((j + 1)+" ");
            }
            System.out.println();
        }
    }

    static void pattern5(int n){
        for(int i = 0; i < 2 * n; i++){
            if(i <= n){  // Other thing that can be done is to just update limit for 'j' based on 'n' using ternary
                for(int j = 0; j < i; j++){
                    System.out.print("*");
                }
                System.out.println();
            }
            else{
                for(int j = 0; j < 2 * n - i; j++){
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }

    static void altPattern5(int n){  // simply combine for loops of pattern 2 and 3 with one required line less in any pattern
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n - i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void pattern6(int n){
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(j > n - i){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    static void pattern7(int n){
        for(int i = 1; i <= 2 * n - 1; i++){
            int limit = (i > n)? i - n: n - i;
            for(int j = 1; j <= n; j++){
                if(j > limit){
                    System.out.print(" *");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    static void pattern8(int n){ // using formula which also counts spaces
        for(int i = 1; i <= n; i++){
            int value = i;
            for(int j = 1; j <= 4 * n - 3; j++){
                if(j >= 2 * (n - i) + 1 && j < 2 * (n + i - 1) && j % 2 != 0){
                    System.out.print(value);
                    value = (j >= 2 * n - 1)? value + 1: value - 1;
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    static void altPattern8(int n){  // using multiple for loops, spaces are not counted but added while printing
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n - i; j++){ // n - i spaces, e.g: in first line spaces = n - 1 = 5 - 1 = 4
                System.out.print(" ");
                System.out.print(" "); // This extra space is added to all lines for i < n, for correct alignment
                // It is common sense since for each line in the pattern,
                // the starting space of next/previous line differs by 2.
            }
            for(int j = 1; j <= i; j++){  // Kunal simply used a decrementing loop, I wanted to try different
                System.out.print((i - j + 1) + " ");
            }
            for(int j = 2; j <= i; j++){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    static void pattern9(int n){ // first part is the same as above pattern, excluding extra space
        for(int i = 1; i <= 2 * n - 1; i++){
            if(i <= n) {
                for (int j = 1; j <= n - i; j++) {
                    System.out.print(" ");
                }
                for (int j = 1; j <= i; j++) {
                    System.out.print(i - j + 1);
                }
                for (int j = 2; j <= i; j++) {
                    System.out.print(j);
                }
                System.out.println();
            }
            else{
                for (int j = 1; j <= i - n; j++) {
                    System.out.print(" ");
                }
                for (int j = i - n; j < n; j++) {
                    System.out.print(n - j);
                }
                for (int j = 2; j <= 2 * n - i; j++) {
                    System.out.print(j);
                }
                System.out.println();
            }
        }
    }

    static void altPattern9(int n){ // Easy and Efficient
        for(int row = 1; row <= 2 * n - 1; row++){
            int limit = (row > n)? 2 * n - row: row; // How it goes 1,2,3,...,n,...,2n-3,2n-2,2n-1
            // What is being printed will remain the same, but the interval differs
            for(int col = 1; col <= n - limit; col++){
                System.out.print(" ");
            }
            for(int col = limit; col > 0; col--){
                System.out.print(col);
            }
            for(int col = 2; col <= limit; col++){
                System.out.print(col);
            }
            System.out.println();
        }
    }

    static void pattern10(int n){
        for(int row = 2 * n - 1; row > 0; row--){
            int limit = (row >= n)? 1 - n + row: 1 + n - row ;
            for(int col = n; col > 0; col--){
                int printVal = Math.max(limit, col);
                System.out.print(printVal + " ");
            }
            for(int col = 2; col <= n; col++){
                int printVal2 = Math.max(limit,col);
                System.out.print(printVal2 + " ");
            }
            System.out.println();
        }
    }

    static void altPattern10(int n){ // another approach, Very Easy
        int limit = 2 * n - 2;
        for(int row = 0; row <= limit; row++){
            for(int col = 0; col <= limit; col++){
                int minPath = Math.min(Math.min(row, col), Math.min(limit - row, limit - col));
                int printVal = n - minPath;
                System.out.print(printVal + " ");
            }
            System.out.println();
        }
    }
}
