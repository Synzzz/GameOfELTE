package server;

import com.gameofelte.server.GameServer;
import com.gameofelte.util.Configuration;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import static org.mockito.Mockito.spy;


public class GameServerTest {
    private GameServer server;
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final PrintStream outPs=new PrintStream(outContent);
    private static final PrintStream originalOut = System.out;
    
    @BeforeAll
    public  static void setUpStreams() 
    {
        System.setOut(outPs);
    }
    
    
    @Test
    public void oneConnection() throws IOException, URISyntaxException, InterruptedException
    {
        server=new GameServer(spy(new Configuration("server.config")),6000);
        server.start();
        Thread t1 = new DummyClient();
        t1.start();
        t1.join(3000);
        server.join();

        assertEquals("test", outContent.toString().trim());
    }
    
    
    
    @AfterAll
    public static void restoreStreams() 
    {
        System.setOut(originalOut);
    }   

}
