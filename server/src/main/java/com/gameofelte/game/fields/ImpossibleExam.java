
package com.gameofelte.game.fields;

import com.gameofelte.game.Field;
import com.gameofelte.game.Player;

/**
 * Class implementing ImpossibleExam field
 * for losing random subject
 */
public class ImpossibleExam extends Field
{
    /**
     * Constructor for ImpossibleExam
     * @param name String object
     * @param description String object
     */
    public ImpossibleExam(String name, String description) 
    {
        super(name, description);
    }

    /**
     * field effect on the player
     */ 
    @Override
    public void effectPlayer(Player player) throws Exception
    {
        player.removeRandomSubject();
    }
    
}
