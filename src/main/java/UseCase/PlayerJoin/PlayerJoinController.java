package UseCase.PlayerJoin;

public class PlayerJoinController {
    private final PlayerJoinInputBoundary playerJoinInputBoundary;

    public PlayerJoinController(PlayerJoinInputBoundary playerJoinInputBoundary) {
        this.playerJoinInputBoundary = playerJoinInputBoundary;
    }

    public void playersJoin(int numOfHuman){
        playerJoinInputBoundary.playersJoin(new PlayerJoinRequestModel(numOfHuman));
    }
}
