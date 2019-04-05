package com.gameofelte.game;

import com.gameofelte.game.Field;
import com.gameofelte.game.fields.*;

public class FieldFactory {
    
    public static Field makeField(String type)
    {
       switch(type)
       {
            case "BadDate": 
                return(new BadDate("BadDate","descriptionPlaceholder"));
            case "Course": 
               return(new Course("Course","descriptionPlaceholder"));
            case "CourseRequest": 
               return(new CourseRequest("CourseRequest","descriptionPlaceholder"));
            case "Entertainment": 
                return(new Entertainment("Entertainment","descriptionPlaceholder"));
            case "Exam": 
               return(new Exam("Exam","descriptionPlaceholder"));
            case "GiveUpCourse": 
               return(new GiveUpCourse("GiveUpCourse","descriptionPlaceholder"));
            case "ImpossibleExam": 
                return(new ImpossibleExam("ImpossibleExam","descriptionPlaceholder"));
            case "LuckyCardField": 
               return(new LuckyCardField("LuckyCardField","descriptionPlaceholder"));
            case "NotAttended": 
               return(new NotAttended("NotAttended","descriptionPlaceholder"));
            case "Notes": 
                return(new Notes("Notes","descriptionPlaceholder"));
            case "Ousted": 
               return(new Ousted("Ousted","descriptionPlaceholder"));
            case "StartField": 
               return(new StartField("StartField","descriptionPlaceholder"));
            case "WorkOrStudy": 
               return(new WorkOrStudy("WorkOrStudy","descriptionPlaceholder"));
       
       }
       return null;
    }
    
}
