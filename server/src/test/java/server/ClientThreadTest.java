package server;
import com.gameofelte.server.ClientThread;
import com.gameofelte.server.GameServer;
import com.gameofelte.util.Configuration;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.spy;


public class ClientThreadTest {
    private ClientThread thread;
    private GameServer server;
    private Socket socket;
    private PrintWriter pw;
    private Scanner sc;
    private DummyClient dummy;
    /*        
    @BeforeEach
    public void beforeEach() throws Exception
    {
        server = spy(new GameServer(spy(new Configuration("server.config")),6000));
        server.start();
        socket = new Socket("localhost", 12345);
        pw = new PrintWriter(socket.getOutputStream(),true);
        sc = new Scanner(socket.getInputStream());
        
        thread = new ClientThread(socket,server);
        thread.start();
        
        //dummy = new DummyClient();
        //dummy.start();
       
    }
    
    @AfterEach
    public void afterEach() throws Exception
    {
        pw.close();
        sc.close();
        socket.close();
        thread.join();
        server.join();
        //dummy.join();
    }
        
    // TODO  , lehet timeoutot kell rakni rajuk a while true-k miatt assert utan?
    @Test
    public void threadRunTest()
    {
        
    }
    
    @Test
    public void randomNumberTest()
    {
        
    }
    
    @Test
    public void luckyCardTest()
    {
        
    }
    
    @Test
    public void sendBoardTest()
    {
        
    }
    
    @Test
    public void sendGameOverTest()
    {
        
    }
    */
}
