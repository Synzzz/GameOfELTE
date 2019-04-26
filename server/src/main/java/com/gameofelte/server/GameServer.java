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

/**
 * Class implementing IClientManagerService as a Server
 */
public class GameServer extends Thread implements IClientManagerService
{
    private final ServerSocket server;
    private final ArrayList<Socket> clientList;
    private final int playerCount;
    private final Queue<Message> messageQueue;
    private final IGameService game;
    private ArrayList<IClientService> clients;
    
    /**
     * Constructor for GameServer, initializing a new game
     * @param config config data
     * @param timeout timeout if no client is active on the server
     * @throws IOException if the ServerSocket cannot be started
     */
    public GameServer(Configuration config,int timeout) throws IOException
    {
        messageQueue = new LinkedBlockingQueue<>();
        server = new ServerSocket(Integer.parseInt(config.get("port")));
        clientList = new ArrayList<>();
        playerCount = Integer.parseInt(config.get("players"));
        server.setSoTimeout(timeout);
        game = new Game(this,playerCount,config.get("fields"));
    }
    
  
    /**
     * Gets client connections until it timeouts from no connection.
     */
    @Override
    public void run()
    {
        while(true)
        {
            try(Socket socket = server.accept(); 
                Scanner sc = new Scanner(socket.getInputStream());
            )
            {
                    clientList.add(socket);
                    System.out.println(sc.nextLine());

                groupSockets();
            }
            catch(SocketTimeoutException e) 
            {
                clearClosedClients();
                if(clientList.size() == 0)
                {
                    try {
                        server.close();
                    } catch (IOException ex) {}
                    break;
                }
            }

            catch(IOException e){}
        }
    }
    
    /**
     *  Clears out closed clients from clientList
     */
    private void clearClosedClients()
    {
        ArrayList<Socket> toRemove=new ArrayList<Socket>();
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
    
    /**
     * Starts the game if enough clients are connected
     */
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
    
    /**
     * Starts the game and disconnects the clients when it's over
    */
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
    
    /**
     * Creates ClientThreads for every client
     * @return list of ClientThreads
     */
    private ArrayList<IClientService> connectClients()
    {
        ArrayList<IClientService> services = new ArrayList<>();
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
    
    /**
     * Adds message to the messageQueue
     * @param msg Message object
     */
    public void addMessage(Message msg)
    {
        messageQueue.add(msg);
    }
    
    /**
     * Sends message to every client connected
     * @param msg Message object
     */
    private void sendMessageToAll(Message msg)
    {
        for(IClientService client : clients)
            client.sendMessage(msg);
    }
    
    /**
     * Manages the incoming messages from the clients
     * @param msg Message object
     */
    private void processMessage(Message msg)
    {
        int senderIndex = getSenderIndex(msg);
        boolean senderIsActive = senderIndex == game.getActivePlayerIndex();
        Response response;
        //TODO targyfelvetel commandok
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
    
    /**
     * @param msg Message object
     * @return index of the Sender of the message
     */
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

    /**
     * Sends the random numbers to every client
     * @param numbers list of numbers
     */
    @Override
    public void sendRandomNumbersToAll(List<Integer> numbers) 
    {
        for(IClientService client : clients)
            client.sendRandomNumbers(numbers);
    }

    /**
     * Activates the current player
     * @param playerIndex index of the current player
     */
    @Override
    public void activatePlayer(int playerIndex) 
    {
         clients.get(playerIndex).activate();
    }

    /**
     * See {@link ClientThread#showSubjectRegistrationWindow() showSubjectRegistrationWindow}
     * @param playerIndex index of the receiving player
     */
    @Override
    public void showSubjectRegistrationWindow(int playerIndex) 
    {
        clients.get(playerIndex).showSubjectRegistrationWindow();
    }

    /**
     * See {@link ClientThread#sendGameOver(List) sendGameOver}
     * @param scoreboard scoreboard of the game
     */
    @Override
    public void sendGameOver(List<Integer> scoreboard) 
    {
        for(IClientService client : clients)
            client.sendGameOver(scoreboard);
    }

    /**
     * See {@link ClientThread#setMoney(int) setMoney}
     * @param playerIndex index of player
     * @param money amount of money
     */
    @Override
    public void setMoney(int playerIndex, int money) 
    {
        clients.get(playerIndex).setMoney(money);
    }
    
    /**
     * See {@link ClientThread#beginLearnSubject() beginLearnSubject}
     * @param playerIndex index of player
     */
    @Override
    public void cBeginLearnSubject(int playerIndex) {
        clients.get(playerIndex).beginLearnSubject();
    }

    /**
     * See {@link ClientThread#beginWorkOrStudyChoice() beginWorkOrStudyChoice}
     * @param playerIndex index of player
     */
    @Override
    public void cBeginWorkOrStudyChoice(int playerIndex) {
        clients.get(playerIndex).beginWorkOrStudyChoice();
    }

    /**
     * See {@link ClientThread#beginCourseRequest() beginCourseRequest}
     * @param playerIndex index of player
     */
    @Override
    public void cBeginCourseRequest(int playerIndex) {
        clients.get(playerIndex).beginCourseRequest();
    }

    /**
     * See {@link ClientThread#beginLosingKnowledge() beginLosingKnowledge}
     * @param playerIndex index of player
     */
    @Override
    public void cBeginLosingKnowledge(int playerIndex) {
       clients.get(playerIndex).beginLosingKnowledge();
    }

    /**
     * See {@link ClientThread#beginOfferedMark() beginOfferedMark}
     * @param playerIndex index of player
     */
    @Override
    public void cBeginOfferedMark(int playerIndex) {
        clients.get(playerIndex).beginOfferedMark();
    }

    /**
     * See {@link ClientThread#beginMatekingChoice() beginMatekingChoice}
     * @param playerIndex index of player
     */
    @Override
    public void cBeginMatekingChoice(int playerIndex) {
        clients.get(playerIndex).beginMatekingChoice();
    }

    /**
     * See {@link ClientThread#beginOvertimeWork() beginOvertimeWork}
     * @param playerIndex index of player
     */
    @Override
    public void cBeginOvertimeWork(int playerIndex) {
        clients.get(playerIndex).beginOvertimeWork();
    }

    /**
     * See {@link ClientThread#beginUnregisterSubject() beginUnregisterSubject}
     * @param playerIndex index of player
     */
    @Override
    public void cBeginUnregisterSubject(int playerIndex) {
       clients.get(playerIndex).beginUnregisterSubject();
    }
}
