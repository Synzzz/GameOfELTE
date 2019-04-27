
package com.gameofelte.game.cards;

import com.gameofelte.game.LuckyCard;
import com.gameofelte.game.Player;

/**
 * Class implementing NewComputerGame lucky card
 * for losing knowledge
 */
public class NewComputerGame extends LuckyCard
{
    /**
     * Constructor for NewComputerGame
     * @param name String object
     * @param description String object
     * @param collectible boolean object
     */
    public NewComputerGame(String name, String description, boolean collectible)
    {
        super(name, description, collectible);
    }

    /**
     * card effect on the player
     */
    @Override
    public void effectPlayer(Player player) throws Exception
    {
        player.beginLosingKnowledge();
    }
    
}
