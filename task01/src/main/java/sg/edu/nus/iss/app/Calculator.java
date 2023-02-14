package sg.edu.nus.iss.app;

//ArrayList not used. 
// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;



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
            double mean = (double)Math.floor(sum / count);
     
            // Returns mean of array
            return mean;
       
    }

    public double getSd(String data){

        double sum = 0.0;
        double mean = 0.0;
        double sq = 0.0;
        double var = 0;
        double sd = 0;
        
        //Split string using commas as delimiter and place in arrayNumbers. 
        String[] numbers = data.split(",");

        //Convert string to ArrayList to account for dynamic size. 
        // List<String> numString = new ArrayList<String>();
        // numString = Arrays.asList(numbers);

        double[] arrayNumbers = new double[100];
            for (int i = 0; i < numbers.length; i++ ) {
                arrayNumbers[i] = Double.parseDouble(numbers[i]);
            }
           
            for (int i = 0; i < arrayNumbers.length; i++) {
                sum = sum + arrayNumbers[i];
            }
           
            mean = sum / (arrayNumbers.length);
     
            for (int i = 0; i < arrayNumbers.length; i++) {
                var
                = var + Math.pow((arrayNumbers[i] - mean), 2);
            }
       
        sq = var / arrayNumbers.length;
        sd = Math.sqrt(sq);
        return sd;
     
    }
}
