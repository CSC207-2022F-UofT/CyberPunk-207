package UseCase.PlayerJoin;

/**
 * An output boundary interface contains method displaying player's role and type assignment
 * Implemented by presenter.
 **/
public interface PlayerJoinOutputBoundary {
    /**
     * Transmit information of player's role and type assignment (represented by login response model) to UI.
     * @param playerJoinResponseModel a response model
     **/
    void playersJoin(PlayerJoinResponseModel playerJoinResponseModel);
}
