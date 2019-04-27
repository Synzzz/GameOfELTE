
package com.gameofelte.game.fields;

import com.gameofelte.game.Field;
import com.gameofelte.game.Player;

/**
 * Class implementing BadDate field
 * for losing subject
 */
public class BadDate extends Field 
{
    /**
     * Constructor for BadDate
     * @param name String object
     * @param description String object
     */
    public BadDate(String name, String description) 
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
