package UseCase.GameBoard;

/**
 * An interface for UI to implement
 **/
public interface GameboardUpdatable {
    /**
     * A viewer displaying all information of current game board
     * @param gameboardViewModel A view model containing all information of current game board
     **/
    void viewGameboard(GameboardViewModel gameboardViewModel);
}
