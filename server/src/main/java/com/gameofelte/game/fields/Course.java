
package com.gameofelte.game.fields;

import com.gameofelte.game.Field;
import com.gameofelte.game.Player;

/**
 * Class implementing Course field
 * for losing subject on 2 players on this field
 */
public class Course extends Field
{
    /**
     * Constructor for Course
     * @param name String object
     * @param description String object
     */
    public Course(String name, String description) 
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
