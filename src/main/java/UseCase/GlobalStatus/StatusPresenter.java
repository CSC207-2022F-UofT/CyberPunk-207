package UseCase.GlobalStatus;

import Gateway.StatusUpdatable;

/**
 * Presenter of global status use case which implements output boundary
 * Contain a method letting UI display the status
 **/
public class StatusPresenter implements StatusOutputBoundary{
    private StatusUpdatable UI;

    public StatusPresenter(StatusUpdatable UI) {
        this.UI = UI;
    }

    /**
     * Transmit all information of current status (represented by status response model).
     * @param statusResponseModel a response model
     **/
    @Override
    public void displayStatus(StatusResponseModel statusResponseModel) {
        GlobalStatusViewModel.getInstance().updateView(statusResponseModel.getGlobalStatus(), statusResponseModel.getHands());
        UI.viewStatus(GlobalStatusViewModel.getInstance());
    }
}
