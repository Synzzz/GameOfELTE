
package com.gameofelte.game.cards;

import com.gameofelte.game.LuckyCard;
import com.gameofelte.game.Player;

/**
 * Class implementing Tippmix lucky card
 * for earning money
 */
public class Tippmix extends LuckyCard
{
    /**
     * Constructor for Tippmix
     * @param name String object
     * @param description String object
     * @param collectible boolean object
     */
    public Tippmix(String name, String description, boolean collectible) 
    {
        super(name, description, collectible);
    }

    /**
     * card effect on the player
     */  
    @Override
    public void effectPlayer(Player player) throws Exception
    {
        player.earnMoney(50000);
    }
    
}
