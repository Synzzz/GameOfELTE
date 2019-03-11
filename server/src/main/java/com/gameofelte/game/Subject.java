package com.gameofelte.game;

import java.util.ArrayList;
import java.util.List;

public class Subject 
{
    private final String name;
    private final List<Subject> prerequisites = new ArrayList<>();
    
    public Subject(String name)
    {
        this.name = name;
    }
}
