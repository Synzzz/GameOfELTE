
package com.gameofelte.cards;

import com.gameofelte.game.LuckyCard;
import com.gameofelte.game.Player;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MosiTraining extends LuckyCard{

    public MosiTraining(String name, String description, boolean collectible) {
        super(name, description, collectible);
    }

    @Override
    public void effectPlayer(Player player) {
        try {
            player.beginLearnSubject();
        } catch (Exception ex) {
            Logger.getLogger(MosiTraining.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
