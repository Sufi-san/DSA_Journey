package _2_Implementation.FunctionsAndMethods;

public class Scoping {
    public static void main(String[] args) {
        // Scope basically means where we can access our variables
        // 1.Method Scope
        int a = 23; // can only be accessed in main function
        // Note: int a = (anything) will give error, as the same variable cannot be initialized again in the same
        //       function. It can however be changed or modified like: a = (anything)
        System.out.println(a);
        func();

        /* 2.Block Scope {}
            variables that are initialized in a block will remain inside the block and cannot be accessed outside of it
            variables that are initialized outside the block can be accessed and changed inside the block, but cannot be initialized again.
            variables that are changed inside the block will also reflect the same change outside.
            variables that are initialized inside the block can be initialized again outside the block.
         */
        {
            System.out.println(a);
            a = 44;  // 'a' is now changed for the whole main method
            int c = 45;  // cannot be accessed outside but another 'c' variable can be initialized outside the scope.
            System.out.println(c);
        }
        int c = 46;
        System.out.println(c);
        System.out.println(a);

        /* 3.Loop Scope
            Same as Block Scope
         */
        for(int i = 0; i < 5; i++){
            a += 5;
            int d = a;  // this variable cannot be accessed outside the for loop but can be initialized.
            System.out.println(d);
        }
        // System.out.println(d); will give error, the same is true for 'i'
        System.out.println(a);  // value of 'a' is now updated
    }

    static void func(){
        int num = 34; // can only be accessed in func() ... (Method Scope)
        System.out.println(num);
    }
}
