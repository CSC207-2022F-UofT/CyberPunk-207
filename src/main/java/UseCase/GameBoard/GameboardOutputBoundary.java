package UseCase.GameBoard;

/**
 *An output boundary interface contains dislay turn change method being implemented by presenter.
 **/
public interface GameboardOutputBoundary {

    void displayTurnChange(GameboardResponseModel gameboardResponseModel);
}
