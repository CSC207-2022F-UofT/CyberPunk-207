package UseCase.PlayerJoin;

/**
 * A request model of player join, containing number of human player attended the game
 * Serve as input for player join method within input boundary, which initializing player's role and type
 **/
public class PlayerJoinRequestModel {
    private int numOfHuman;

    public PlayerJoinRequestModel(int numOfHuman) {
        this.numOfHuman = numOfHuman;
    }

    public int getNumOfHuman() {
        return numOfHuman;
    }
}
