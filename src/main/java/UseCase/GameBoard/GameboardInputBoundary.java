package UseCase.GameBoard;

/**
 *An input boundary interface contains start game and change turn methods being implemented by GameboardInteractor class.
 **/
public interface GameboardInputBoundary {

    /**
     * Initialize game. Initialize card heap and allocate cards to players
     * Start turn of first player.
     * Call display method in output boundary to display the current gameboard information
     * @param gameboardRequestModel A request model containing player and role information
     **/
    void startGame(GameboardRequestModel gameboardRequestModel);

    /**
     * Change turn method. Reset current player to the next player. Make the new current player draw two cards.
     * Call display method in output boundary to display the current gameboard information
     **/
    void turnChange();
}
