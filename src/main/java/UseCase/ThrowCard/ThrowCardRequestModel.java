package UseCase.ThrowCard;

import entity.Player;

public class ThrowCardRequestModel {
    private int card;
    private Player player;

    public ThrowCardRequestModel(int card, Player player) {
        this.card = card;
        this.player = player;
    }

    public int getCard() {
        return card;
    }

    public Player getPlayer() {
        return player;
    }
}
