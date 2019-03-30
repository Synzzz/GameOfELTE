
package com.gameofelte.game.cards;

import com.gameofelte.game.LuckyCard;
import com.gameofelte.game.Player;


public class BonusPoints extends LuckyCard 
{

    public BonusPoints(String name, String description, boolean collectible) 
    {
        super(name, description, collectible);
    }

    //TODO + megbeszélni ez hogy is legyen
    @Override
    public void effectPlayer(Player player) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
