package UseCase.EndTurn;

import entity.Player;

public class EndTurnRequestModel {
    private Player player;

    public EndTurnRequestModel(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }
}
