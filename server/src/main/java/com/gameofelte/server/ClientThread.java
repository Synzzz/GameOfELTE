package com.gameofelte.server;

import com.gameofelte.game.Field;
import com.gameofelte.game.LuckyCard;
import com.gameofelte.services.IClientService;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class implementing IClientService for the client to connect to
 */
public class ClientThread extends Thread implements IClientService
{
    private final Socket socket;
    private final GameServer server;
    private final PrintWriter printWriter;
    
    /**
     * Constructor for ClientThread
     * @param socket Socket object
     * @param server GameServer object
     * @throws IOException if the socket output stream couldn't be opened
     */
    public ClientThread(Socket socket, GameServer server) throws IOException
    {
        this.socket = socket;
        this.server = server;
        
        printWriter = new PrintWriter(socket.getOutputStream());
    }
    /**
     * Reads new lines from the client and adds them to the server's message queue
     */
    @Override
    public void run()
    {
        try(Scanner scanner = new Scanner(socket.getInputStream()))
        {
            while(scanner.hasNextLine())
            {
                String[] split = scanner.nextLine().split(";");
                
                server.addMessage(new Message(split[0], split[1], socket));
            }
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Sends a list of random numbers to the client 
     * @param numbers list of random numbers
     */
    @Override
    public void sendRandomNumbers(List<Integer> numbers) 
    {
        printWriter.print("RANDOM_NUMBERS;");
        
        for(int i = 0; i < numbers.size(); i++)
        {
            printWriter.print(numbers.get(i));
            
            if(i < numbers.size() - 1)
            {
                printWriter.print(",");
            }
        }
        
        printWriter.println();
        printWriter.flush();
    }

    /**
     * Sends a message to the client
     * @param msg Message object
     */
    @Override
    public void sendMessage(Message msg) 
    {
        if(msg.getSender() != socket)
        {
            printWriter.println(msg.toString());
            printWriter.flush();
        }
    }

    /**
     * @return client's socket
     */
    @Override
    public Socket getSocket() 
    {
        return socket;
    }

    /**
     * Sends a response to the client
     * @param response Response object
     */
    @Override
    public void sendResponse(Response response) 
    {
        printWriter.println(response.toString());
        // TODO még1 flush?
        printWriter.flush();
    }

    /**
     * Sends the list of LuckyCards to the client
     * @param luckyCards list of LuckyCards
     */
    @Override
    public void sendLuckyCards(List<LuckyCard> luckyCards) 
    {
        printWriter.print("LUCKY_CARDS;");
        
        for(int i = 0; i < luckyCards.size(); i++)
        {
            LuckyCard card = luckyCards.get(i);
            printWriter.print(card.toString());
            
            if(i < luckyCards.size() - 1)
                printWriter.print(",");
        }
        
        printWriter.println();
        printWriter.flush();
    }

    /**
     * Sends the list of Fields to the client
     * @param fields list of Fields
     */
    @Override
    public void sendBoard(List<Field> fields) 
    {
        printWriter.print("FIELDS;");
        
        for(int i = 0; i < fields.size(); i++)
        {
            Field field = fields.get(i);
            printWriter.print(field.toString());
            
            if(i < fields.size() - 1)
                printWriter.print(",");
        }
        
        printWriter.println();
        printWriter.flush();
    }

    /**
     * Sends the game over message to the client
     * @param scoreboard List of player scores
     */
    @Override
    public void sendGameOver(List<Integer> scoreboard) 
    {
        printWriter.print("GAME_OVER;");
        
        for(int i = 0; i < scoreboard.size(); i++)
        {
            printWriter.print(scoreboard.get(i));
            
            if(i < scoreboard.size() - 1)
                printWriter.print(",");
        }
        
        printWriter.println();
        printWriter.flush();
    }

    /**
     * Sends the player's color to the client
     * @param color ID of the color
     */
    @Override
    public void sendColor(int color) 
    {
        printWriter.println("COLOR;" + color);
        printWriter.flush();
    }

    /**
     * Sends the showSubjectRegistrationWindow command to the client
     */
    @Override
    public void showSubjectRegistrationWindow() 
    {
        printWriter.println("SHOW_SUBJECT_REGISTRATION_WINDOW");
        printWriter.flush();
    }

    /**
     * Sends the activate command to the client, signaling its their turn
     */
    @Override
    public void activate() 
    {
        printWriter.println("ACTIVATE");
        printWriter.flush();
    }

    /**
     * Closes the connection with the client
     */
    @Override
    public void close() 
    {
        printWriter.close();
        
        try 
        {
            socket.close();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Sets the client's money amount to the parameter
     * @param amount amount of money
     */
    @Override
    public void setMoney(int amount) 
    {
        printWriter.println("SET_MONEY;" + amount);
        printWriter.flush();
    }
    
    /**
     * Sends the Learn Subject command to the client
     */
    @Override
    public void beginLearnSubject() {
        printWriter.println("LEARN_SUBJECT");
        printWriter.flush();
    }

    /**
     * Sends the Work or study command to the client
     */
    @Override
    public void beginWorkOrStudyChoice() {
        printWriter.println("WORK_OR_STUDY");
        printWriter.flush();
    }

    /**
     * Sends the Course request command to the client
     */
    @Override
    public void beginCourseRequest() {
        printWriter.println("COURSE_REQUEST");
        printWriter.flush();
    }

    /**
     * Sends the Losing knowledge command to the client
     */
    @Override
    public void beginLosingKnowledge() {
        printWriter.println("LOSING_KNOWLEDGE");
        printWriter.flush();
    }

    /**
     * Sends the Offered mark command to the client
     */
    @Override
    public void beginOfferedMark() {
        printWriter.println("OFFERED_MARK");
        printWriter.flush();
    }

    /**
     * Sends the Mateking choice command to the client
     */
    @Override
    public void beginMatekingChoice() {
        printWriter.println("MATEKING_CHOICE");
        printWriter.flush();
    }

    /**
     * Sends the Overtime work command to the client
     */
    @Override
    public void beginOvertimeWork() {
        printWriter.println("OVERTIME_WORK");
        printWriter.flush();
    }

    /**
     * Sends the Unregister subject command to the client
     */
    @Override
    public void beginUnregisterSubject() {
        printWriter.println("UNREGISTER_SUBJECT");
        printWriter.flush();
    }
}
