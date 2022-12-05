package UseCase.GameBoard;

public class GameboardPresenter implements GameboardOutputBoundary{
    private GameboardUpdatable UI;

    public GameboardPresenter(GameboardUpdatable UI) {
        this.UI = UI;
    }

    @Override
    public void displayTurnChange(GameboardResponseModel gameboardResponseModel) {
        UI.viewGameboard(gameboardResponseModel);
    }
}
