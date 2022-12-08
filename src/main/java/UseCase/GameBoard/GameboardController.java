package UseCase.GameBoard;

import entity.Identity;
import entity.Player;

import java.util.HashMap;
import java.util.List;

/**
 *Game board use case's controller.
 **/
public class GameboardController {
    private GameboardInputBoundary gameboardInputBoundary;

    public GameboardController(GameboardInputBoundary gameboardInputBoundary) {
        this.gameboardInputBoundary = gameboardInputBoundary;
    }

    /**
     *Let input boundary change turn
     **/
    public void turnChange(){
        gameboardInputBoundary.turnChange();
    }

    /**
     *Let input boundary execute the start game method towards a new request model, initialized by list of players and role map
     * @param players List of players to be incorporate in request model
     * @param roleMap A hash map containing each role's corresponding players, to be incorporate in request model
     **/
    public void startGame(List<Player> players, HashMap<Identity, List<Player>> roleMap){
        gameboardInputBoundary.startGame(new GameboardRequestModel(players, roleMap));
    }
}
