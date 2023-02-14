package myapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Console;
import java.io.File;
import java.util.List;
import java.util.Map;

public class App {
    
    public static void main(String[] args) throws IOException {

        System.out.printf("The programme works\n");

        // BufferedReader br = file.process(args[0]);

        //Use File.listFiles() to read directory of all files. 
        // try-catch block to handle exceptions
        try {
  
            // Create a file object
            File f = new File(args[0]);
  
            // Get all the names of the files present in the given directory.
            File[] files = f.listFiles();
  
            System.out.println("Files are:");
            TextStats text = new TextStats();
  
            // Display the names of the files
            for (int i = 0; i < files.length; i++) {
                System.out.println(files[i].getName());
                // TextStats text = new TextStats();
                // text.process(files[i].getName());
            }
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }

        // TextStats text = new TextStats(args[0]);
        // text.process(args[0]);




    }
}
