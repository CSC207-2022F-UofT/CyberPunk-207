package UseCase.PlayerJoin;

public class PlayerJoinPresenter implements PlayerJoinOutputBoundary {

    private PlayerJoinUpdatable UI;

    public PlayerJoinPresenter(PlayerJoinUpdatable UI) {
        this.UI = UI;
    }

    @Override
    public void playersJoin(PlayerJoinResponseModel playerJoinResponseModel) {
        UI.viewPlayers(playerJoinResponseModel);
    }
}
