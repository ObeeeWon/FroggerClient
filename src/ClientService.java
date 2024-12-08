import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JLabel;

//processing routine on server (B)
public class ClientService implements Runnable {

	private Socket s;
	private Scanner in;
	private Character1 FrogerGrogu;
	private JLabel frogLabel;
	
	public ClientService (Socket aSocket, Character1 FrogerGrogu, JLabel frogLabel) {
		this.s = aSocket;
		this.FrogerGrogu = FrogerGrogu;
		this.frogLabel = frogLabel;
		
	}
		
	public void run() {
		
		try {
			in = new Scanner(s.getInputStream());
			processRequest( );
		} catch (IOException e){
			e.printStackTrace();
		} finally {
			try {
				s.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	//processing the requests
	public void processRequest () throws IOException {
		//if next request is empty then return
		while(true) {
			if(!in.hasNext( )){
				return;
			}
			String command = in.next();
			if (command.equals("Quit")) {
				return;
			} else {
				executeCommand(command);
			}
		}
	}
	
	public void executeCommand(String command) throws IOException{
	
		
		if ( command.equals("MOVEFROG")) {
			int playerNo = in.nextInt();
			String playerAction = in.next();
			int playerX = in.nextInt();
			int playerY = in.nextInt();
			System.out.println("=== sending command : " + command + " ===");
			//here is the format of the command
			System.out.println("Player "+playerNo+" "+playerAction + " "+playerX+", "+playerY);
			
			//SET POSITION FOR FROG AND MOVE IT!
			FrogerGrogu.setX(playerX);
			FrogerGrogu.setY(playerY);
			

			updateFrogLabel();

		}
	}
	
	public void updateFrogLabel() {
		if(frogLabel != null){
		frogLabel.setLocation(FrogerGrogu.getX(), FrogerGrogu.getY());// Grogu blink!
		} else {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
