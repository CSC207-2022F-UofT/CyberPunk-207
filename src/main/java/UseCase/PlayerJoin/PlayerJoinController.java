package UseCase.PlayerJoin;

/**
 * PlayerJoin use case's controller.
 **/
public class PlayerJoinController {
    private final PlayerJoinInputBoundary playerJoinInputBoundary;

    public PlayerJoinController(PlayerJoinInputBoundary playerJoinInputBoundary) {
        this.playerJoinInputBoundary = playerJoinInputBoundary;
    }

    /**
     * Let input boundary initialize player's roles and type, by creating and passing a new request model containing number of human player attended
     * @param numOfHuman An integer representing number of human player attended
     **/
    public void playersJoin(int numOfHuman){
        playerJoinInputBoundary.playersJoin(new PlayerJoinRequestModel(numOfHuman));
    }
}
