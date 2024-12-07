/* CLIENT INSTANCE */

public class Character1 extends Frogger_Sprite {

	private Frogger_GamePrepClient FrogGameClient;

	public Character1() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Character1(int x, int y, int height, int width, String image, 
			Frogger_GamePrepClient FrogGameClient) {
		super(x, y, height, width, image);
		
		this.FrogGameClient = FrogGameClient;
		// TODO Auto-generated constructor stub
		
	}
	
	//Add a setter and getter, so that it can be use in ClientServer
	public void setFrogGameClient (Frogger_GamePrepClient temp) {
		this.FrogGameClient = temp;
	}
	
	public Frogger_GamePrepClient getFrogGameClient() {
		return this.FrogGameClient;
	}
	

}
