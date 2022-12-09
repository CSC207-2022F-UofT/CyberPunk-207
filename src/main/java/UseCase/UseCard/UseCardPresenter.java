package UseCase.UseCard;

/**
 * Presenter of player join use case which implements output boundary
 * Contain a method of letting UI displaying the message if shoot has already been used
 **/
public class UseCardPresenter implements UseCardOutputBoundary{
    private UseCardUpdatable UI;

    public UseCardPresenter(UseCardUpdatable UI) {
        this.UI = UI;
    }

    /**
     * Transmit message information (incorporated in use card response model) to UI.
     * @param useCardResponseModel a response model
     **/
    @Override
    public void displayInstruction(UseCardResponseModel useCardResponseModel) {
        UseCardViewModel.getInstance().updateView(useCardResponseModel.getMessage());
        UI.viewCard(UseCardViewModel.getInstance());
    }
}
