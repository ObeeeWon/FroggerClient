/* CLIENT INSTANCE */
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JLabel;

public class ClientService implements Runnable {
	
	//declare but not initialize the passed variables from
	//BankServer (we need to use the originals)
	private Socket s;
	private Character1 frog;
//	private Character2 car;//car setup
	private Character2 carArrays[];
	private Character2 carArrays2[];
	private Character2 carArrays3[];

//	private Character3 loggie;
	private Character3 logArrays[];
	private Character3 logArrays2[];
	private Character3 logArrays3[];	
	
	//JLabel
	private JLabel frogLabel, scoreLabel;
	private JLabel carLabels[], carLabels2[], carLabels3[];
	private JLabel logLabels[], logLabels2[], logLabels3[];
	
	//variables to process our incoming socket data
	private Scanner in;
	private PrintWriter out;
	
	private int tempScore;
	
	public ClientService() {}
	
	public ClientService(Socket s, Character1 c1, 
			Character2[] c2, Character2[] c3, Character2[] c4,
			Character3[] c5, Character3[] c6, Character3[] c7,
			JLabel fjl,
			JLabel[] cjl1, JLabel[] cjl2, JLabel[] cjl3,
			JLabel[] ljl1, JLabel[] ljl2, JLabel[] ljl3
				) {
		this.s = s;
		this.frog = c1;
		
		this.carArrays = c2;
		this.carArrays2 = c3;
		this.carArrays3 = c4;

//		Character3 loggie;
		this.logArrays = c5;
		this.logArrays2 = c6;
		this.logArrays3 = c7;
		
		//all labels here
		this.frogLabel = fjl;
		
		this.carLabels = cjl1;
		this.carLabels2 = cjl2;
		this.carLabels3 = cjl3;

		this.logLabels = ljl1;
		this.logLabels2 = ljl1;
		this.logLabels3 = ljl1;
	}
	
	public ClientService(Socket s2, String user_input, int tempScore, Character1 frog, JLabel frogLabel2, 
			
			Character2[] carArrays, Character2[] carArrays2, Character2[] carArrays3, 
			JLabel[] carLabels, JLabel[] carLabels2,JLabel[] carLabels3, 
			
			Character3[] logArrays, Character3[] logArrays2, Character3[] logArrays3,
			JLabel[] logLabels, JLabel[] logLabels2, JLabel[] logLabels3) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		
		try {
			in = new Scanner( s.getInputStream() );
			out = new PrintWriter ( s.getOutputStream() );
			processRequest();
	}	catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
	
	private void processRequest() {
		//need a loop to process the command tokens as they are
		//parsed one at a time
		while (true) {
			if ( !in.hasNext() ) return;
			
			//extract the first token (command)
			String command = in.next();//in.next() gets String
			
			excuteCommand(command);
		}
	}
	
	private void excuteCommand(String command) {
		if ( command.equals("FROGPOSITION")) {
			
			int x = in.nextInt();
			int y = in.nextInt();
			
			frog.setX(x);
			frog.setY(y);
			
			frogLabel.setLocation( x, y);

			return;
			
		} 
//		else if (command.equals("SCORE")) {
//			if( in.hasNextInt()) {
//				tempScore = in.nextInt();
//				scoreLabel.setText("score: " + tempScore);
//				System.out.println("Score updated to" + tempScore);
//				
//			}
//		}
		 else if ( command.equals("CARDATA")) {
		
			
			int x, y = 0;
			Boolean moving = true;
			
			x = in.nextInt();//first car's x
			y = in.nextInt();//first car's y
			moving = in.nextBoolean();//first car's y moving
			for(int i = 0; i < carArrays.length; i++) {
				carArrays[i].setX(x);
				carArrays[i].setY(y);
				carArrays[i].setMoving(moving);
				carLabels[i].setLocation(
						carLabels[i].getX(), carLabels[i].getY() );		

			}
			
			x = in.nextInt();//first car's x
			y = in.nextInt();//first car's y
			moving = in.nextBoolean();//first car's y moving
			for(int i = 0; i < carArrays2.length; i++) {
				carArrays2[i].setX(x);
				carArrays2[i].setY(y);
				carArrays2[i].setMoving(moving);
				carLabels2[i].setLocation(
						carLabels2[i].getX(), carLabels2[i].getY() );		

			}
			
			x = in.nextInt();//first car's x
			y = in.nextInt();//first car's y
			moving = in.nextBoolean();//first car's y moving
			for(int i = 0; i < carArrays3.length; i++) {
				carArrays3[i].setX(x);
				carArrays3[i].setY(y);
				carArrays3[i].setMoving(moving);
				carLabels3[i].setLocation(
						carLabels3[i].getX(), carLabels[i].getY() );		

			}

			return;
			
		} else if ( command.equals("LOGDATA")) {
			//open a socket to the client, send car arrays coordinates
			
			int x, y = 0;
			Boolean moving = true;
			
			x = in.nextInt();//first car's x
			y = in.nextInt();//first car's y
			moving = in.nextBoolean();//first car's y moving
			for(int i = 0; i < logArrays.length; i++) {
				logArrays[i].setX(x);
				logArrays[i].setY(y);
				logArrays[i].setMoving(moving);
				logLabels[i].setLocation(
						logLabels[i].getX(), logLabels[i].getY() );		

			}
			
			x = in.nextInt();//first car's x
			y = in.nextInt();//first car's y
			moving = in.nextBoolean();//first car's y moving
			for(int i = 0; i < logArrays2.length; i++) {
				logArrays2[i].setX(x);
				logArrays2[i].setY(y);
				logArrays2[i].setMoving(moving);
				logLabels2[i].setLocation(
						logLabels2[i].getX(), logLabels2[i].getY() );		

			}

			x = in.nextInt();//first car's x
			y = in.nextInt();//first car's y
			moving = in.nextBoolean();//first car's y moving
			for(int i = 0; i < logArrays3.length; i++) {
				logArrays3[i].setX(x);
				logArrays3[i].setY(y);
				logArrays3[i].setMoving(moving);
				logLabels3[i].setLocation(
						logLabels3[i].getX(), logLabels3[i].getY() );		

			}


			return;
			
		} else {
			System.out.println("NO MORE\n");
			return;
		}
	}
	
	
}
