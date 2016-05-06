//cd C:\Users\Oindril Dutta\OneDrive\SJSU\Spring 2016\CS 151\Project
//cls && javac *.java && java MancalaTest && find . -name "*.class" -type f -delete

public class MancalaTest {
	public static void main(String[] args) {
		// create and hook up Change Board GUI so we can change color during game (Nan is working on this)
		// JavaDocs and comments and we done!
		DataModel d = new DataModel();
		MancalaGUI g = new MancalaGUI();
		Controller c = new Controller(g, d);
	}
}