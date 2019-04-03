package com.gameofelte.server;

import com.gameofelte.game.Game;
import com.gameofelte.services.IClientService;
import com.gameofelte.services.IGameService;
import com.gameofelte.services.IClientManagerService;
import com.gameofelte.util.Configuration;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class GameServer extends Thread implements IClientManagerService
{
    private final ServerSocket server;
    private final List<Socket> clientList;
    private final int playerCount;
    private final Queue<Message> messageQueue;
    private final IGameService game;
    private List<IClientService> clients;
    
    public GameServer(Configuration config,int timeout) throws IOException
    {
        messageQueue = new LinkedBlockingQueue<>();
        server = new ServerSocket(Integer.parseInt(config.get("port")));
        clientList = new ArrayList<>();
        playerCount = Integer.parseInt(config.get("players"));
        server.setSoTimeout(timeout);
        game = new Game(this,playerCount);
    }
    
  
    @Override
    public void run()
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
                clearClosedClients();
                if(clientList.size() == 0)
                {
                    break;
                }
            }
            catch(IOException e){}
        }
    }
    
    private void clearClosedClients()
    {
        List<Socket> toRemove=new ArrayList();
        for (Socket s :clientList)
        {
            if (s.isClosed()){
                toRemove.add(s);
            }
        }
        for (Socket s : toRemove)
        {
            clientList.remove(s);
        }
    }
    
    private void groupSockets()
    {
        if(clientList.size() == playerCount)
        {
            boolean start = true;
            for(int i = 0; i < clientList.size(); i++)
            {
                if(clientList.get(i).isClosed())
                {
                    start = false;
                    clientList.remove(i);
                    i--;
                }
            }
            if(start)
            { 
                //TODO játék szerver indítása
                startGame();
            }
        }
    }
    
    private void startGame()
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
        List<IClientService> services = new ArrayList<>();
        int i = 0;
        for (Socket s : clientList)
        {
            try {
                ClientThread thread = new ClientThread(s, this);
                thread.start();
                services.set(i, thread);
                services.get(i).sendColor(i);
                i++;
            } catch (IOException ex) {}
        }
        return services;
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
    
        @Override
    public void beginLearnSubject(int playerIndex) {
        clients.get(playerIndex).beginLearnSubject();
    }

    @Override
    public void beginWorkOrStudyChoice(int playerIndex) {
        clients.get(playerIndex).beginWorkOrStudyChoice();
    }

    @Override
    public void beginCourseRequest(int playerIndex) {
        clients.get(playerIndex).beginCourseRequest();
    }

    @Override
    public void beginLosingKnowledge(int playerIndex) {
       clients.get(playerIndex).beginLosingKnowledge();
    }

    @Override
    public void beginOfferedMark(int playerIndex) {
        clients.get(playerIndex).beginOfferedMark();
    }

    @Override
    public void beginMatekingChoice(int playerIndex) {
        clients.get(playerIndex).beginMatekingChoice();
    }

    @Override
    public void beginOvertimeWork(int playerIndex) {
        clients.get(playerIndex).beginOvertimeWork();
    }

    @Override
    public void beginUnregisterSubject(int playerIndex) {
       clients.get(playerIndex).beginUnregisterSubject();
    }
}
