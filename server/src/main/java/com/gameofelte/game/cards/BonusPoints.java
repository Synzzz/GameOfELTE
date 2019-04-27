
package com.gameofelte.game.cards;

import com.gameofelte.game.LuckyCard;
import com.gameofelte.game.Player;

/**
 * Class implementing BonusPoints lucky card
 * for the course request part
 */
public class BonusPoints extends LuckyCard 
{
    /**
     * Constructor for BonusPoints
     * @param name String object
     * @param description String object
     * @param collectible boolean object
     */
    public BonusPoints(String name, String description, boolean collectible) 
    {
        super(name, description, collectible);
    }

    /**
     * card effect on the player
     */
    @Override
    public void effectPlayer(Player player) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
