package UseCase.EndTurn;

import entity.Player;

public class EndTurnController {
    private EndTurnInputBoundary endTurnInputBoundary;

    public EndTurnController(EndTurnInputBoundary endTurnInputBoundary) {
        this.endTurnInputBoundary = endTurnInputBoundary;
    }

    public void endTurn(Player player){
        endTurnInputBoundary.endTurn(new EndTurnRequestModel(player));
    }
}
