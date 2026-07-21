package _2_Implementation.FunctionsAndMethods;

public class MethodOverloading {  // Two or more functions of the same name can exist,
    // if the type or number of parameters is different.
    public static void main(String[] args) {
        func(56);
        func("Sufi");
        func("Hello", "Sufiyan");
    }
    static void func(int a){
        System.out.println(a);
    }

    static void func(String s){
        System.out.println(s);
    }

    static void func(String a, String b){
        System.out.println(a+", "+b);
    }
}
