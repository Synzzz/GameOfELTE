package com.gameofelte.game;

import java.util.Objects;

/**
 * Abstract class for the lucky cards, implemented in the subclasses
 * @see com.gameofelte.game.cards
 */
public abstract class LuckyCard 
{
    private final String name;
    private final String description;
    private final boolean collectible;

    /**
     * Constructor for the lucky card
     * @param name name of the card
     * @param description description of the card
     * @param collectible is the card collectible
     */
    public LuckyCard(String name, String description, boolean collectible) 
    {
        this.name = name;
        this.description = description;
        this.collectible = collectible;
    }

    @Override
    public String toString() 
    {
        return name + "|" + description + "|" + collectible;
    }

    @Override
    public int hashCode() 
    {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.name);
        return hash;
    }

    /**
     * @return name of the card
     */
    public String getName() 
    {
        return name;
    }

    /**
     * @return description of the card
     */
    public String getDescription() 
    {
        return description;
    }

    /**
     * @return is the card colelctible
     */
    public boolean isCollectible() 
    {
        return collectible;
    }

    @Override
    public boolean equals(Object obj) 
    {
        if (this == obj) 
        {
            return true;
        }
        
        if (obj == null) 
        {
            return false;
        }
        
        if (getClass() != obj.getClass()) 
        {
            return false;
        }
        
        final LuckyCard other = (LuckyCard) obj;
        
        if (!Objects.equals(this.name, other.name)) 
        {
            return false;
        }
        
        return true;
    }

    /**
     * Implemented in the subclasses 
     * @param player player to use the effect on
     * @throws Exception if the effect couldn't be used
     * @see com.gameofelte.game.cards
     */
    public abstract void effectPlayer(Player player) throws Exception ;
}
