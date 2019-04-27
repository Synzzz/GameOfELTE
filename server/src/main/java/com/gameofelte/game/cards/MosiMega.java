
package com.gameofelte.game.cards;

import com.gameofelte.game.LuckyCard;
import com.gameofelte.game.Player;


/**
 * Class implementing MosiMega lucky card
 * for getting knowledge
 */
public class MosiMega extends LuckyCard
{
    /**
     * Constructor for MosiMega
     * @param name String object
     * @param description String object
     * @param collectible boolean object
     */
    public MosiMega(String name, String description, boolean collectible) 
    {
        super(name, description, collectible);
    }
    
    /**
     * card effect on the player
     */
    @Override
    public void effectPlayer(Player player) throws Exception 
    {
            player.beginLearnSubject();
    }
    
}
