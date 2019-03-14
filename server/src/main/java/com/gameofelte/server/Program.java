package com.gameofelte.server;

import com.gameofelte.util.Configuration;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Program 
{
    public static void main(String[] args) 
    {
        try
        {
            Configuration config = new Configuration("server.config");
            Server server = new Server(config);
            server.listen();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error reading config file:\n");
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
