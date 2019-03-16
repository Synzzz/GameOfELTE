
package com.gameofelte.cards;

import com.gameofelte.game.LuckyCard;
import com.gameofelte.game.Player;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Knowledge extends LuckyCard{

    public Knowledge(String name, String description, boolean collectible) {
        super(name, description, collectible);
    }

    @Override
    public void effectPlayer(Player player) {
        try {
            player.beginLearnSubject();
        } catch (Exception ex) {
            Logger.getLogger(Knowledge.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
