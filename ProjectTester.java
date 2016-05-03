//cd C:\Users\Oindril Dutta\OneDrive\SJSU\Spring 2016\CS 151\Project
//cls && javac *.java && java ProjectTester && find . -name "*.class" -type f -delete

public class ProjectTester {
	public static void main(String[] args){
		// Add in GUI to select num of stones and GUI Skin
		DataModel d = new DataModel();
		MancalaGUI g = new MancalaGUI(new MancalaColorOrange()); // Fully Color In Board
		Controller c = new Controller(g, d);
	}
}