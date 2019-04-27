
package com.gameofelte.game.fields;

import com.gameofelte.game.Field;
import com.gameofelte.game.Player;

/**
 * Class implementing Notes field
 * for having a knowledge
 */
public class Notes extends Field
{
    /**
     * Constructor for Notes
     * @param name String object
     * @param description String object
     */
    public Notes(String name, String description)
    {
        super(name, description);
    }

    /**
     * field effect on the player
     */       
    @Override
    public void effectPlayer(Player player) throws Exception 
    {
        player.beginLearnSubject();
    }
    
}
