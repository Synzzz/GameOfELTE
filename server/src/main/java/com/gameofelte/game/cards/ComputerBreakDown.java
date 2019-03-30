
package com.gameofelte.game.cards;

import com.gameofelte.game.LuckyCard;
import com.gameofelte.game.Player;


public class ComputerBreakDown extends LuckyCard
{

    public ComputerBreakDown(String name, String description, boolean collectible) 
    {
        super(name, description, collectible);
    }

    @Override
    public void effectPlayer(Player player) throws Exception 
    {
        player.payMoney(100000);
    }
    
}
