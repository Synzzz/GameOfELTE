
package com.gameofelte.game.cards;

import com.gameofelte.game.LuckyCard;
import com.gameofelte.game.Player;

/**
 * Class implementing MatekingDiscount lucky card
 * for getting knowledge
 */
public class MatekingDiscount extends LuckyCard
{
    /**
     * Constructor for MatekingDiscount
     * @param name String object
     * @param description String object
     * @param collectible boolean object
     */
    public MatekingDiscount(String name, String description, boolean collectible) 
    {
        super(name, description, collectible);
    }

    /**
     * card effect on the player
     */
    @Override
    public void effectPlayer(Player player) throws Exception
    {
        player.beginMatekingChoice();
    }
    
}
