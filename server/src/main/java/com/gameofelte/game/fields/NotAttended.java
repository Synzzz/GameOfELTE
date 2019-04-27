
package com.gameofelte.game.fields;

import com.gameofelte.game.Field;
import com.gameofelte.game.Player;
import com.gameofelte.game.Subject;

/**
 * Class implementing NotAttended field
 * for losing a subject
 */
public class NotAttended extends Field
{
    /**
     * Constructor for NotAttended
     * @param name String object
     * @param description String object
     */
    public NotAttended(String name, String description) 
    {
        super(name, description);
    }

    /**
     * field effect on the player
     */     
    @Override
    public void effectPlayer(Player player) throws Exception
    {
        player.beginUnregisterSubject();
    }
    
}
