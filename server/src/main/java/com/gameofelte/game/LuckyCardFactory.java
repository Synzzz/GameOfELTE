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
                case "Cheating": 
                   return(new Cheating("Puskázás","Rajtakaptak, hogy puskázol, ezért egy véletlenszerűen kiválasztott tárgyat elbuksz.",false));
                case "ComputerBreakDown": 
                   return(new ComputerBreakDown("Elromlott a géped","Új gépet kell venned ez sajnos 100 000 Ft-t.",false));
                case "DeadlineOver": 
                    return(new DeadlineOver("Deadline over","Mindig lemaradtál a captcha-ról buktad a tárgyat.",false));
                case "FourthCourseRequest": 
                   return(new FourthCourseRequest("Negyedik tárgyfelvétel","Ez egy megtartható kártya. Ha egy tárgy nem sikerül 3. tárgyfelvételre sem, akkor felhasználható egyszer.",true));
                case "Hangover": 
                   return(new Hangover("Másnaposság","Előző este keményre sikerült, elvesztesz egy tudást egy általad választott tárgyból.",false));
                case "Knowledge": 
                    return(new Knowledge("Tudás","Korábban megszerzett tudásod miatt nem kell készülnöd egy általad kiválasztott tárgyra (tudást ad egy tárgyhoz).",false));
                case "MatekingDiscount": 
                   return(new MatekingDiscount("50% Mateking discount","Választhatsz hogy fizetsz 50 000 Ft-ot így szerezve tudást Mateking által, vagy később használod fel.",true));
                case "MosiMega": 
                   return(new MosiMega("Mosi mega","Bementél Mosi pajtás felkészítőjére, ezért tudást szerzel egy általad kiválasztott tárgyból.",false));
                case "NewComputerGame": 
                    return(new NewComputerGame("Kijött egy új game","Rákockultál egy új játékra ami miatt kihagytál pár órát, veszítesz egy tudást az általad választott tárgyból.",false));
                case "OfferedMark": 
                   return(new OfferedMark("Megajánlott jegy","Kiderült, hogy sikerült megajánlott jegyet szerezni egy általad választott tárgyra.",false));
                case "OvertimeWork": 
                   return(new OvertimeWork("Túlóra","Behívtak túlórázni ezért a kereseted kétszeresét megkapod, azonban veszítesz egy tudást az általad választott tárgyból.",false));
                case "Scholarship": 
                   return(new Scholarship("Ösztöndíj","Jó tanulmányi átlagod miatt kapsz 150 000 Ft ösztöndíjat.",false));
                case "StateFundToSelfPay": 
                   return(new StateFundToSelfPay("Átsorolás","Rossz tanulmányi átlagod miatt a félév végén át fognak rakni költségtérítéses képzésre.",false));
                case "Tippmix": 
                   return(new Tippmix("Tippmix","Tippmixen nyertél 50 000 Ft-ot.",false));
           }
       return null;
    }
    
}
