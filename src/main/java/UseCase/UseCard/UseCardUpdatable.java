package UseCase.UseCard;

/**
 * An interface for UI to implement
 **/
public interface UseCardUpdatable {
    /**
     * A viewer displaying message that may occur during card usage period
     * @param useCardResponseModel A response model containing the message if the source player has already played shoot
     **/
    void viewCard(UseCardResponseModel useCardResponseModel);
}
