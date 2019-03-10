import java.io.*;
import java.util.*;
import java.net.*;

class DummyClient {
	public static void main(String[] args) throws Exception {
		String MACHINE = "localhost";

		int PORT = 12345;
		

		try (
			Socket socket = new Socket(MACHINE, PORT);
			InputStream inp = socket.getInputStream();
			BufferedReader brinp = new BufferedReader(new InputStreamReader(inp));
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
		) {
			out.writeBytes( "kecske\n\r");
			out.flush();

			String valasz = brinp.readLine();


			System.out.println(valasz);
			Thread.sleep(10000);
			System.out.println("sleep over");

		}
	}
}
