package com.gameofelte.game;

public abstract class Field 
{
    private final String name;
    private final String description;
    
    public Field(String name, String description)
    {
        this.name = name;
        this.description = description;
    }
    
    public abstract void effectPlayer(Player player) throws Exception;

    @Override
    public String toString() 
    {
        return name + "|" + description;
    }
}
