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
        // try {
  
            // Create a file object
            File f = new File(args[0]);
  
            // Get all the names of the files present in the given directory.
            File[] files = f.listFiles();
  
            System.out.println("Files are:");
            
            TextStats text = new TextStats();

            String[] names = new String[files.length];
                for (int i = 0; i < files.length; i++) {
                names[i] = files[i].getName();
                System.out.println(names[i]);
                text.process(names[i]);
                }

    }
}
