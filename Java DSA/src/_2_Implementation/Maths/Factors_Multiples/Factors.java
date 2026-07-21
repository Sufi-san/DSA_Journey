package _2_Implementation.Maths.Factors_Multiples;

import java.util.ArrayList;

public class Factors {
    public static void main(String[] args) {
        int num = 1080;
        findFactors(num);
        System.out.println();
        findFactors2(num);
        System.out.println();
        findFactors3(num); // Same as findFactors2 but in sorted order
    }

    // Basic Approach: O(n)
    static void findFactors(int num) {
        for(int i = 1; i <= num; i++) {
            if(num % i == 0) System.out.print(i+" ");
        }
    }

    // Optimised Approach: O(sqrt(n))
    static void findFactors2(int num) {
        for(int i = 1; i * i <= num; i++) {
            if(num % i == 0) {
                if(num / i == i) {
                    System.out.print(i+" ");
                    break;
                }
                System.out.print(i+" "+(num / i)+" ");
            }
        }
    }

    static void findFactors3(int num) {
        if(num == 0) return;
        ArrayList<Integer> laterFactors = new ArrayList<>();
        for(int i = 1; i * i <= num; i++) {
            if(num % i == 0) {
                if(num / i == i) {
                    System.out.print(i+" ");
                    break;
                }
                System.out.print(i+" ");
                laterFactors.add(num / i);
            }
        }
        for(int i = laterFactors.size() - 1; i >= 0; i--) {
            System.out.print(laterFactors.get(i)+" ");
        }
    }
}
