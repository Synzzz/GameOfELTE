package com.gameofelte.game;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for the subject
 */
public class Subject 
{
    private final String name;
    private final List<String> prerequisites = new ArrayList<>();
    
    /**
     * Constructor for the subject
     * @param name name of the subject
     * @param prerequisites list of strings of the prerequisites 
     */
    public Subject(String name,ArrayList<String> prerequisites)
    {
        this.name = name;
        for(String subject : prerequisites)
        {
            this.prerequisites.add(subject);
        }
    }

    /**
     * @return list of strings of prerequisites
     */
    public List<String> getPrerequisites() 
    {
        return prerequisites;
    }

    /**
     * @return name of the subject
     */
    public String getName() 
    {
        return name;
    }
    
    
}
