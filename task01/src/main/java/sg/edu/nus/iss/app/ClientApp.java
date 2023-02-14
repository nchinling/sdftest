package sg.edu.nus.iss.app;

import java.io.Console;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;


import static sg.edu.nus.iss.app.Calculator.*;

public class ClientApp {
    public static void main(String[] args){
        
        String name = "Ng Chin Ling";
        String email = "nchinling@gmail.com";
       
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
                ObjectInputStream ois = new ObjectInputStream(dis);

                // Write and response
                OutputStream os = sock.getOutputStream();
                DataOutputStream dos = new DataOutputStream(os);
                ObjectOutputStream oos = new ObjectOutputStream(dos);
              
                //Read data from server. 
                String numbersFromServer = ois.readUTF();
                System.out.printf("The numbers are %s\n", numbersFromServer);
               
                //to verify that the string are valid characters. 
                for (int i = 0; i < numbersFromServer.length(); i++) {
                    if (Character.isDigit(numbersFromServer.charAt(i)) || numbersFromServer.charAt(i) == '.' || numbersFromServer.charAt(i) == ',' )  
                    {
                    continue;
                    }
                else{dos.writeUTF("Error. They are not entirely numbers.");}
                
                Calculator calc = new Calculator();
                //Method is in Calculator class in Calculator.java
                double mean = calc.getMean(numbersFromServer);
                double sd = calc.getSd(numbersFromServer);

                //send to server
                oos.writeUTF(name);
                oos.flush();
                oos.writeUTF(email);
                oos.flush();

                //convert mean to string to be sent to server.
                String meanString = String.valueOf(mean);
                oos.writeUTF("Received mean: " + meanString);
                oos.flush();

                //convert sd to string to be sent to server.
                String sdString = String.valueOf(sd);
                oos.writeUTF("Received standard deviation: " + sdString);
                oos.flush();

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

