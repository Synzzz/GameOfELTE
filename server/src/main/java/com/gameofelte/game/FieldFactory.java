package com.gameofelte.game;

import com.gameofelte.game.Field;
import com.gameofelte.game.fields.*;

/**
 * Class for creating different types of fields 
 */
public class FieldFactory {
    
    /**
     * Creates different types of fields 
     * @param type type of the Field needed
     * @return Field object
     */
    public static Field makeField(String type)
    {
       switch(type)
       {
            case "BadDate": 
                return(new BadDate("Rossz időpont","Egy általad kiválasztott tárgy rossz időpontban van, ezért leadod"));
            case "Course": 
               return(new Course("Kurzus","Ha két játékos is áll ezen a mezőn az később érkezett játékos kiválaszthat egy tárgyat, amiből kitúrhatja a már korábban ott lévő játékost, feltéve, hogy volt közös tárgyuk, egyébként nincs jelentősége a mezőnek"));
            case "CourseRequest": 
               return(new CourseRequest("Tárgyfelvétel kérvény","Ha még van olyan tárgy, amit nem sikerült felvenned, itt megteheted"));
            case "Entertainment": 
                return(new Entertainment("Szórakozás","Szórakozni voltál, ezért fizetned kell 10 000 Ft-ot"));
            case "Exam": 
               return(new Exam("Vizsga","Az összes olyan tárgyad sikeres lesz, ahol volt megszerzett tudásod."));
            case "GiveUpCourse": 
               return(new GiveUpCourse("Elengedés","Egy általad kiválasztott tárgy túl nehéznek bizonyult, ezért úgy döntesz nem folytatod tovább ebben a félévben, add le."));
            case "ImpossibleExam": 
                return(new ImpossibleExam("Lehetetlen vizsga","Egy véletlenszerűen kiválasztott tárgyból nagyon nehéz vizsgát kaptál ki, ezért elbuktad. A sikeres tárgyakat nem befolyásolja."));
            case "LuckyCardField": 
               return(new LuckyCardField("Kártya","Felhúzol egy szerencsekártyát"));
            case "NotAttended": 
               return(new NotAttended("4.hiányzás","Egy általad kiválasztott tárgyból összegyűlt a 4. hiányzásod, ezért azt a tárgyat elbuktad, add le."));
            case "Notes": 
                return(new Notes("Felsőbbéves jegyzete","Sikerült megszerezned egy felsőbb éves hallgató jegyzetét, ezért plusz tudásra teszel szert egy általad választott tárgyból"));
            case "Ousted": 
               return(new Ousted("Kitúrtak","Egy véletlenszerűen választott tárgyat töröl a játék a felvett tárgyaid közül"));
            case "StartField": 
               return(new StartField("Tárgyfelvétel/Start","Új félév, itt tudnak a játékosok tárgyakat felvenni"));
            case "WorkOrStudy": 
               return(new WorkOrStudy("Munka/tanulás","Kiválaszthatod, hogy dolgozol és pénzt kapsz (150 000 Ft) az adott mezőn, vagy tanulsz és tudást szerzel egy tárgyhoz"));
       
       }
       return null;
    }
    
}
