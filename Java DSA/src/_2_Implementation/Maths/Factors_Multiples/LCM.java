package _2_Implementation.Maths.Factors_Multiples;

public class LCM {
    /*
        A common multiple is something that is divisible by all numbers in question
        CM(a, b) = Numbers that are divisible by both 'a' and 'b'
        LCM(a, b) = Least common multiple = min(CM(a, b))

        Did not quite understand the derivation for the formula...

        Final Formula:
        LCM(a, b) = (a * b) / HCF(a, b)
     */
    public static void main(String[] args) {
        int a = 49, b = 343;
        System.out.println(bruteForceLCM(a, b)+"\n");
        System.out.println(formulaicLCM(a, b));
    }

    static int bruteForceLCM(int a, int b) {
        if(a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        int i = 1, j = 1, ans = b;
        while(a * i != b * j) {
            if(a * i > b * j) j++;
            i++;
            if(a * i == b * j) ans = a * i;
        }
        return ans;
    }

    static int formulaicLCM(int a, int b) {return a * b / EuclideanAlgo.iterativeGCD(a, b);}
}
