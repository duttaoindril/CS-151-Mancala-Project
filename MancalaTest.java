
/**
 * Entry point into the Mancala game application. Initializes the DataModel (model),
 * MancalaGUI (main view object), and Controller (controller).
 * 
 * @author Team 7
 *
 */
public class MancalaTest {
	public static void main(String[] args) {
		DataModel d = new DataModel();
		MancalaGUI g = new MancalaGUI();
		Controller c = new Controller(g, d);
	}
}