package sg.edu.nus.iss.app;

import java.io.Console;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import static sg.edu.nus.iss.app.Calculator.*;



public class ClientApp {
    public static void main(String[] args){
        
        // String[] arrSplit = args[0].split(" ");
        String serverName = args[0];
        String serverPort = args[1];
        // System.out.println(arrSplit[0]);
        // System.out.println(arrSplit[1]);
        try{
            while(true){
                
    
                Socket sock = new Socket(serverName
                    , Integer.parseInt(serverPort));
                System.out.printf("Client started on %s at port %s\n", serverName, serverPort);
            
                // Get the input data from the server program
                InputStream is = sock.getInputStream();
                DataInputStream dis = new DataInputStream(is);

                // Write and response
                OutputStream os = sock.getOutputStream();
                DataOutputStream dos = new DataOutputStream(os);
                
                //Read data from server. 
                String numbersFromServer = dis.readUTF();
               
                //to verify that the string are valid characters. 
                for (int i = 0; i < numbersFromServer.length(); i++) {
                    if (Character.isDigit(numbersFromServer.charAt(i)) || numbersFromServer.charAt(i) == '.' || numbersFromServer.charAt(i) == ',' )  
                    {
                    continue;
                    }
                else{dos.writeUTF("Error. They are not entirely numbers.");}
                

                //Method is in Calculator class. Need to convert result to double.
                double mean = getMean(numbersFromServer);

                for(int j = 0; j<double.length; j++)
                {
                    System.out.println(double[j]);
                } 

                //     System.out.println("It works here1.\n");
                //     int[] result = getNumSort(numbersFromServer);

                //     System.out.println("It works here2.\n");
                //     for(int i = 0; i<result.length; i++)
                //     {
                //         System.out.println(result[i]);
                //     } 

                String response = dis.readUTF();
                if(response.contains("Sorted result is")){
                    String[] numberValArr = response.split("_");
                    System.out.printf("The server returned %s\n",numberValArr[1]);

                }else{
                    System.err.println(response);
                }


                dos.writeUTF(response);
                dos.flush();

                is.close();
                os.close();
                sock.close();

            }

        }
                
                
    
        } catch(UnknownHostException e){
            e.printStackTrace();
        }catch(NumberFormatException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

