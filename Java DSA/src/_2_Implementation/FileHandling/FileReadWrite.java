package _2_Implementation.FileHandling;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

import static java.nio.charset.StandardCharsets.UTF_8;

public class FileReadWrite {
    public static void main(String[] args) throws IOException {
        /*
            Note:
            We can specify all the resources we have opened/used by initializing all the objects using the
            resources, in the '()' circle brackets of the try block.
            The later statements that handle the instructions and the process using these objects can then
            be separately entered into the '{}' curly bracket scope of the try block.
        */

        // Java allows handling of input and output using 'ByteStream' and 'CharacterStream'
        // 'ByteStream' implements input/reading using the InputStream class and output/writing using the OutputStream class
        // 'CharacterStream' implements input/reading using the Reader and output/writing using the Writer classes
        // ByteStream handles 'byte' data while CharacterStream directly handles 'character' data
        // ByteStream class names end with 'Stream' and CharacterStream classes names end with 'Reader/Writer'.

        String newFileDir = "src/_2_Implementation/FileHandling/";

        try(InputStreamReader isr = new InputStreamReader(System.in);
            Scanner in = new Scanner(new FileInputStream(newFileDir + "Test"));
            FileInputStream fis = new FileInputStream(newFileDir + "Test");
            OutputStream os = new FileOutputStream(newFileDir + "NewFile.txt");
            FileReader fr = new FileReader(newFileDir + "NewFile.txt");
            BufferedReader br = new BufferedReader(new FileReader(newFileDir + "NewFile.txt"));
            FileWriter fw = new FileWriter(newFileDir + "NewFile2.txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(newFileDir + "NewFile3.txt"));
            FileWriter fw2 = new FileWriter(newFileDir + "NewFile3.txt", true);
            BufferedWriter bw2 = new BufferedWriter(fw2)
            ) {
            // Using ByteStream -> InputStream -> InputStreamReader for taking keyboard input instead of Scanner class
        /*
            Though all ByteStream based class names end with 'Stream', InputStreamReader does not.
            Reason being that 'InputStreamReader' acts as a bridge between byte and character data.

            Byte Stream:
                User types on the keyboard, and the system converts the keystrokes into a sequence of bytes
                representing the pressed keys.
            Character Encoding:
                InputStreamReader takes those bytes and interprets them based on the specified
                character encoding. This involves mapping the byte sequences to their corresponding Java char values.
                These char values are essentially integers that represent Unicode code points for most basic characters
                or act as the first/second part of a surrogate pair for characters beyond the Basic Multilingual Plane.
            read() Method:
                The read() method of InputStreamReader returns an int value, which is the Java character (char) value
                after character encoding interpretation.
            Character Usage:
                If you need to display the character on the console or manipulate it as a character, you might need to
                explicitly cast the int value obtained from read() to a char type. However, this casting typically
                happens implicitly when assigning the value to a char variable.
         */
            // Here 'System.in' is the 'InputStream' variable for handling keyboard input.
            // It will originally be in byte form but when handled by 'isr' here, we can treat it as
            // a stream of characters.
            System.out.println("Enter input: ");
            do {
                // Reads byte data and Prints the obtained integer as a character by typecasting
                System.out.print((char)isr.read());
            } while(isr.ready());
            System.out.println();
            // The above loop keeps running until all characters currently in the console are read.

            // Using ByteStream -> InputStream -> FileInputStream to read from a file
        /*
             We know that Scanner accepts InputStream objects
             Thus we can use FileInputStream object that extends InputStream and pass it to the scanner
             Now the Scanner can be used with all its methods to read the file
         */
            while(in.hasNext()) {
                System.out.println(in.nextLine());
            }
            System.out.println();

            // We can also directly use FileInputStream object to read file data without using Scanner
        /*
            Since everything is converted to 'byte' form when dealing with Byte Stream classes,
            FileInputStream always reads the file in 'byte' format.
            We can obtain a byte array for the whole of the file content using the 'readAllBytes()'
            method which generates a byte array by reading all characters inside the file as a 'byte'
            and then storing them inside an array.
            We can then use this byte[] array and loop over it while typecasting each byte element
            to a character and thus, read the whole file.
            Alternatively, we can also use String() constructor, where we pass the byte array as well
            as the required encoding and create a new String object that contains all the file content
         */
            byte[] arr = fis.readAllBytes();
            // for(byte b: arr) System.out.print((char)b);
            System.out.println(new String(arr, UTF_8) + "\n\n");

            // Using ByteStream -> OutputStream -> FileOutputStream to create and write to a new file
        /*
            Since it operates on bytes, we need to create a byte array to store our text input
            and use the getBytes() method on our text input to get its byte array form
            We then insert this byteArray as a parameter to the .write() method to finally
            write to our file.
         */
            String content = """
                        File's First Line
                        File's Second Line
                        File's Third Line
                        File's Fourth Line""";
            byte[] byteArr = content.getBytes();
            System.out.println(Arrays.toString(byteArr));
            os.write(byteArr);
            System.out.println("Successfully wrote content to file.");

            // Using CharacterStream -> Reader -> InputStreamReader -> FileReader to read files
            // Also, CharacterStream -> Reader -> BufferedReader
        /*
            About FileReader:
                Proper way to access the content of text files
                We know that InputStreamReader acts as a bridge between Byte and Character Streams.
                The FileReader class extends InputStreamReader class and actually makes use of this
                property for reading data, storing and displaying data in character format.
            Methods:
            i) read() -> reads a single character (will return an integer that will be ASCII for that character)
            ii) ready() -> tells whether stream is ready to be read.

            About BufferedReader: The best way to read from text files when paired with a FileReader object
            Methods:
            i) read(), ready() -> (same functioning as FileReader)
            ii) readLine() -> reads a complete line from the selected file and pointer moves to next line

            Looping through the file lines:
            Using ((line = br.readLine()) != null) vs (br.ready()) ->
                While ready() might seem similar in some cases with single characters, it's not ideal for a
                loop condition in line-by-line reading.
                This is because a single character doesn't guarantee a complete line is available.
            Conclusion ->
                Stick with br.readLine() != null for loop conditions in line-by-line reading with
                BufferedReader.
                It's the recommended approach due to its clear semantics and guaranteed behavior of returning
                complete lines or null when finished.
         */
            while(fr.ready()) {
                System.out.print((char)fr.read());
            }
            System.out.println("\n");
            String line;
            while((line = br.readLine()) != null ) {
                System.out.println(line);
            }
            // Using CharacterStream -> Writer -> OutputStreamWriter -> FileWriter
            // Also, CharacterStream -> Writer -> BufferedWriter
        /*
            For writing text data to a file in Java, using a BufferedWriter wrapped around a FileWriter
            is generally considered better than using FileWriter directly.

            OutputStreamWriter:
                It's a character-oriented output stream class.
                It takes character data as input.
                Internally, it converts the characters into bytes based on a specified character encoding (like UTF-8).
                It then writes these encoded bytes to the underlying output stream (which typically operates on bytes).
                So, OutputStreamWriter acts as a bridge between character data and encoded byte data, facilitating
                the writing of character information to byte-oriented streams. The character encoding defines how
                the characters are translated into bytes.
                The 'FileWriter' subclass inherits all of its methods from this class.

            FileWriter:
                Writes characters directly to a file.
                Offers basic functionalities for writing characters and strings.
                Not ideal for frequent small writes, as each write involves system calls
                which can be inefficient.

            BufferedWriter:
                Buffers data internally before writing it to the underlying stream (usually a FileWriter).
                Improves performance by reducing the number of system calls, especially for writing small
                chunks of data frequently.
                Provides additional convenience methods like newLine() for writing newlines.
         */
            String content2 = """
                    Second File's First Line
                    Second File's Second Line
                    Second File's Third Line
                    Second File's Fourth Line""";
            // Using .write() that accepts String argument to write into the file
            fw.write(content2 + "\n");
            // Trying to write line-by-line using loop, appending a linebreak required when maintaining simplicity
            String[] strArr = content2.split("\n");
            for(String str: strArr) fw.write(str + "\n");

            // BufferedWriter uses the same .write() method for String arguments, it is inherited from 'Writer' class
            String content3 = """
                    Third File's First Line
                    Third File's Second Line
                    Third File's Third Line
                    Third File's Fourth Line""";
            bw.write(content3);
            // Line-by-line input using newLine()
            String[] strArr2 = content3.split("\n");
            for(String str: strArr2) {
                bw.newLine();
                bw.write(str);
            }
            bw.flush(); // Important Step!!
            // Above step is required to reset file pointer and cache so that the next BufferedWriter
            // object can successfully make changes to the same file.

            // Appending to file using a different constructor for FileWriter(with append = true) object:
            bw2.newLine();
            bw2.write("(This is appended content) New Content has successfully been added to the file.");

            // For fast I/O we use: BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
