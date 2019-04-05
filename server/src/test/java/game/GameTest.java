package game;

import com.gameofelte.game.Game;
import com.gameofelte.server.GameServer;
import com.gameofelte.util.Configuration;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.spy;


public class GameTest {
    
    private GameServer server;
    private Game game;
    private Configuration config;
            
    @BeforeEach
    public void beforeEach() throws Exception
    {
        config = spy(new Configuration("server.config"));
        server = spy(new GameServer(config,6000));
        server.start();
        game = new Game(server,2,config.get("fields"));
    }
    
    @AfterEach
    public void afterEach() throws Exception
    {
        server.join();
    }
    
    
    @Test
    public void randomNumberTest()
    {
        List<Integer>random1=game.generateRandomNumbers();
        List<Integer>random2=game.generateRandomNumbers();
        int sum1 = 0;
        int sum2 = 0;
        for(Integer i : random1){ sum1+=i;}
        for(Integer i : random2){ sum2+=i;}
        assertEquals(sum1,sum2);
        assertNotEquals(random1,random2);
        

    }
    
}
