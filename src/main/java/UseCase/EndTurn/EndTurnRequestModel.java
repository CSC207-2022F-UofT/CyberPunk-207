package UseCase.EndTurn;

import entity.Player;

/**
 * A request model of end turn, containing player attribute
 * Serve as input for end turn method within input boundary
 **/
public class EndTurnRequestModel {
    private Player player;

    public EndTurnRequestModel(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }
}
