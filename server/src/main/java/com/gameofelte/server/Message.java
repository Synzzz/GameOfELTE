package com.gameofelte.server;

import java.net.Socket;

/**
 * Class for storing a message
 */
public class Message 
{
    private final String command;
    private final String data;
    private final Socket sender;

    /**
     * Constructor for a message
     * @param command command to send
     * @param data data to send
     * @param sender socket of the sender
     */
    public Message(String command, String data, Socket sender) 
    {
        this.command = command;
        this.data = data;
        this.sender = sender;
    }

    /**
     * @return command
     */
    public String getCommand() 
    {
        return command;
    }

    /**
     * @return data
     */
    public String getData() 
    {
        return data;
    }

    /**
     * @return sender
     */
    public Socket getSender() 
    {
        return sender;
    }

    @Override
    public String toString() 
    {
        return command + ";" + data;
    }
}
