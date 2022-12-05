package UseCase.GameBoard;

public interface GameboardInputBoundary {

    void startGame(GameboardRequestModel gameboardRequestModel);
    void turnChange();
}
