package _2_Implementation.OOP._6_Generics_N_More;

import java.util.ArrayList;
import java.util.function.Consumer;

public class LambdaFunctions {
    // Lambda Functions are similar to the anonymous/arrow functions of JavaScript
    /*
        Based on the type of these functions, we can store then in variables of certain class type.
        Lambda Functions can also be passed as arguments.
     */
    public static void main(String[] args) {
        // Example of lambda function:
        Consumer<int[]> print = (int[] arr) -> {
            for(int item: arr) System.out.print(item+" ");
        };
        // Using the lambda function with the help of 'accept()' method of Consumer class
        int[] arr = {3, 4, 5, 6};
        print.accept(arr);
        System.out.println();

        // Another Example of lambda functions:
        ArrayList<Integer> aL = new ArrayList<>();
        for(int item: arr) aL.add(item);
        aL.forEach((item) -> System.out.print((item + 1)+" "));
        // In above case, we pass a lambda function of 'Consumer' type to '.forEach()' method pre-defined
        // for objects of ArrayList class.

        // Creating our own version of Lambda function:
        // By this example, we can also understand that the 'class type' for the function is actually
        // the 'interface' name that consists of the abstract method.
        // The body for this abstract method is what we define while creating the function
        ArrayList<Integer> intAL = new ArrayList<>();
        ArrayList<Integer> intAL2 = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            intAL.add(i * (1 << i + 2));
            intAL2.add(i * intAL.get(i));
        }
        System.out.println("\nInitial Lists:");
        System.out.println(intAL);

        // Creating different lambda functions:
        ArrayOperator<Integer> opOnIntArr1 = (ArrayList<Integer> list, int num) -> {
            for(int i = 0; i < list.size(); i++) {
                list.set(i, list.get(i) + num);
                list.set(i, list.get(i) * num);
            }
        };
        ArrayOperator<Integer> opOnIntArr2 = (ArrayList<Integer> list, int num) -> {
            for(int i = 0; i < list.size(); i++) {
                list.set(i, list.get(i) * num);
                list.set(i, list.get(i) - num);
            }
        };
        ArrayOperator<Integer> opOnIntArr3 = (ArrayList<Integer> list, int num) -> {
            if(num == 0) return;
            for(int i = 0; i < list.size(); i++) {
                list.set(i, list.get(i) / num);
                list.set(i, list.get(i) + num);
            }
        };

        // passing different lambda functions along with other data as arguments
        operateOnAL(intAL, 10, opOnIntArr1);
        operateOnAL(intAL2, 20, opOnIntArr1);
        System.out.println("\nAfter first operation: ");
        System.out.println(intAL+"\n"+intAL2);

        operateOnAL(intAL, 20, opOnIntArr2);
        operateOnAL(intAL2, 10, opOnIntArr2);
        System.out.println("\nAfter second operation: ");
        System.out.println(intAL+"\n"+intAL2);

        operateOnAL(intAL, 10, opOnIntArr3);
        operateOnAL(intAL2, 20, opOnIntArr3);
        System.out.println("\nAfter third operation: ");
        System.out.println(intAL+"\n"+intAL2);
    }

    // using the interface type as the parameter for lambda function
    static void operateOnAL(ArrayList<Integer> list, int num, ArrayOperator<Integer> op) {
        op.arrOperation(list, num);
    }
}

interface ArrayOperator<T extends Number> {
    void arrOperation(ArrayList<T> list, int num);
}
