package UseCase.GameBoard;

/**
 * Presenter of game board use case which implements output boundary.
 * Contain a method letting UI display the game board when turn change
 **/
public class GameboardPresenter implements GameboardOutputBoundary{
    private GameboardUpdatable UI;

    public GameboardPresenter(GameboardUpdatable UI) {
        this.UI = UI;
    }

    /**
     * Transmit all information of current gameboard (represented by end turn response model).
     * @param gameboardResponseModel a response model
     **/
    @Override
    public void displayTurnChange(GameboardResponseModel gameboardResponseModel) {
        UI.viewGameboard(gameboardResponseModel);
    }
}
