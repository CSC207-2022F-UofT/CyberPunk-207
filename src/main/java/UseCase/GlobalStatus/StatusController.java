package UseCase.GlobalStatus;

import entity.Player;

import java.util.List;

/**
 * Status use case's controller.
 **/
public class StatusController {
    private StatusInputBoundary statusInputBoundary;

    public StatusController(StatusInputBoundary statusInputBoundary) {
        this.statusInputBoundary = statusInputBoundary;
    }

    /**
     * Let input boundary change turn
     **/
    public void turnChange(){
        statusInputBoundary.turnChange();
    }

    /**
     * Let input boundary initialize global status of certain players
     * @param players List of players of which status to be initialized
     **/
    public void init(List<Player> players){
        statusInputBoundary.init(players);
    }
}
