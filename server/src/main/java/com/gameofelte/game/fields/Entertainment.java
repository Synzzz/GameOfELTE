
package com.gameofelte.game.fields;

import com.gameofelte.game.Field;
import com.gameofelte.game.Player;

/**
 * Class implementing Entertainment field
 * for losing money
 */
public class Entertainment extends Field
{
    /**
     * Constructor for Entertainment
     * @param name String object
     * @param description String object
     */
    public Entertainment(String name, String description) 
    {
        super(name, description);
    }
    
    /**
     * field effect on the player
     */ 
    @Override
    public void effectPlayer(Player player) throws Exception
    {
        player.payMoney(10000);
    }
    
}
