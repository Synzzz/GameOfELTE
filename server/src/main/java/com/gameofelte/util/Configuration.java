package com.gameofelte.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Configuration 
{
    private final Map<String, String> values;
    private final Map<String, String> defaultValues;
    
    public Configuration(String configFile) throws FileNotFoundException
    {
        values = new HashMap<>();
        defaultValues = new HashMap<>();
        
        try(Scanner scanner = new Scanner(new File(configFile)))
        {
            while(scanner.hasNextLine())
            {
                String[] split = scanner.nextLine().split("=");
                values.put(split[0], split[1]);
            }
        }
    }
    
    public void putDefault(String key, String defaultValue)
    {
        defaultValues.put(key, defaultValue);
    }
    
    public String get(String key)
    {
        if(values.containsKey(key))
            return values.get(key);
        else if(defaultValues.containsKey(key))
            return defaultValues.get(key);
        
        return null;
    }
}
