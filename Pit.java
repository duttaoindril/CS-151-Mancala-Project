
/**
 * Representation of a pit and its stone count.
 * 
 * @author Team 7
 *
 */
public class Pit {
    private int score;

    /**
     * Creates a pit with the given number of stones.
     * 
     * @param i		Number of stones.
     */
	public Pit(int i) {
        score = i;
    }

	/**
	 * Gets the number of stones in the pit.
	 * 
	 * @return		Number of stones in the pit as an int.
	 */
    public int getScore() {
        return score;
    }

    /**
     * Sets the number of stones in the pit to a given value.
     * 
     * @param i		New stone count for the pit.
     */
    public void setScore(int i) {
        score = i;
    }
}