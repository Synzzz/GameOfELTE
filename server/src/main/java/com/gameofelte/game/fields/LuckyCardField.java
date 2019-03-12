
package com.gameofelte.game.fields;

import com.gameofelte.game.Field;
import com.gameofelte.game.Player;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LuckyCardField extends Field{

    public LuckyCardField(String name, String description) {
        super(name, description);
    }

    @Override
    public void effectPlayer(Player player) {
        try {
            player.pickingLuckyCard();
        } catch (Exception ex) {
            Logger.getLogger(LuckyCardField.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
