package util;

import com.gameofelte.util.Configuration;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;


public class ConfigurationTest 
{
    
    @Test
    void configInitTest()
    {
        Configuration config=null;
        try 
        {
          config = new Configuration("server.config");
        } catch (FileNotFoundException ex) {
            fail("File not found");
        } catch (URISyntaxException ex) {
            fail();        
        }
        assertTrue(config.get("port").equals("12345"));
        assertTrue(config.get("players").equals("2"));
        assertTrue(config.get("fields").equals("StartField|Course|Course|Course|Ousted|Course|Course|Course|CourseRequest|WorkOrStudy|BadDate|WorkOrStudy|"
                + "LuckyCardField|WorkOrStudy|Entertainment|WorkOrStudy|NotAttended|WorkOrStudy|GiveUpCourse|WorkOrStudy|LuckyCardField|"
                + "WorkOrStudy|Entertainment|WorkOrStudy|Notes|Exam|Exam|Exam|Exam|ImpossibleExam|Exam|Exam"
        ));
    
    }
    
    
    @Test
    void emptyConfigTest()
    {
        Configuration config=null;
        try 
        {
          config = new Configuration("empty.config");
        } catch (FileNotFoundException ex) {
            fail("File not found");
        } catch (URISyntaxException ex) {
            fail();        
        }
        assertNull(config.get("port"));
        assertNull(config.get("players"));
        assertNull(config.get("fields"));
    }
    
    @Test
    void noConfigFileTest()
    {
        assertThrows(FileNotFoundException.class,
        ()->{
            Configuration config = new Configuration("nothing.config");
        });
    }
    
}
