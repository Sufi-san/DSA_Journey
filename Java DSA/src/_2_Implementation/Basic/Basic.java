package _2_Implementation.Basic;
public class Basic {
    public static void main(String[] args) {
        int t = 10;
        int i = 0;
        // if statement
        if(t == 10){
            System.out.println("Hello World");
        }

        // while loop
        while(i != 10){
            System.out.print(" "+i);
            i++;
        }
        System.out.println();
        // for loop
        for(int count = 1; count < 11; count++){
            System.out.print(" "+count);
        }
    }
}
