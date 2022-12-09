package UseCase.UseCard;

import entity.Player;

/**
 * A request model incorporating all information of use card request
 * Contains three attributes: source player, No. of card to use, and No. of intended target player
 * Serve as input for use card method within input boundary, which handle the card use request
 **/
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
