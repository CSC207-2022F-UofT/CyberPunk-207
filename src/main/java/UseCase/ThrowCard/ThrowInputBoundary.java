package UseCase.ThrowCard;

/**
 * An input boundary interface handling throw card request
 * Implemented by ThrowCard class.
 **/
public interface ThrowInputBoundary {

    /**
     * Handle throw card request by letting the player loose the card
     * @param throwCardRequestModel A request model containing player and card to throw
     **/
    void throwCard(ThrowCardRequestModel throwCardRequestModel);
}
