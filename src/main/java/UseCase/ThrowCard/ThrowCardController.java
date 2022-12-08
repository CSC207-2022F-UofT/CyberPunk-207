package UseCase.ThrowCard;

import entity.Player;

/**
 * ThrowCard use case's controller.
 **/
public class ThrowCardController {
    private ThrowInputBoundary throwInputBoundary;

    public ThrowCardController(ThrowInputBoundary throwInputBoundary) {
        this.throwInputBoundary = throwInputBoundary;
    }

    /**
     * Let input boundary handle throw card request by creating and passing a new request model containing two attributes:
     * source player and No. of card to throw
     * @param player source player
     * @param card An integer attribute representing No. of card intended to throw
     **/
    public void throwCard(Player player, int card){
        throwInputBoundary.throwCard(new ThrowCardRequestModel(card, player));
    }
}
