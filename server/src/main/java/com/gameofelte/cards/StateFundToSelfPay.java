
package com.gameofelte.cards;

import com.gameofelte.game.LuckyCard;
import com.gameofelte.game.Player;


public class StateFundToSelfPay extends LuckyCard{

    public StateFundToSelfPay(String name, String description, boolean collectible) {
        super(name, description, collectible);
    }

    @Override
    public void effectPlayer(Player player) {
        player.changeStateFundStatus(false);
    }
    
}
