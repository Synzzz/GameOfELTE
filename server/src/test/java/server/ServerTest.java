package server;

import com.gameofelte.server.Server;
import com.gameofelte.util.Configuration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;


public class ServerTest {
    private Server server = null;
    private Configuration config = null;
    
    @BeforeEach
    public void beforeEachTest() 
    {
        try {
            config = Mockito.spy(new Configuration("server.config"));
            server = new Server(config);
        } catch (Exception ex) {
            fail();
        }
    }
    
    // TODO @Test
    
    
}
