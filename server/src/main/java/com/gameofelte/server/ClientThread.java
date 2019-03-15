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

public class ClientThread extends Thread implements IClientService
{
    private final Socket socket;
    private final GameServer server;
    private final PrintWriter printWriter;
    
    public ClientThread(Socket socket, GameServer server) throws IOException
    {
        this.socket = socket;
        this.server = server;
        
        printWriter = new PrintWriter(socket.getOutputStream());
    }
    
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
        printWriter.println();
        printWriter.flush();
    }

    @Override
    public void sendMessage(Message msg) 
    {
        if(msg.getSender() != socket)
        {
            printWriter.println(msg.toString());
            printWriter.flush();
        }
    }

    @Override
    public Socket getSocket() 
    {
        return socket;
    }

    @Override
    public void sendResponse(Response response) 
    {
        printWriter.println(response.toString());
        // TODO még1 flush?
        printWriter.flush();
    }

    @Override
    public void sendLuckyCards(List<LuckyCard> luckyCards) 
    {
        printWriter.print("LUCK_CARDS;");
        
        for(int i = 0; i < luckyCards.size(); i++)
        {
            LuckyCard card = luckyCards.get(i);
            printWriter.print(card.toString());
            
            if(i < luckyCards.size() - 1)
                printWriter.print(",");
        }
        
        printWriter.println();
        printWriter.println();
        printWriter.flush();
    }

    @Override
    public void sendBoard(List<Field> fields) 
    {
         printWriter.print("FIELDS;");
        
        for(int i = 0; i < fields.size(); i++)
        {
            Field card = fields.get(i);
            printWriter.print(card.toString());
            
            if(i < fields.size() - 1)
                printWriter.print(",");
        }
        
        printWriter.println();
        printWriter.println();
        printWriter.flush();
    }

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
        printWriter.println();
        printWriter.flush();
    }

    @Override
    public void sendColor(int color) 
    {
        printWriter.println("COLOR;" + color);
        printWriter.println();
        printWriter.flush();
    }

    @Override
    public void showSubjectRegistrationWindow() 
    {
        printWriter.println("SHOW_SUBJECT_REGISTRATION_WINDOW");
        printWriter.println();
        printWriter.flush();
    }

    @Override
    public void activate() 
    {
        printWriter.println("ACTIVATE");
        printWriter.println();
        printWriter.flush();
    }

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

    @Override
    public void setMoney(int amount) 
    {
        printWriter.println("SET_MONEY;" + amount);
        printWriter.println();
        printWriter.flush();
    }
}
