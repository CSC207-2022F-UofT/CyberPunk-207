package Gateway;

import UseCase.UseCard.UseCardViewModel;

/**
 * An interface for UI to implement
 **/
public interface UseCardUpdatable {
    /**
     * A viewer displaying message that may occur during card usage period
     * @param useCardViewModel A view model containing the message if the source player has already played shoot
     **/
    void viewCard(UseCardViewModel useCardViewModel);
}
