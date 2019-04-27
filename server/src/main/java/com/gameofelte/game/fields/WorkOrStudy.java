
package com.gameofelte.game.fields;

import com.gameofelte.game.Field;
import com.gameofelte.game.Player;

/**
 * Class implementing WorkOrStudy field
 * for choosing money or knowledge
 */
public class WorkOrStudy extends Field
{
    /**
     * Constructor for WorkOrStudy
     * @param name String object
     * @param description String object
     */    
    public WorkOrStudy(String name, String description) 
    {
        super(name, description);
    }

    /**
     * field effect on the player
     */      
    @Override
    public void effectPlayer(Player player) throws Exception 
    {
        player.beginWorkOrStudyChoice();
    }
    
}
