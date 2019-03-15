
package com.gameofelte.game.fields;

import com.gameofelte.game.Field;
import com.gameofelte.game.Player;
import com.gameofelte.game.Subject;


public class NotAttended extends Field
{

    public NotAttended(String name, String description) 
    {
        super(name, description);
    }

    @Override
    public void effectPlayer(Player player) throws Exception
    {
        player.beginUnregisterSubject();
    }
    
}
