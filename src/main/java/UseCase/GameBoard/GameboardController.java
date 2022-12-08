package UseCase.GameBoard;

import UseCase.Identity;
import entity.Player;

import java.util.HashMap;
import java.util.List;

public class GameboardController {
    private GameboardInputBoundary gameboardInputBoundary;

    public GameboardController(GameboardInputBoundary gameboardInputBoundary) {
        this.gameboardInputBoundary = gameboardInputBoundary;
    }

    public void turnChange(){
        gameboardInputBoundary.turnChange();
    }

    public void startGame(List<Player> players, HashMap<Identity, List<Player>> roleMap){
        gameboardInputBoundary.startGame(new GameboardRequestModel(players, roleMap));
    }
}
