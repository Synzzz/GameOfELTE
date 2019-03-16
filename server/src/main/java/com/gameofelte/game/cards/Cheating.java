
package com.gameofelte.game.cards;

import com.gameofelte.game.LuckyCard;
import com.gameofelte.game.Player;
import java.util.Random;


public class Cheating extends LuckyCard{

    public Cheating(String name, String description, boolean collectible) {
        super(name, description, collectible);
    }

    @Override
    public void effectPlayer(Player player) {
       player.removeRandomSubject();
    }
    
}
