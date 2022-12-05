package UseCase.GlobalStatus;

public class StatusPresenter implements StatusOutputBoundary{
    private StatusUpdatable UI;

    public StatusPresenter(StatusUpdatable UI) {
        this.UI = UI;
    }

    @Override
    public void displayStatus(StatusResponseModel statusResponseModel) {
        UI.viewStatus(statusResponseModel);
    }
}
