
package com.gameofelte.cards;

import com.gameofelte.game.LuckyCard;
import com.gameofelte.game.Player;


public class Scholarship extends LuckyCard{

    public Scholarship(String name, String description, boolean collectible) {
        super(name, description, collectible);
    }

    @Override
    public void effectPlayer(Player player) {
        player.earnMoney(150000);
    }
    
}
