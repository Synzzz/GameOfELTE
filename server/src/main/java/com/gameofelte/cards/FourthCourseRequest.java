
package com.gameofelte.cards;

import com.gameofelte.game.LuckyCard;
import com.gameofelte.game.Player;


public class FourthCourseRequest extends LuckyCard{

    public FourthCourseRequest(String name, String description, boolean collectible) {
        super(name, description, collectible);
    }

    @Override
    public void effectPlayer(Player player) {
        player.addLuckyCard(this);
    }
    
}
