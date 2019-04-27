
package com.gameofelte.game.fields;

import com.gameofelte.game.Field;
import com.gameofelte.game.Player;

/**
 * Class implementing GiveUpCourse field
 * for losing subject
 */
public class GiveUpCourse extends Field
{
    /**
     * Constructor for GiveUpCourse
     * @param name String object
     * @param description String object
     */
    public GiveUpCourse(String name, String description) 
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
