package UseCase.PlayerJoin;

/**
 * Presenter of player join use case which implements output boundary
 * Contain a method letting UI display the result of player's role and type assignment, incorporated in a response model
 **/
public class PlayerJoinPresenter implements PlayerJoinOutputBoundary {

    private PlayerJoinUpdatable UI;

    public PlayerJoinPresenter(PlayerJoinUpdatable UI) {
        this.UI = UI;
    }

    /**
     * Transmit information of player's role and type assignment (represented by login response model) to UI.
     * @param playerJoinResponseModel a response model
     **/
    @Override
    public void playersJoin(PlayerJoinResponseModel playerJoinResponseModel) {
        UI.viewPlayers(playerJoinResponseModel);
    }
}
