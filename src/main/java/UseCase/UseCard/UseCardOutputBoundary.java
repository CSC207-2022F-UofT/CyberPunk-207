package UseCase.UseCard;

/**
 * An output boundary interface displaying message that shoot has already been used
 * Implemented by presenter.
 **/
public interface UseCardOutputBoundary {
     /**
      * Transmit message information (incorporated in use card response model) to UI.
      * @param useCardResponseModel a response model
      **/
     void displayInstruction(UseCardResponseModel useCardResponseModel);
}
