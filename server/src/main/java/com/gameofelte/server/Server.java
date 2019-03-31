package com.gameofelte.server;

import com.gameofelte.util.Configuration;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Server
{
    private final ServerSocket server;
    private final List<Socket> clientList;
    private final int playerCount;
    
    public Server(Configuration configuration) throws IOException
    {
        server = new ServerSocket(Integer.parseInt(configuration.get("port")));
        clientList = new ArrayList<>();
        playerCount=Integer.parseInt(configuration.get("players"));
        server.setSoTimeout(300000);
    }
    
    public void listen()
    {
        while(true)
        {
            try(Socket socket = server.accept())
            {
                clientList.add(socket);
                try(Scanner sc = new Scanner(socket.getInputStream()))
                {
                    System.out.println(sc.nextLine());
                }
                
                groupSockets();
            }
            catch(SocketTimeoutException e) 
            {
                if(clientList.size() == 0)
                {
                    break;
                }
            }
            catch(IOException e){}
        }
    }
    
    private void groupSockets()
    {
        if(clientList.size() == playerCount)
        {
            boolean l = true;
            for(int i = 0; i < clientList.size(); i++)
            {
                if(clientList.get(i).isClosed())
                {
                    l = false;
                    
                    clientList.remove(i);
                    i--;
                }
            }
            
            if(l)
            { 
                //TODO játék szerver indítása
            }
        }
    }
    
    
}