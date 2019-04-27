package com.gameofelte.game.fields;

import com.gameofelte.game.Field;
import com.gameofelte.game.Player;

/**
 * Class implementing StartField field
 * players start here
 */
public class StartField extends Field
{
    /**
     * Constructor for StartField
     * @param name String object
     * @param description String object
     */    
    public StartField(String name, String description) 
    {
        super(name, description);
    }
    //TODO
    /**
     * field effect on the player
     */  
    @Override
    public void effectPlayer(Player player) throws Exception
    {
        
    }
}
