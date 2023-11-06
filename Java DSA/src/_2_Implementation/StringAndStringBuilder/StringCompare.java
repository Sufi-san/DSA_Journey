package _2_Implementation.StringAndStringBuilder;

public class StringCompare {
    public static void main(String[] args) {  // Command-line arguments are stored in 'args' which is a String type array.
        // These command line arguments consist of 'java', 'javac' etc. (Not clearly understood by me yet...)
        String a = "Sufiyan";
        String b = "Sufiyan";  // We know both variables are pointing to same object.

        // Proof: '=='
        System.out.println(a == b);

        /* Comparison of Strings:
        1) '==' method: when both variables are pointing to same object in String pool only then it
            returns true, else even if the characters are same but the objects are different, it returns
            false.
            Here '==' checks both values and whether variables point to same object.
        2) .equals method: when we do not want to check whether variables are pointing to same object
            and only their value needs to be checked, '.equals' method should be used.
            All pre-defined java objects have a .equals() method.
         */

        // Creating different objects of same values:
        String c = new String("Sufiyan");  // The value is now created outside StringPool but in heap.
        System.out.println(a == c);  // This returns false as both variables do not point to same object.
        System.out.println(a.equals(c));  // This will return true as we use .equals method to just check value.

        // Even though we imagine Strings as character arrays, we cannot simply do the following:
        // System.out.println(a[0]);  this will return an error, instead of this if we just want to
        // get character via index, we use the 'charAt()' method:
        System.out.println(a.charAt(0)); // This will print single character at zeroth index.
    }
}
