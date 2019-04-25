package com.gameofelte.server;

/**
 * Class for storing a response
 */
public class Response 
{
    private final ResponseType type;
    private final String responseMessage;

    /**
     * Constructor for Response without message
     * @param type see {@link ResponseType ResponseType}
     */
    public Response(ResponseType type) 
    {
        this.type = type;
        responseMessage = null;
    }

   /**
     * Constructor for Response with a message
     * @param type see {@link ResponseType ResponseType}
     * @param responseMessage message
     */
    public Response(ResponseType type, String responseMessage) 
    {
        this.type = type;
        this.responseMessage = responseMessage;
    }

    @Override
    public String toString() 
    {
        return "RESPONSE;" + type + "|" + responseMessage;
    }
}
