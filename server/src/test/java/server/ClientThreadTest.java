package server;
import com.gameofelte.game.Field;
import com.gameofelte.game.FieldFactory;
import com.gameofelte.game.LuckyCard;
import com.gameofelte.game.LuckyCardFactory;
import com.gameofelte.server.ClientThread;
import com.gameofelte.server.GameServer;
import com.gameofelte.server.Message;
import com.gameofelte.server.Response;
import com.gameofelte.server.ResponseType;
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
    private ServerSocket ss;
    private Socket socket, clientSocket;
    private PrintWriter pw;
    private Scanner sc;
            
    @BeforeEach
    public void beforeEach() throws Exception
    {
        ss = new ServerSocket(12345);
        socket = new Socket("localhost", 12345);
        clientSocket = ss.accept();
        sc = new Scanner(clientSocket.getInputStream());

        thread = new ClientThread(socket, null);

        //dummy = new DummyClient();
        //dummy.start();
       
    }
    
    @AfterEach
    public void afterEach() throws Exception
    {
        
        clientSocket.close();
        socket.close();
        ss.close();
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
    
    @Test
    public void sendMessageTest()
    {
        Message msg = new Message("COMMAND", "DATA", null);
        
        thread.sendMessage(msg);
        
        assertEquals(sc.nextLine(), "COMMAND;DATA");
    }
    
    @Test
    public void getSocketTest()
    {
        assertEquals(thread.getSocket(), socket);
    }
    
    @Test
    public void sendResponseOKTest()
    {
        Response response = new Response(ResponseType.OK);
        thread.sendResponse(response);
        
        assertEquals(sc.nextLine(), "RESPONSE;OK|null");
    }
    
    @Test
    public void sendResponseERRORTest()
    {
        Response response = new Response(ResponseType.ERROR, "ERROR_MSG");
        thread.sendResponse(response);
        
        assertEquals(sc.nextLine(), "RESPONSE;ERROR|ERROR_MSG");
    }
    
    @Test
    public void sendLuckyCardsTest()
    {
        List<LuckyCard> luckyCards = new ArrayList<>();
        luckyCards.add(LuckyCardFactory.makeLuckyCard("Cheating"));
        luckyCards.add(LuckyCardFactory.makeLuckyCard("FourthCourseRequest"));
       
        thread.sendLuckyCards(luckyCards);
        
        assertEquals(sc.nextLine(), "LUCKY_CARDS;Puskázás|Rajtakaptak, hogy puskázol, ezért egy véletlenszerűen kiválasztott tárgyat elbuksz.|false,Negyedik tárgyfelvétel|Ez egy megtartható kártya. Ha egy tárgy nem sikerül 3. tárgyfelvételre sem, akkor felhasználható egyszer.|true");
    }
    
    @Test
    public void sendBoardTest()
    {
        List<Field> fields = new ArrayList<>();
        fields.add(FieldFactory.makeField("BadDate"));
        fields.add(FieldFactory.makeField("CourseRequest"));
       
        thread.sendBoard(fields);
        
        assertEquals(sc.nextLine(), "FIELDS;Rossz időpont|Egy általad kiválasztott tárgy rossz időpontban van, ezért leadod,Tárgyfelvétel kérvény|Ha még van olyan tárgy, amit nem sikerült felvenned, itt megteheted");
    }
    
    @Test
    public void sendGameOverTest()
    {
        List<Integer> scoreboard = new ArrayList<>();
        scoreboard.add(0);
        scoreboard.add(1);
        scoreboard.add(2);
       
        thread.sendGameOver(scoreboard);
        
        assertEquals(sc.nextLine(), "GAME_OVER;0,1,2");
    }
    
}