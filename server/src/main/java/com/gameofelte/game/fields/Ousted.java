
package com.gameofelte.game.fields;

import com.gameofelte.game.Field;
import com.gameofelte.game.Player;

/**
 * Class implementing Ousted field
 * for losing a subject
 */
public class Ousted extends Field 
{
    /**
     * Constructor for Ousted
     * @param name String object
     * @param description String object
     */
    public Ousted(String name, String description) 
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
