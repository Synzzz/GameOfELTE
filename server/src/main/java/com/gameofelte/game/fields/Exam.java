
package com.gameofelte.game.fields;

import com.gameofelte.game.Field;
import com.gameofelte.game.Player;
import com.gameofelte.game.Subject;
import java.util.List;


public class Exam extends Field{

    public Exam(String name, String description) {
        super(name, description);
    }

    @Override
    public void effectPlayer(Player player) {
        List<Subject> learnedSubjects = player.getLearnedSubjects();
        for(Subject subject : learnedSubjects){
            player.completeSubject(subject);
        }
    }
    
}
