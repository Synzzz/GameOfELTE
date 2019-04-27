
package com.gameofelte.game.fields;

import com.gameofelte.game.Field;
import com.gameofelte.game.Player;

/**
 * Class implementing CourseRequest field
 * for choosing subject
 */
public class CourseRequest extends Field 
{
    /**
     * Constructor for CourseRequest
     * @param name String object
     * @param description String object
     */
    public CourseRequest(String name, String description) 
    {
        super(name, description);
    }

    /**
     * field effect on the player
     */  
    @Override
    public void effectPlayer(Player player) throws Exception 
    {
        player.beginCourseRequest();
    }
    
}
