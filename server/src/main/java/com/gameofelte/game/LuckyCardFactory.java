package com.gameofelte.game;

import com.gameofelte.game.cards.*;

/**
 * Class for creating different types of lucky cards
 */
public class LuckyCardFactory {
    
    /**
     * Creates different types of lucky cards 
     * @param type type of the card needed
     * @return LuckyCard object
     */
    public static LuckyCard makeLuckyCard(String type)
    {
        switch(type)
           {
                case "BonusPoints": 
                    return(new BonusPoints("BonusPoints","descriptionPlaceholder",false));
                case "Cheating": 
                   return(new Cheating("Cheating","descriptionPlaceholder",false));
                case "ComputerBreakDown": 
                   return(new ComputerBreakDown("ComputerBreakDown","descriptionPlaceholder",false));
                case "DeadlineOver": 
                    return(new DeadlineOver("DeadlineOver","descriptionPlaceholder",false));
                case "FourthCourseRequest": 
                   return(new FourthCourseRequest("FourthCourseRequest","descriptionPlaceholder",true));
                case "Hangover": 
                   return(new Hangover("Hangover","descriptionPlaceholder",false));
                case "Knowledge": 
                    return(new Knowledge("Knowledge","descriptionPlaceholder",false));
                case "MatekingDiscount": 
                   return(new MatekingDiscount("MatekingDiscount","descriptionPlaceholder",true));
                case "MosiMega": 
                   return(new MosiMega("MosiMega","descriptionPlaceholder",false));
                case "NewComputerGame": 
                    return(new NewComputerGame("NewComputerGame","descriptionPlaceholder",false));
                case "OfferedMark": 
                   return(new OfferedMark("OfferedMark","descriptionPlaceholder",false));
                case "OvertimeWork": 
                   return(new OvertimeWork("OvertimeWork","descriptionPlaceholder",false));
                case "Scholarship": 
                   return(new Scholarship("Scholarship","descriptionPlaceholder",false));
                case "StateFundToSelfPay": 
                   return(new StateFundToSelfPay("StateFundToSelfPay","descriptionPlaceholder",false));
                case "Tippmix": 
                   return(new Tippmix("Tippmix","descriptionPlaceholder",false));
           }
       return null;
    }
    
}
