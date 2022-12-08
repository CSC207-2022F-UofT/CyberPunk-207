package UseCase.UseCard;

import entity.Player;

public class UseCardRequestModel {
    private Player player;
    private int card;
    private int target;

    public UseCardRequestModel(Player player, int card, int target) {
        this.player = player;
        this.card = card;
        this.target = target;
    }

    public Player getPlayer() {
        return player;
    }

    public int getCard() {
        return card;
    }

    public int getTarget() {
        return target;
    }
}
