package _2_Implementation.StringBuffer;

import java.util.Arrays;
import java.text.DecimalFormat;

public class Intro {
    /*
        Scenario -
            In some online contests or interview formats, we might get an Input file to test our written
            code and then upload the generated Output too by storing the output inside a file and then
            uploading it.
            These files might consist of thousands of lines and some good formatting might be required
            before operating on them.
            Our aim here is to learn how to format the data and handle large data, specifically strings.

            The possibilities and the amount of functionality provided by the class are almost endless.
            What we will cover here are the basics, and the rest can be googled as per use cases.

        About StringBuffer -
        1. Its object is a mutable sequence of characters (change can be made without new object creation)
        2. More Efficient
        3. Thread Safe:
            Processes in memory are divided into smaller tasks called threads
            These threads can also work concurrently and on same data
            StringBuffer being thread safe means that it does not allow multiple threads to work on same data
            This property also makes it a bit slow.
        4. Comparison with StringBuilder:
            StringBuilder is not thread safe.
            Thus, StringBuffer is safer than StringBuilder but at the same time, StringBuffer is slower too.
     */
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer(); // Constructor 1, simple empty object with default capacity
        sb.append("IAmADev");
        System.out.println(sb.getClass().getSimpleName());
        String str = sb.toString();
        System.out.println(str); // We can also directly use 'sb' for printing, it will call 'toString()' internally

        StringBuffer sb2 = new StringBuffer("Sufisan"); // Constructor 2, Already has a string initialized into it
        System.out.println(sb2);

        StringBuffer sb3 = new StringBuffer(32); // Constructor 3, Initial capacity of character array differs

        // Basically most of the common methods are same as String Builder, but we now have thread safety
        sb.append(" ").append(sb2);
        System.out.println(sb);

        sb.insert(8, "named ");
        System.out.println(sb);

        sb.replace(0, 7, "I am a developer");
        System.out.println(sb);

        sb.delete(5, 17);
        System.out.println(sb);

        sb.reverse();
        System.out.println(sb);

        System.out.println(sb3.capacity()); // Checking initial capacity, should be 32 as mentioned above

        // Using a Random String class made with the help of Random() and StringBuffer() classes
        RandomString rs = new RandomString();
        System.out.println(rs.getRandomString());
        System.out.println(rs.getRandomString(50));
        System.out.println(rs.getRandomAlphaString());
        System.out.println(rs.getRandomAlphaString(50));

        // Removing spaces:
        String str2 = " a  s f  asf q  w2  gf  2  al ";
        sb3.append(str2);
        for(int i = 0; i < sb3.length(); i++) {
            if(sb3.charAt(i) == ' ') {
                sb3.replace(i, i + 1, "");
                i--;
            }
        }
        System.out.println(sb3);
        System.out.println(str2.replaceAll(" ", "")); // Easy method

        // Splitting a string into a character array
        System.out.println(Arrays.toString(sb.toString().split(" ")));

        // Bonus, the DecimalFormat class: Object -> Format -> NumberFormat -> DecimalFormat
        /*
            Using the Decimal Format class, we can specify exactly in which form the number should
            be printed, down to the zeroes before and after the point (.)
            The number of zeroes before the point will either stay in the final print or will be
            replaced if required, by the digits of the actual number
            The number of zeroes after the point determine how many of digit round-offs are necessary
            after the point
         */
        DecimalFormat df = new DecimalFormat("00000.0000"); // <- We mention the decimal format required here
        DecimalFormat df2 = new DecimalFormat("00000.");
        DecimalFormat df3 = new DecimalFormat("0.00");
        System.out.println(df.format(7.89));
        System.out.println(df2.format(7.89));
        System.out.println(df3.format(9.9283));
    }
}
