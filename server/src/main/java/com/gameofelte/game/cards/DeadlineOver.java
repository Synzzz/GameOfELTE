
package com.gameofelte.game.cards;

import com.gameofelte.game.LuckyCard;
import com.gameofelte.game.Player;


/**
 * Class implementing DeadlineOver lucky card
 * for losing money
 */
public class DeadlineOver extends LuckyCard
{
    /**
     * Constructor for DeadlineOver
     * @param name String object
     * @param description String object
     * @param collectible boolean object
     */
    public DeadlineOver(String name, String description, boolean collectible) 
    {
        super(name, description, collectible);
    }
    
    /**
     * card effect on the player
     */
    @Override
    public void effectPlayer(Player player) throws Exception 
    {
            player.beginUnregisterSubject();
    }
    
}
