package _3_Assignments._9_Patterns;

public class Pattern_11_to_15 {
    public static void main(String[] args) {
        int n = 5;
        // Pattern 11
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(j < i){
                    System.out.print(" ");
                }
                else{
                    System.out.print(" *");
                }
            }
            System.out.println();
        }
        System.out.println();

        // Pattern 12
        for(int i = 1; i <= 2 * n; i++){
            for(int j = 1; j <= n; j++){
                boolean condition = (i > n)? (j < 2 * n - i + 1): (j < i);
                if(condition){
                    System.out.print(" ");
                }
                else{
                    System.out.print(" *");
                }
            }
            System.out.println();
        }
        System.out.println();

        // Pattern 13
        for(int i = 0; i < n; i++){
            for(int j = 1; j <= n + i; j++){
                if(i == n - 1 || j == n - i || j == n + i){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println();

        // Pattern 14
        for(int i = n - 1; i >= 0; i--){
            for(int j = 1; j <= n + i; j++){
                if(i == n - 1 || j == n - i || j == n + i){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println();

        // Pattern 15
        for(int i = 0; i < 2 * n - 1; i++){
            int jLimit = (i >= n)? 3 * n - i - 2: n + i;
            for(int j = 1; j <= jLimit; j++){
                int firstPrint = (i >= n)? i - n + 2: n - i;
                if(j == firstPrint || j == jLimit){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
