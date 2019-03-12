
package com.gameofelte.game.fields;

import com.gameofelte.game.Field;
import com.gameofelte.game.Player;
import java.util.Random;


public class ImpossibleExam extends Field{

    public ImpossibleExam(String name, String description) {
        super(name, description);
    }

    @Override
    public void effectPlayer(Player player) {
        Random rand = new Random();
        int max = player.getRegisteredSubjects().size();
        int num = rand.nextInt(max - 1);
        player.removeSubjectByIndex(num);
    }
    
}
