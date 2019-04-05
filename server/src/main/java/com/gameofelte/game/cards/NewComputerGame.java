
package com.gameofelte.game.cards;

import com.gameofelte.game.LuckyCard;
import com.gameofelte.game.Player;


public class NewComputerGame extends LuckyCard
{

    public NewComputerGame(String name, String description, boolean collectible)
    {
        super(name, description, collectible);
    }

    @Override
    public void effectPlayer(Player player) throws Exception
    {
        player.beginLosingKnowledge();
    }
    
}
