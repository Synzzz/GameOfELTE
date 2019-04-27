
package com.gameofelte.game.cards;

import com.gameofelte.game.LuckyCard;
import com.gameofelte.game.Player;


/**
 * Class implementing Knowledge lucky card
 * for getting knowledge
 */
public class Knowledge extends LuckyCard
{
    /**
     * Constructor for Knowledge
     * @param name String object
     * @param description String object
     * @param collectible boolean object
     */
    public Knowledge(String name, String description, boolean collectible) 
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
