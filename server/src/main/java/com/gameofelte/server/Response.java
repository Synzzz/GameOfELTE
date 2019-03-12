package com.gameofelte.server;

enum ResponseType { OK, ERROR }

public class Response 
{
    private final ResponseType type;
    private final String responseMessage;

    public Response(ResponseType type) 
    {
        this.type = type;
        responseMessage = null;
    }

    public Response(ResponseType type, String responseMessage) 
    {
        this.type = type;
        this.responseMessage = responseMessage;
    }

    @Override
    public String toString() 
    {
        return "RESPONSE_" + type + ";" + responseMessage;
    }
}
