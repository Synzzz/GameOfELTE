package com.gameofelte.game;

import java.util.ArrayList;
import java.util.List;

public class Subject 
{
    private final String name;
    private final List<String> prerequisites = new ArrayList<>();
    
    public Subject(String name,ArrayList<String> prerequisites)
    {
        this.name = name;
        for(String subject : prerequisites)
        {
            this.prerequisites.add(subject);
        }
    }

    public List<String> getPrerequisites() 
    {
        return prerequisites;
    }

    public String getName() 
    {
        return name;
    }
    
    
}
