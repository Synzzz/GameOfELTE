
package com.gameofelte.game.fields;

import com.gameofelte.game.Field;
import com.gameofelte.game.Player;

/**
 * Class implementing LuckyCardField field
 * for having a lucky card
 */
public class LuckyCardField extends Field
{
    /**
     * Constructor for LuckyCardField
     * @param name String object
     * @param description String object
     */
    public LuckyCardField(String name, String description) 
    {
        super(name, description);
    }
    
    /**
     * field effect on the player
     */ 
    @Override
    public void effectPlayer(Player player) throws Exception
    {
        player.pickingLuckyCard();
        
    }
    
}
