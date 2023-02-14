package sg.edu.nus.iss.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Calculator {
    
    public double getMean(String data){
        
        //Split string using commas as delimiter and place in arrayNumbers. 
        String[] numbers = data.split(",");

        //Convert string to ArrayList to account for dynamic size. 
        // List<String> numString = new ArrayList<String>();
        // numString = Arrays.asList(numbers);

        double[] arrayNumbers = new double[100];
            for (int i = 0; i < numbers.length; i++ ) {
                arrayNumbers[i] = Double.parseDouble(numbers[i]);
            }
        
        //Function to calculate mean. 
        int sum = 0, count = 0;
 
            // To calculate sum and number of elements 
            for (int i = 0; i <= arrayNumbers.length; i++) {
                sum += arrayNumbers[i];
                count++;
            }
     
            // Calculate floor value of mean
            double mean = (int)Math.floor(sum / count);
     
            // Returns mean of array
            return mean;
       
    }
}
