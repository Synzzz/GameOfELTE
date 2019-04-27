
package com.gameofelte.game.cards;

import com.gameofelte.game.LuckyCard;
import com.gameofelte.game.Player;

/**
 * Class implementing OfferedMark lucky card
 * for having a subject complete
 */
public class OfferedMark extends LuckyCard
{
    /**
     * Constructor for OfferedMark
     * @param name String object
     * @param description String object
     * @param collectible boolean object
     */
    public OfferedMark(String name, String description, boolean collectible) 
    {
        super(name, description, collectible);
    }

    /**
     * card effect on the player
     */
    @Override
    public void effectPlayer(Player player) throws Exception
    {
        player.beginOfferedMark();
    }
    
}
