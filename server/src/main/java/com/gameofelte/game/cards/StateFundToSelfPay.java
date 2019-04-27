
package com.gameofelte.game.cards;

import com.gameofelte.game.LuckyCard;
import com.gameofelte.game.Player;

/**
 * Class implementing StateFundToSelfPay lucky card
 * for changing state to selfpay
 */
public class StateFundToSelfPay extends LuckyCard
{
    /**
     * Constructor for StateFundToSelfPay
     * @param name String object
     * @param description String object
     * @param collectible boolean object
     */
    public StateFundToSelfPay(String name, String description, boolean collectible) 
    {
        super(name, description, collectible);
    }

    /**
     * card effect on the player
     */
    @Override
    public void effectPlayer(Player player) throws Exception
    {
        player.changeStateFundStatus(false);
    }
    
}
