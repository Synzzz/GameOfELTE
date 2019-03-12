package com.gameofelte.server;

import java.net.Socket;

public class Message 
{
    private final String command;
    private final String data;
    private final Socket sender;

    public Message(String command, String data, Socket sender) 
    {
        this.command = command;
        this.data = data;
        this.sender = sender;
    }

    public String getCommand() 
    {
        return command;
    }

    public String getData() 
    {
        return data;
    }

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
