package sg.edu.nus.iss.app;

//ArrayList not used. 
// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;



public class Calculator {
    
    public float getMean(String data){
        
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

    public float getSd(String data){

        float sum = 0f;
        float mean = 0f;
        float sq = 0f;
        float var = 0f;
        float sd = 0f;
        
        //Split string using commas as delimiter and place in arrayNumbers. 
        String[] numbers = data.split(",");

        //Convert string to ArrayList to account for dynamic size. 
        // List<String> numString = new ArrayList<String>();
        // numString = Arrays.asList(numbers);

        float[] arrayNumbers = new float[100];
            for (int i = 0; i < numbers.length; i++ ) {
                arrayNumbers[i] = Float.parseFloat(numbers[i]);
            }
           
            for (int i = 0; i < arrayNumbers.length; i++) {
                sum = sum + arrayNumbers[i];
            }
           
            mean = sum / (arrayNumbers.length);
     
            for (int i = 0; i < arrayNumbers.length; i++) {
                var
                = (float) (var + Math.pow((arrayNumbers[i] - mean), 2));
            }
       
        sq = var / arrayNumbers.length;
        sd = (float) Math.sqrt(sq);
        return sd;
     
    }
}
