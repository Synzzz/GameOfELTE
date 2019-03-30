
package com.gameofelte.game.fields;

import com.gameofelte.game.Field;
import com.gameofelte.game.Player;


public class Ousted extends Field 
{

    public Ousted(String name, String description) 
    {
        super(name, description);
    }

    @Override
    public void effectPlayer(Player player) throws Exception
    {
        player.removeRandomSubject();
    }
    
}
