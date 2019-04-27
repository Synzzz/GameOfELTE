
package com.gameofelte.game.cards;

import com.gameofelte.game.LuckyCard;
import com.gameofelte.game.Player;
import java.util.Random;

/**
 * Class implementing Cheating lucky card
 * for removing random subject
 */
public class Cheating extends LuckyCard
{

    /**
     * Constructor for Cheating
     * @param name String object
     * @param description String object
     * @param collectible boolean object
     */
    public Cheating(String name, String description, boolean collectible) 
    {
        super(name, description, collectible);
    }

    /**
     * card effect on the player
     */
    @Override
    public void effectPlayer(Player player) throws Exception 
    {
       player.removeRandomSubject();
    }
    
}
