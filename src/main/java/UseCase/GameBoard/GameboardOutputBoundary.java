package UseCase.GameBoard;

/**
 *An output boundary interface contains display turn change method being implemented by presenter.
 **/
public interface GameboardOutputBoundary {

    /**
     * Transmit all information of current gameboard (represented by end turn response model) to UI.
     * @param gameboardResponseModel a response model
     **/
    void displayTurnChange(GameboardResponseModel gameboardResponseModel);
}
