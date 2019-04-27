
package com.gameofelte.game.cards;

import com.gameofelte.game.LuckyCard;
import com.gameofelte.game.Player;

/**
 * Class implementing FourthCourseRequest lucky card
 * for requesting a course again
 */
public class FourthCourseRequest extends LuckyCard
{
    /**
     * Constructor for FourthCourseRequest
     * @param name String object
     * @param description String object
     * @param collectible boolean object
     */
    public FourthCourseRequest(String name, String description, boolean collectible) 
    {
        super(name, description, collectible);
    }
    
    /**
     * card effect on the player
     */
    @Override
    public void effectPlayer(Player player) throws Exception
    {

    }
    
}
