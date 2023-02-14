package myapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class TextStats {
    
    private String filename;

    public TextStats(){}

    public TextStats(String filename){
        this.filename = filename;
    }

    public String getFilename() {return filename;}

    public void setFilename(String filename) {this.filename = filename;}

    public void process(String filename) throws FileNotFoundException, IOException{

        Path p = Paths.get(filename);
        File f = p.toFile();

        //String {key} : Integer {value}
        Map<String, Integer> wordFreq = new HashMap<>();

        // Open a file as input stream
        InputStream is = new FileInputStream(f);
        // Convert the input stream to a reader byte -> char (2 bytes)
        InputStreamReader isr = new InputStreamReader(is);
        // Read whole lines
        BufferedReader br = new BufferedReader(isr);
        String line;
        int numWords = 0;
        while ((line = br.readLine()) != null) {    //store line as strings as a string
            System.out.printf("> %s\n", line.toUpperCase());

            //remove stopwords

            //Remove stopwords
            line = line.replace("."," ");
            line = line.replace(","," ");
            line = line.replace(":"," ");
            line = line.replace("!"," ");
            line = line.replace("-"," ");
            line = line.replace("()"," ");
            line = line.replace("{}"," ");
            line = line.replace("'"," ");
            line = line.replace("\"", " ");
            line = line.replace("?", " ");

            //place in String array
            String[] words = line.split(" ");  
            numWords += words.length;

            // Iterate the all the words in the line
            for (String w: words) {
                String t = w.trim().toLowerCase();
                if (t.length() <= 0) {           //if no word, proceed back to for loop to find next word
                    continue;
                }
                if (!wordFreq.containsKey(t)) {
                    // If word is not in map, initialize the word with freq 1
                    wordFreq.put(t, 1);
                } else {
                    // If word is in map, the increment the count
                    int c = wordFreq.get(t);
                    wordFreq.put(t, c + 1);
                }
            }
        }

        // Get a list of all the words and store it in a set. Map.keySet() returns
        // Map.keySet() returns a Set view of the keys contained in this map.
        Set<String> words = wordFreq.keySet();   //store the set of keys in a set

        for (String w: words) {
            int count = wordFreq.get(w);
            System.out.printf(": %s = %d\n", w, count);
        }

        System.out.printf("Hashcode: %d\n", wordFreq.hashCode());

        System.out.printf("Number of words: %d\n", numWords);
        System.out.printf("Number of unique words: %d\n", words.size());
        System.out.printf("Percentage of unique words: %f\n", words.size()/(float)numWords);

        br.close();
        isr.close();
        is.close();
    }

}
