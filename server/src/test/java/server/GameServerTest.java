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
    private static final PrintStream originalOut = System.out;
    
    @BeforeAll
    public  static void setUpStreams() 
    {
        System.setOut(new PrintStream(outContent));
    }
    
    @BeforeEach
    public void beforeEachTest() throws IOException, URISyntaxException, InterruptedException 
    {
        server=(new GameServer(spy(new Configuration("server.config")),10000));
        server.start();
        Thread.sleep(3);
    }
    
    
    @Test
    public void oneConnection() throws IOException, URISyntaxException, InterruptedException
    {
        
        Thread t1 = makeGameThread();
        t1.start();
        t1.join(); 
        server=(new GameServer(spy(new Configuration("server.config")),10000));
        server.start();

        assertEquals("test", outContent.toString().trim());
    }
    
    public Thread makeGameThread() throws InterruptedException
    {
        return new Thread(() -> {
            try(
                Socket s = new Socket("localhost", 12345);
                PrintWriter pw = new PrintWriter(s.getOutputStream());
            )
            {	
                pw.println("test");
                pw.flush();
            } catch (IOException ex) {
            }
        });
    }
    
    @AfterEach
    public void afterEach() throws InterruptedException
    {
        server.join();
    }
    
    @AfterAll
    public static void restoreStreams() 
    {
        System.setOut(originalOut);
    }        
}
