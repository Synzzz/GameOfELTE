
package com.gameofelte.game.cards;

import com.gameofelte.game.LuckyCard;
import com.gameofelte.game.Player;


public class Tippmix extends LuckyCard
{

    public Tippmix(String name, String description, boolean collectible) 
    {
        super(name, description, collectible);
    }

    @Override
    public void effectPlayer(Player player) throws Exception
    {
        player.earnMoney(50000);
    }
    
}
