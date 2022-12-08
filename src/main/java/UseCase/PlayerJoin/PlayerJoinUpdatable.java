package UseCase.PlayerJoin;

/**
 * An interface for UI to implement
 **/
public interface PlayerJoinUpdatable {

    /**
     * A viewer displaying player's role and type assignment
     * @param playerJoinResponseModel A response model containing player's role and type assignment
     **/
    void viewPlayers(PlayerJoinResponseModel playerJoinResponseModel);
}
