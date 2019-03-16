
package com.gameofelte.cards;

import com.gameofelte.game.LuckyCard;
import com.gameofelte.game.Player;


public class MatekingDiscount extends LuckyCard{

    public MatekingDiscount(String name, String description, boolean collectible) {
        super(name, description, collectible);
    }

    @Override
    public void effectPlayer(Player player) {
        player.beginMatekingChoice();
    }
    
}
