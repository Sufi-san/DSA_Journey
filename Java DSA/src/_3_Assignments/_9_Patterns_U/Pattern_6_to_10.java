package _3_Assignments._9_Patterns_U;

public class Pattern_6_to_10 {
    public static void main(String[] args) {
        int n = 5;
        // Pattern 6
        for(int i = n; i > 0; i--){
            for(int j = 0; j <= n; j++){
                if(j < i){
                    System.out.print(" ");
                }
                else{
                    System.out.print("*");
                }
            }
            System.out.println();
        }
        System.out.println();

        // Pattern 7
        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= n; j++){
                if(j < i){
                    System.out.print(" ");
                }
                else{
                    System.out.print("*");
                }
            }
            System.out.println();
        }
        System.out.println();

        // Pattern 8
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= 2 * n - 1; j++){
                if(j > n - i && j < n + i){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println();

        // Pattern 9
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= 2 * n - 1; j++){
                if(j >= i && j <= 2 * n - i){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println();

        // Pattern 10
        for(int i = 1; i <=n; i++) {
            for (int j = 1; j <= n; j++) {
                if (j <= n - i) {
                    System.out.print(" ");
                } else {
                    System.out.print(" *");
                }
            }
            System.out.println();
        }
    }
}
