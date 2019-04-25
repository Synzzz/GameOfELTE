package com.gameofelte.game;


/**
 * Abstract class for a Field on the board, implemented in the subclasses
 */

public abstract class Field 
{
    private final String name;
    private final String description;
    
    /**
     * Constructor for the Field class
     * @param name name of the field
     * @param description description of the field
     */
    public Field(String name, String description)
    {
        this.name = name;
        this.description = description;
    }
    /**
     * Implemented in the subclasses 
     * @param player the player to use the effect on
     * @throws Exception if the effect couldn't be used
     * @see com.gameofelte.game.fields
     */
    public abstract void effectPlayer(Player player) throws Exception;

    /**
     * Converts Field data to a String
     * @return data in String format
     */
    @Override
    public String toString() 
    {
        return name + "|" + description;
    }
}
