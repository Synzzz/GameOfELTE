
package com.gameofelte.game.cards;

import com.gameofelte.game.LuckyCard;
import com.gameofelte.game.Player;

/**
 * Class implementing OvertimeWork lucky card
 * for losing a knowledge but earning double amount of salary
 */
public class OvertimeWork extends LuckyCard
{
    /**
     * Constructor for OvertimeWork
     * @param name String object
     * @param description String object
     * @param collectible boolean object
     */
    public OvertimeWork(String name, String description, boolean collectible) 
    {
        super(name, description, collectible);
    }
    
    /**
     * card effect on the player
     */
    @Override
    public void effectPlayer(Player player) throws Exception
    {
        player.beginOvertimeWork();
    }
    
}
