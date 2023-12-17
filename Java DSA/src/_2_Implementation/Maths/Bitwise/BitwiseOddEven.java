package _2_Implementation.Maths.Bitwise;

public class BitwiseOddEven {
    public static void main(String[] args) {
        int num = 107;
        for(int i = 0; i <= num; i++){
            if((i & 1) == 1){
                System.out.println(i+" is ODD.");
            }
            else System.out.println(i+" is EVEN.");
        }
    }
}
