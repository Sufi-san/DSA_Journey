package _2_Implementation.FileHandling;

import java.io.*;

public class FileClass {
    public static void main(String[] args) throws IOException {
        // Using the File class to create a new file and when to use File or FileWriter to create files
        /*
            Use File.createNewFile() + FileWriter:
                When you need explicit control over file creation and want to avoid overwriting existing files.
                When you need different character encodings for different files.
                When you need to delete a file or perform other search file specific actions.

            Use FileWriter:
                When simplicity is preferred, and you're sure the files don't exist, or you're okay overwriting
                them if they do.
                When you're working with a single character encoding for all files.
         */
        String newFileDir = "src/_2_Implementation/FileHandling/NewFile4.txt";
        File fo = new File(newFileDir);
        if(fo.createNewFile()) readWriteToFile(newFileDir, fo);
        else {
            // fo.delete() will delete existing file if found and return true when successful
            if(fo.delete()) System.out.println("Found and deleted existing file.");
            readWriteToFile(newFileDir, fo);
        }
    }

    static void readWriteToFile(String newFileDir, File fo) throws IOException {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(newFileDir));
            BufferedReader br = new BufferedReader(new FileReader(newFileDir))) {
            System.out.println("File "+fo.getName()+" created successfully.");
            bw.write("Writing to a new file that was originally created using the 'File' class");
            bw.flush(); // Resetting pointer so that 'br' works
            String lineX;
            while((lineX = br.readLine()) != null) System.out.println(lineX);
        }
    }
}
