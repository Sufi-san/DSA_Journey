package _3_Assignments._9_Patterns;

public class Pattern_1_to_5 {
    public static void main(String[] args) {
        int n = 5;
        // Pattern 1
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();

        // Pattern 2
        for(int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();

        // Pattern 3
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n - i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();

        // Pattern 4
        for(int i = 1; i <=  n; i++){
            for(int j = 1; j <= i; j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
        System.out.println();

        // Pattern 5
        for(int i = 1, k = 0; i <= 2 * n - 1; i++){
            if(i < n + 1){
                for(int j = 1; j <= i; j++){
                    System.out.print("*");
                }
            }
            else{
                for(int j = n - 1 - k; j > 0; j--){
                    System.out.print("*");
                }
                k++;
            }
            System.out.println();
        }
        System.out.println();

        // Pattern 5 (without 3rd pointer, formulaic approach)
        for(int i = 1; i <= 2 * n - 1; i++){
            if(i <= n){
                for(int j = 1; j <= i; j++){
                    System.out.print("*");
                }
            }
            else{
                for(int j = 1; j <= 2 * n - i; j++){
                    System.out.print("*");
                }
            }
            System.out.println();
        }
        System.out.println();

        // Pattern 5 (multiple nested of loops)
        for(int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < n - i - 1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
