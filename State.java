
/**
 * Encapsulates game data for passing model state to the view.
 * 
 * @author Team 7
 *
 */
public class State {
    private int playerA;
    private int playerB;
    private boolean playerTurn;
    private int[] pitPoints;
    private boolean izNull = false;

    /**
     * Initializes a State object with the current game state.
     * 
     * @param d		A reference to the model whose state is being saved.
     */
    public State(DataModel d) {
        if(d == null)
            izNull = true;
        else {
            playerA = d.getPlayerAScore();
            playerB = d.getPlayerBScore();
            pitPoints = d.getPits();
            playerTurn = d.getPlayerTurn();
        }
    }

    /**
     * Initializes a State object with a given array of player scores
     * and the current player.
     * 
     * @param data		An array of ints representing current player scores.
     * @param player	The player whose turn is currently is.
     */
	public State(int[] data, boolean player) {
        playerTurn = player;
        playerA = data[0];
        playerB = data[1];
        for(int i = 0; i < pitPoints.length; i++)
            pitPoints[i] = data[i+2];
    }

	/**
	 * Checks if the State is null.
	 * 
	 * @return		State of the State.
	 */
    public boolean isNull() {
        return izNull;
    }

    /**
     * Gets a list of stone counts per pit from the saved game state.
     * 
     * @return		An array of ints for stone counts per pit from the saved game state.
     */
    public int[] getPits() {
        return pitPoints;
    }

    /**
     * Gets a player A's score from the saved game state.
     * 
     * @return		An int representing player A's score from the saved game state.
     */
    public int getAScore() {
        return playerA;
    }

    /**
     * Gets a player B's score from the saved game state.
     * 
     * @return		An int representing player B's score from the saved game state.
     */
    public int getBScore() {
        return playerB;
    }

    /**
     * Gets the player turn state from the saved game state.
     * 
     * @return		The player turn state represening whose turn it was in the saved game state.
     */
    public boolean getTurn() {
        return playerTurn;
    }
}