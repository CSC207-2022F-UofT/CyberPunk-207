package UseCase.PlayerJoin;

public class PlayerJoinRequestModel {
    private int numOfHuman;

    public PlayerJoinRequestModel(int numOfHuman) {
        this.numOfHuman = numOfHuman;
    }

    public int getNumOfHuman() {
        return numOfHuman;
    }
}
