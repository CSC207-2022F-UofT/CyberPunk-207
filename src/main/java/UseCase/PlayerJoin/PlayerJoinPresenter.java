package UseCase.PlayerJoin;

public class PlayerJoinPresenter implements PlayerJoinOutputBoundary {

    private PlayerJoinUpdatable UI;

    public PlayerJoinPresenter(PlayerJoinUpdatable UI) {
        this.UI = UI;
    }

    @Override
    public void playersJoin(PlayerJoinResponseModel playerJoinResponseModel) {
        PlayerJoinViewModel.getInstance().updateView(playerJoinResponseModel.getPlayersJoin(), playerJoinResponseModel.getRoleMap());
        UI.viewPlayers(PlayerJoinViewModel.getInstance());
    }
}
