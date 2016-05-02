public class State {
    private int playerA;
    private int playerB;
    private boolean playerTurn;
    private int[] pitPoints;

    public State(DataModel d) {
        playerA = d.getPlayerAScore();
        playerB = d.getPlayerBScore();
        pitPoints = d.getPits();
        playerTurn = d.getPlayerTurn();
    }

	public State(int[] data, boolean player) {
        playerTurn = player;
        playerA = data[0];
        playerB = data[1];
        for(int i = 0; i < pitPoints.length; i++)
            pitPoints[i] = data[i+2];
    }

    public int[] getPits() {
        return pitPoints;
    }

    public int getAScore() {
        return playerA;
    }

    public int getBScore() {
        return playerB;
    }

    public boolean getTurn() {
        return playerTurn;
    }
}