package _2_Implementation.Maths.Bitwise;

public class FindUniqueIn3Rep {
    // Here we try to find the unique element, in an array where other elements repeat twice
    public static void main(String[] args) {
        int[] arr = {5, 2, 1, 2, 5, 1, 5, 8, 8, 8, 7, 4, 4, 1, 4, 2};
        int ans1 = findUniqueElem1(arr);
        int ans2 = findUniqueElem2(arr); // does not work for unique element '0'
        System.out.println(ans1+" "+ans2);
    }
    // Approach 1
    static int findUniqueElem1(int[] arr){
        int ans = -1;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                if (i != j && arr[i] == arr[j]) break;
                if (j == arr.length - 1){
                    ans = arr[i];
                    break;
                }
            }
            if(ans != -1) break;
        }
        return ans;
    }

    // Approach 2 Details:
    // Since Binary Conversion traversing through the array for sum takes 'N' time, we get overall O(N * logN) Time Complexity
    // Thus, approach 2 is relatively better than Approach 1 which has O(N*N) Time Complexity
    static int findUniqueElem2(int[] arr){
        int bitSum = 0; // This will store frequency of set bit (1-bit) at each position
        int ans = 0;
        for(int elem: arr){
            bitSum += convertToBinary(elem); // converting elements to binary form and adding the bits, (N * logN)
        }
        int power = 0;
        while(bitSum > 0){
            int lastDigit = bitSum % 10; // get the bit frequency
            if(lastDigit % 3 != 0){
                // if frequency is not a multiple of 3, add current position's power of 2 to answer (to get base 10 form)
                ans += (int) Math.pow(2, power);
            }
            bitSum /= 10; // discard the digit
            power++;
        }
        return ans;
    }

    static int convertToBinary(int num){
        int ans = 0, position = 0;
        while(num > 0){
            int remainder = num % 2;
            ans += remainder * (int) Math.pow(10, position);
            num /= 2;  // This will result in the loop having Time Complexity O(logN)
            position++;
        }
        return ans;
    }
}
