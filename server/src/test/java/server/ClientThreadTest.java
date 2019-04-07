package server;
import com.gameofelte.server.ClientThread;
import com.gameofelte.server.GameServer;
import com.gameofelte.util.Configuration;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.spy;


public class ClientThreadTest {
    private ClientThread thread;
    private Socket socket, clientSocket;
    private PrintWriter pw;
    private Scanner sc;
            
    @BeforeEach
    public void beforeEach() throws Exception
    {
        try(ServerSocket ss = new ServerSocket(12345))
        {
            socket = new Socket("localhost", 12345);
            clientSocket = ss.accept();
            sc = new Scanner(clientSocket.getInputStream());

            thread = new ClientThread(socket, null);
        }
        
        //dummy = new DummyClient();
        //dummy.start();
       
    }
    
    @AfterEach
    public void afterEach() throws Exception
    {
        clientSocket.close();
        socket.close();
        thread.join();
        //dummy.join();
    }
    
    @Test
    public void randomNumberTest()
    {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        
        thread.sendRandomNumbers(list);
        
        assertEquals(sc.nextLine(), "RANDOM_NUMBERS;1,2,3");
    }
    
    @Test
    public void setMoneyTest()
    {
        int amountTest = 1000;
        thread.setMoney(amountTest);
        
        assertEquals(sc.nextLine(), "SET_MONEY;" + amountTest);
    }
    
    @Test
    public void beginLearnSubjectTest() {
        thread.beginLearnSubject();
        
        assertEquals(sc.nextLine(), "LEARN_SUBJECT");
        
    }
    
    @Test
    public void beginWorkOrStudyChoiceTest() {
        thread.beginWorkOrStudyChoice();
        
        assertEquals(sc.nextLine(),"WORK_OR_STUDY");
    }
    
    @Test
    public void beginCourseRequestTest() {
       thread.beginCourseRequest();
       
       assertEquals(sc.nextLine(),"COURSE_REQUEST");
    }
    
    @Test
    public void beginLosingKnowledgeTest() {
        thread.beginLosingKnowledge();
        
        assertEquals(sc.nextLine(),"LOSING_KNOWLEDGE");
    }

    @Test
    public void beginOfferedMarkTest() {
       thread.beginOfferedMark();
       
       assertEquals(sc.nextLine(),"OFFERED_MARK");
    }

    @Test
    public void beginMatekingChoiceTest() {
       thread.beginMatekingChoice();
       
       assertEquals(sc.nextLine(),"MATEKING_CHOICE");
    }

    @Test
    public void beginOvertimeWorkTest() {
        thread.beginOvertimeWork();
        
        assertEquals(sc.nextLine(),"OVERTIME_WORK");
    }

    @Test
    public void beginUnregisterSubjectTest() {
        thread.beginUnregisterSubject();
        
        assertEquals(sc.nextLine(),"UNREGISTER_SUBJECT");
    }
    
    @Test
    public void sendColorTest() 
    {
        
        int color = 1;
        thread.sendColor(color);
        assertEquals(sc.nextLine(),"COLOR;" + color);
    }

    @Test
    public void showSubjectRegistrationWindowTest() 
    {
        thread.showSubjectRegistrationWindow();
        
        assertEquals(sc.nextLine(),"SHOW_SUBJECT_REGISTRATION_WINDOW");
    }

    @Test
    public void activateTest() 
    {
        thread.activate();
        
        assertEquals(sc.nextLine(),"ACTIVATE");
    }
    
}