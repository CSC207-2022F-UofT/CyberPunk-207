package UseCase.ThrowCard;

import entity.Player;

/**
 * ThrowCard use case, handling throw card request
 **/
public class ThrowCard implements ThrowInputBoundary {
    /**
     * Handle throw card request by letting the player loose the card
     * @param throwCardRequestModel A request model containing player and card to throw
     **/
    @Override
    public void throwCard(ThrowCardRequestModel throwCardRequestModel) {
        Player player = throwCardRequestModel.getPlayer();
        int card = throwCardRequestModel.getCard();
        player.looseCard(card);
    }
}
