package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DummyClient extends Thread {
    
    @Override
    public void run()
    {
            try(
                Socket s = new Socket("localhost", 12345);
                PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
                //Scanner sc = new Scanner(s.getInputStream());
            )
            {	
                pw.println("test");
                /*
                while (true)
                {
                    String msg=sc.nextLine();
                }
                */
                try {
                    sleep(2);
                } catch (InterruptedException ex) 
                {
                    Logger.getLogger(DummyClient.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (IOException ex) { System.err.println(ex);}
            
    }
    
}
