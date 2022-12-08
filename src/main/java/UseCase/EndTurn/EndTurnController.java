package UseCase.EndTurn;

import entity.Player;

/**
 *End turn use case's controller.
 **/
public class EndTurnController {
    private EndTurnInputBoundary endTurnInputBoundary;

    public EndTurnController(EndTurnInputBoundary endTurnInputBoundary) {
        this.endTurnInputBoundary = endTurnInputBoundary;
    }

    /**
     *Let input boundary execute end turn function, towards a new request model instance corresponding to the player
     * @param player The player who wish to end turn
     **/
    public void endTurn(Player player){
        endTurnInputBoundary.endTurn(new EndTurnRequestModel(player));
    }
}
