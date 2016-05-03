//cd C:\Users\Oindril Dutta\OneDrive\SJSU\Spring 2016\CS 151\Project
//cls && javac *.java && java MancalaTest && find . -name "*.class" -type f -delete

public class MancalaTest {
	public static void main(String[] args) {
		// Implement proper undo methods
		// Add in GUI to select num of stones (3, 4) and GUI Skin
		// Add in all options to colors to skins, including custom color.
		DataModel d = new DataModel();
		MancalaGUI g = new MancalaGUI(new MancalaColorOrange()); // Fully Color In Board
		Controller c = new Controller(g, d);
	}
}