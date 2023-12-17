package _2_Implementation.Maths.Bitwise;

public class RangeXOR {
    public static void main(String[] args) {
        int start = 3, end = 9;
        System.out.println(inRangeXOR(start, end));
    }

    /*
       We know that if 2 same values are XORed, they return 0 and anything XORed with 0 stays the same
       Suppose the range is: 4 ^ 5 ^ 6 ^ 7 ^ 8 ^ 9
       Now using our method we will get: 0 ^ 1 ^ 2 ^ 3 ^ 4 ^ 5 ^ 6 ^ 7 ^ 8 ^ 9
       Here '0 ^ 1 ^ 2 ^ 3' are extra, so we can XOR then AGAIN from the result to cancel them out
       Thus, we apply our same method to get collective XOR from 0 to 3 and then XOR obtained result
       (XOR 0 to 3) from the main result (XOR 0 to 9)
     */
    static int inRangeXOR(int start, int end) {
        int endXOR = 0, startXOR = 0;
        // First using the approach of finding XOR from 0 to 'n' on end.
        if(end % 4 == 0) endXOR = end;
        else if(end % 4 == 1) endXOR = 1;
        else if(end % 4 == 2) endXOR = end + 1; // can also be 'end ^ 1'

        start--; // Because we do not want the starting number of range to be excluded
        if(start % 4 == 0) startXOR = start;
        else if(start % 4 == 1) startXOR = 1;
        else if(start % 4 == 2) startXOR = start + 1;

        return endXOR ^ startXOR;
    }
}
