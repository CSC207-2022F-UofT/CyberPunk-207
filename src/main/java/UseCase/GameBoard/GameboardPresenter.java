package UseCase.GameBoard;

import UseCase.EndTurn.EndTurnResponseModel;
import UseCase.EndTurn.EndTurnViewModel;

/**
 * Presenter of game board use case which implements output boundary.
 * Contain a method letting UI display the game board when turn change
 **/
public class GameboardPresenter implements GameboardOutputBoundary {
    private GameboardUpdatable UI;

    public GameboardPresenter(GameboardUpdatable UI) {
        this.UI = UI;
    }

    /**
     * Transmit all information of current gameboard (represented by end turn response model) to UI.
     *
     * @param gameboardResponseModel a response model
     **/
    @Override
    public void displayTurnChange(GameboardResponseModel gameboardResponseModel) {
        GameboardViewModel.getInstance().updateView(gameboardResponseModel.getTargetList(),
                gameboardResponseModel.getRoleExist(),
                gameboardResponseModel.isEnd(),
                gameboardResponseModel.isDead(),
                gameboardResponseModel.getCurrentPlayer(),
                gameboardResponseModel.getPlayerRole(),
                gameboardResponseModel.getStrategy());
        UI.viewGameboard(GameboardViewModel.getInstance());
    }

}
