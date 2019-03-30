
package com.gameofelte.game.fields;

import com.gameofelte.game.Field;
import com.gameofelte.game.Player;


public class Notes extends Field
{

    public Notes(String name, String description)
    {
        super(name, description);
    }

    @Override
    public void effectPlayer(Player player) throws Exception 
    {
        player.beginLearnSubject();
    }
    
}
