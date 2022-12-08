package UseCase.GlobalStatus;

import entity.Player;

import java.util.List;

public class StatusController {
    private StatusInputBoundary statusInputBoundary;

    public StatusController(StatusInputBoundary statusInputBoundary) {
        this.statusInputBoundary = statusInputBoundary;
    }

    public void turnChange(){
        statusInputBoundary.turnChange();
    }

    public void init(List<Player> players){
        statusInputBoundary.init(players);
    }
}
