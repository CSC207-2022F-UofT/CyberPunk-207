package UseCase.UseCard;

public class UseCardPresenter implements UseCardOutputBoundary{
    private UseCardUpdatable UI;

    public UseCardPresenter(UseCardUpdatable UI) {
        this.UI = UI;
    }

    @Override
    public void displayInstruction(UseCardResponseModel useCardResponseModel) {
        UI.view(useCardResponseModel);
    }
}
