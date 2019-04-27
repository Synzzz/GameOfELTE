
package com.gameofelte.game.cards;

import com.gameofelte.game.LuckyCard;
import com.gameofelte.game.Player;

/**
 * Class implementing Scholarship lucky card
 * for earning money
 */
public class Scholarship extends LuckyCard
{
    /**
     * Constructor for Scholarship
     * @param name String object
     * @param description String object
     * @param collectible boolean object
     */
    public Scholarship(String name, String description, boolean collectible)
    {
        super(name, description, collectible);
    }

    /**
     * card effect on the player
     */
    @Override
    public void effectPlayer(Player player) throws Exception
    {
        player.earnMoney(150000);
    }
    
}
