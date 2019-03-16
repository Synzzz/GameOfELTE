
package com.gameofelte.cards;

import com.gameofelte.game.LuckyCard;
import com.gameofelte.game.Player;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DeadlineOver extends LuckyCard{

    public DeadlineOver(String name, String description, boolean collectible) {
        super(name, description, collectible);
    }

    @Override
    public void effectPlayer(Player player) {
        try {
            player.beginUnregisterSubject();
        } catch (Exception ex) {
            Logger.getLogger(DeadlineOver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
