package com.gameofelte.game;

import java.util.Objects;

public abstract class LuckyCard 
{
    private final String name;
    private final String description;
    private final boolean collectible;

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

    public String getName() 
    {
        return name;
    }

    public String getDescription() 
    {
        return description;
    }

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
    // TODO
    public abstract void effectPlayer(Player player);
}
