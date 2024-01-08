package _2_Implementation.OOP._6_Generics_N_More;

import java.util.ArrayList;

public class ExceptionHandling {
    /*
        Errors vs Exceptions:

        - Errors are caused due to lack of resources, and we cannot resolve them by writing some more code
        e.g(Stack Overflow) i.e. we cannot increase the number of locally available resources
        - Exceptions prevent the normal flow of the program, and we can check for these things and handle
        it using extra code for these cases. e.g(Divide By Zero, Null Pointer)

        Throwable Class:

        The 'Throwable' Class handles Exceptions and Errors in Java.
        Errors can be any type of lack of resource that occurs at runtime for which the 'Throwable' Class will
        display appropriate messages respectively

        Object --- Throwable
                    |
                    |_________ Exceptions --- Checked
                    |             |
                    |             |---------- Unchecked (RuntimeException)
                    |
                    |_________ Errors

        Exceptions can be of 2 types
            i) Checked -> Exceptions that are detected at compile time
            ii) Unchecked -> Exceptions that are encountered at run time

     */
    public static void main(String[] args) {
        // We can use the 'try-catch' blocks to detect and handle exceptions at runtime
        int a = 100, b = 0;
        try {
            int c = a / b; // note that 'c' is inside block scope of 'try' and cannot be accessed outside
        }
        catch (Exception e) {
            System.out.println("Pre-defined message for the exception, as detected by try-catch: \n"+e.getMessage());
            System.out.println("My Custom Message: \nException!! Cannot Divide by Zero.");
        }
        // Let us see the 'finally' keyword now:
        finally { // used along with try-catch block that contain that will always execute, irrespective of exception
            System.out.println("The division operation is complete.");
        }

        try {
            // Using the same logic as above, but now we throw the exception manually when we detect 'b = 0'
            // that is, even before the division takes place.
            int c = divide(a, b, false);
        } catch (Exception e) {
            // This time we get the 'null' exception because, no value will be returned by the function
            System.out.println(e.getMessage());
        }

        try {
            // writing our own exception message again, but passing it as parameter to constructor:
            int c = divide(a, b, true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Handling multiple exception cases:
        // Note: Stricter Exception classes need to be mentioned first
        ArrayList<Object> objArr = new ArrayList<>();
        objArr.add(4); objArr.add(0); objArr.add(null);
        for(int i = 0; i < objArr.size(); i++) {
            try {
                int c = arrOperation(i, objArr, i);
            } catch (NullPointerException e) {
                System.out.println(e.getMessage());
            } catch(ArithmeticException e) {
                System.out.println(e.getMessage());
            } finally {
                if(i == objArr.size() - 1) System.out.println("Operation Complete");
            }
        }

        // Creating and throwing custom exceptions

        try {
            String[] names = {"Kunal", "Vivek", "Jumbo", "Sufiyan", "Dumbo"};
            for(String name: names) {
                if(name.equals("Sufiyan")) throw new MyException("\nThe String contains my name (Sufiyan).");
                System.out.print(name+" ");
            }
        }
        catch(MyException e) {
            System.out.println(e.getMessage());
            // as 'MyException' extends the 'Exception' class it can now use the getMessage() method
        }
    }

    // The 'throws ArithmeticException' for the method 'divide' is just for indicating that the function
    // might throw an ArithmeticException at runtime.
    static int divide(int a, int b, boolean writeMessage) throws ArithmeticException {
        // Using the 'throw' keyword:
        if(b == 0 && !writeMessage) throw new ArithmeticException();
        else if(b == 0) throw new ArithmeticException("Cannot Divide By Zero");
        return a / b;
    }

    static int arrOperation(int a, ArrayList<?> arrList, int index) throws ArithmeticException, NullPointerException {
        System.out.println(arrList.get(index).toString());
        a /= (Integer) arrList.get(index);
        return a;
    }
}

class MyException extends Exception {
    MyException(String message) {
        super(message); // This passes the message to the Constructor of 'Exception' class
    }
}
