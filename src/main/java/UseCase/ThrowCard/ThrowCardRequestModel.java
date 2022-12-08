package UseCase.ThrowCard;

import entity.Player;

/**
 * A request model incorporating all information of throw card request. Contains two attributes: source player and No. of card to throw
 * Serve as input for throw card method within input boundary, which handle the throw card request
 **/
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
