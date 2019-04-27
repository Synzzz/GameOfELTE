
package com.gameofelte.game.fields;

import com.gameofelte.game.Field;
import com.gameofelte.game.Player;
import com.gameofelte.game.Subject;
import java.util.List;

/**
 * Class implementing Exam field
 * for completing subjects
 */
public class Exam extends Field{

    /**
     * Constructor for Exam
     * @param name String object
     * @param description String object
     */
    public Exam(String name, String description) {
        super(name, description);
    }

    /**
     * field effect on the player
     */ 
    @Override
    public void effectPlayer(Player player) {
        List<Subject> learnedSubjects = player.getLearnedSubjects();
        for(Subject subject : learnedSubjects){
            player.completeSubject(subject);
        }
    }
    
}
