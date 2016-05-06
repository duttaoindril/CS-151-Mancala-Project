//cd C:\Users\Oindril Dutta\OneDrive\SJSU\Spring 2016\CS 151\Project
//cls && javac *.java && java MancalaTest && find . -name "*.class" -type f -delete

public class MancalaTest {
	public static void main(String[] args) {
		// create and hook up Change Board GUI so we can change color during game (Nan is working on this)
		// hook up color and stone selection functionality (Tom is working on this)
		DataModel d = new DataModel();
		MancalaGUI g = new MancalaGUI(new AlterRed()); // Fully Color In Board
		Controller c = new Controller(g, d);
	}
}