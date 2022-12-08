package UseCase.GlobalStatus;

public class StatusPresenter implements StatusOutputBoundary{
    private StatusUpdatable UI;

    public StatusPresenter(StatusUpdatable UI) {
        this.UI = UI;
    }

    @Override
    public void displayStatus(StatusResponseModel statusResponseModel) {
        GlobalStatusViewModel.getInstance().updateView(statusResponseModel.getGlobalStatus(), statusResponseModel.getHands());
        UI.viewStatus(GlobalStatusViewModel.getInstance());
    }
}
