package UseCase.UseCard;

/**
 * An input boundary interface handling use card request
 * Including setting card's source and target, identifying whether the player used shoot, use the card and loose the card afterwards
 * Implemented by UseCard class.
 **/
public interface UseCardInputBoundary {
    /**
     * Handle card use request. Setup source and target of card based on input.
     * Check whether the player used shoot before. If so, end and send message to output boundary
     * Use the card and loose the card.
     * @param useCardRequestModel A request model containing player, card to use and target player information
     **/
    void useCard(UseCardRequestModel useCardRequestModel);
}
