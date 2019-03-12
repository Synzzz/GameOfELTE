package com.gameofelte.server;

import com.gameofelte.util.Configuration;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server
{
    private final ServerSocket server;
    private final List<Socket> clientList;
    
    public Server(Configuration configuration) throws IOException
    {
        server = new ServerSocket(Integer.parseInt(configuration.get("port")));
        clientList = new ArrayList<>();
    }
    
    public void listen()
    {
        while(true)
        {
            try
            {
                try(Socket socket = server.accept())
                {
                    clientList.add(socket);
                    
                    groupSockets();
                }
            }
            catch(IOException e) { }
        }
    }
    
    private void groupSockets()
    {
        if(clientList.size() == 6)
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