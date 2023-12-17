package _2_Implementation.Maths.Factors_Multiples;

import _2_Implementation.FunctionsAndMethods.Shadowing;

import java.util.Arrays;

public class PrimeNumAdvanced {
    public static void main(String[] args) {
        int num = 1097;
        System.out.println(findIfPrime(num));
        findPrimesInRange(num);
        optPrimesInRange(num);
    }

    static boolean findIfPrime(int num) {
        if(num < 2) return false;
        int fact = 2;
        while(fact * fact <= num) {
            if(num % fact == 0) return false;
            fact++;
        }
        return true;
    }

    // Naive Approach of finding primes in range: (Iterating through all numbers)
    // Time Complexity: O(n * sqrt(n))
    static void findPrimesInRange(int end) {
        System.out.println("Naive Approach: ");
        int primeInLine = 0;
        for(int i = 0; i <= end; i++) {
            if(findIfPrime(i)) {
                System.out.print(i+" ");
                primeInLine++;
            }
            if(primeInLine == 30) {
                System.out.println();
                primeInLine = 0;
            }
        }
    }

    // Optimised Approach: Time is optimised but Space required for managing Array
    // This is also called Sieve of Eratosthenes
    // Time Complexity: O(n * log(log(n))), Can be proved by using Harmonic Progression & Taylor Series
    static void optPrimesInRange(int end) {
        System.out.println("\n\nOptimised Approach: ");
        boolean[] isPrime = new boolean[end + 1];
        // Arrays.fill(isPrime, true); // The following is to be used if we want the array initialize with all true values.
        // If above line is uncommented, we also require to change the !isPrime[] check to isPrime[] (conversion Flip)
        int primeInLine = 0;
        for(int i = 2; i * i <= end; i++) { // Will run while square of 'i' lies inside the range
            if(!isPrime[i]) {
                for(int j = i * i; j <= end; j += i) { // Will start checking from that square of 'i' for every multiple of 'i'
                    isPrime[j] = true;
                }
            }
        }
        for(int i = 2; i <= end; i++){
            if(primeInLine == 30) {
                primeInLine = 0;
                System.out.println();
            }
            if(!isPrime[i]) {
                primeInLine++;
                System.out.print(i+" ");
            }
        }
    }
}
