package com.gameofelte.server;

import com.gameofelte.services.IClientService;
import com.gameofelte.services.IGameService;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.gameofelte.services.IClientManagerService;

public class GameServer extends Thread implements IClientManagerService
{
    private final int port;
    private final int clientCount;
    private final Queue<Message> messageQueue;
    private final IGameService game;
    private List<IClientService> clients;
    
    public GameServer(int port, int clientCount, IGameService game) throws IOException
    {
        this.port = port;
        messageQueue = new LinkedBlockingQueue<>();
        this.clientCount = clientCount;
        this.game = game;
    }
    
    @Override
    public void run()
    {
        clients = connectClients();
        
        game.start();
        
        while(!game.isOver())
        {
            processMessage(messageQueue.poll());
        }
        
        for(IClientService client : clients)
            client.close();
    }
    
    private List<IClientService> connectClients()
    {
        try(ServerSocket server = new ServerSocket(port))
        {
            List<IClientService> services = new ArrayList<>(clientCount);
            
            for(int i = 0; i < clientCount; i++)
            {
                Socket socket = server.accept();
                ClientThread thread = new ClientThread(socket, this);
                thread.start();
                
                services.set(i, thread);
                services.get(i).sendColor(i);
            }
            
            return services;
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(GameServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public void addMessage(Message msg)
    {
        messageQueue.add(msg);
    }
    
    private void sendMessageToAll(Message msg)
    {
        for(IClientService client : clients)
            client.sendMessage(msg);
    }
    
    //TODO targyfelvetel commandok
    private void processMessage(Message msg)
    {
        int senderIndex = getSenderIndex(msg);
        boolean senderIsActive = senderIndex == game.getActivePlayerIndex();
        Response response;
        
        try
        {
            switch(msg.getCommand())
            {
                case "END_TURN": if(!senderIsActive) throw new Exception("Nem te vagy a soron"); game.nextPlayer(); break;
                case "MSG": sendMessageToAll(msg); break;
                case "STEP": if(!senderIsActive) throw new Exception("Nem te vagy a soron"); game.setPlayerField(Integer.parseInt(msg.getData())); break;
                case "PICK_LUCKY_CARD": if(!senderIsActive) throw new Exception("Nem te vagy a soron"); game.pickLuckyCard(Integer.parseInt(msg.getData())); break;
                case "USE_LUCKY_CARD": if(!senderIsActive) throw new Exception("Nem te vagy a soron"); game.useLuckyCard(Integer.parseInt(msg.getData())); break;
                case "GET_LUCKY_CARDS": clients.get(senderIndex).sendLuckyCards(game.getLuckyCards()); break;
                case "GET_BOARD": clients.get(senderIndex).sendBoard(game.getFields()); break;
            }
            
            response = new Response(ResponseType.OK);
        }
        catch(Exception e)
        {
             response = new Response(ResponseType.ERROR, e.getMessage());
        }
        
        clients.get(senderIndex).sendResponse(response);
    }
    
    private int getSenderIndex(Message msg)
    {
        int i = 0;
        boolean l = false;
        
        while(i < clients.size() && !l)
        {
            if(clients.get(i).getSocket() == msg.getSender())
                l = true;
            else 
                i++;
        }
        
        return i;
    }

    @Override
    public void sendRandomNumbersToAll(List<Integer> numbers) 
    {
        for(IClientService client : clients)
            client.sendRandomNumbers(numbers);
    }

    @Override
    public void activatePlayer(int playerIndex) 
    {
         clients.get(playerIndex).activate();
    }

    @Override
    public void showSubjectRegistrationWindow(int playerIndex) 
    {
        clients.get(playerIndex).showSubjectRegistrationWindow();
    }

    @Override
    public void sendGameOver(List<Integer> scoreboard) 
    {
        for(IClientService client : clients)
            client.sendGameOver(scoreboard);
    }

    @Override
    public void setMoney(int playerIndex, int money) 
    {
        clients.get(playerIndex).setMoney(money);
    }
}
