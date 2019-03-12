
package com.gameofelte.game.fields;

import com.gameofelte.game.Field;
import com.gameofelte.game.Player;


public class Entertainment extends Field{

    public Entertainment(String name, String description) {
        super(name, description);
    }

    @Override
    public void effectPlayer(Player player) {
        int money = 10000;
        player.payMoney(money);
    }
    
}
