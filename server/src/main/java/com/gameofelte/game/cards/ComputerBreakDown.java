
package com.gameofelte.game.cards;

import com.gameofelte.game.LuckyCard;
import com.gameofelte.game.Player;

/**
 * Class implementing ComputerBreakDown lucky card
 * for losing money
 */
public class ComputerBreakDown extends LuckyCard
{
    /**
     * Constructor for ComputerBreakDown
     * @param name String object
     * @param description String object
     * @param collectible boolean object
     */
    public ComputerBreakDown(String name, String description, boolean collectible) 
    {
        super(name, description, collectible);
    }

    /**
     * card effect on the player
     */
    @Override
    public void effectPlayer(Player player) throws Exception 
    {
        player.payMoney(100000);
    }
    
}
