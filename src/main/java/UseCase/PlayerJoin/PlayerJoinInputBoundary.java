package UseCase.PlayerJoin;

/**
 * An input boundary interface assigning player's role and type (human or AI) based on how many players attend the game
 * Implemented by PlayerJoin class.
 **/
public interface PlayerJoinInputBoundary {
    /**
     * Assign player's role randomly. Based on input of request model, if number of players is smaller than 5 then add AI players.
     * After initialization, create and send a new response model incorporating role and player information to output boundary.
     * @param playerJoinRequestModel A request model input
     **/
    void playersJoin(PlayerJoinRequestModel playerJoinRequestModel);
}
