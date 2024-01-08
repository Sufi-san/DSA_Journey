package _2_Implementation.OOP._6_Generics_N_More;

import java.util.ArrayList;
import java.util.List;

public class WildCards_N_Bounds {
    /*
        Wildcards are special symbols used with generic types to provide flexibility and type safety when working with
        unknown types or collections of different types

        Bounds define constraints on type parameters within generic classes and methods, while wildcards offer
        flexibility when using those generic types in various scenarios.
     */
    public static void main(String[] args) {
        List<Object> objList = new ArrayList<>();
        List<Integer> intList = new ArrayList<>();
        List<Double> doubList = new ArrayList<>();
        List<String> strList = new ArrayList<>();

        for(int i = 0; i < 10; i++) {
            intList.add(i);
            doubList.add(i + .0);
            strList.add("str" + i);
            objList.add("Obj" + i); objList.add(i);
        }

        // sumNums(objList); OR sumNums(strList) will return error as they are not child classes of 'Number'
        sumNums(intList); sumNums(doubList);

        // addNums(strList); OR addNums(doubList) will return error as they are not parent classes of 'Integer'
        addNums(objList); addNums(intList);

        // will work for every type of list as the 'WildCard' is unbounded for the method
        printList(objList); printList(intList); printList(doubList); printList(strList);
     }

    // Example of Upper-bounded Wildcard usage:
    static void sumNums(List<? extends Number> numList) {
        // Now we know that all objects inside the list are of child classes of 'Number' thus we can use
        // 'Number' class type to refer to them, and we can pass Integer, Float, Long, Double Lists.
        double sum = 0;
        for(Number num: numList) sum += num.doubleValue();
        System.out.println("Sum of all Numbers: "+sum);
    }

    static void addNums(List<? super Integer> mainList) {
        // Now we know that all objects inside the list are of parent classes of 'Integer' thus we can
        // pass 'Number' and 'Object' type lists to the function
        for(int i = 0; i < 10; i++) mainList.add(i);
        System.out.println("List after adding numbers: "+mainList);
    }

    static void printList(List<?> list) { // Unbounded can also mean: <? extends Object>
        for(Object obj: list) System.out.print(obj+" ");
        System.out.println();
    }

    static void printNums() {

    }
}
