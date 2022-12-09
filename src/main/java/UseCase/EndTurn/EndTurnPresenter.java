package UseCase.EndTurn;

import Gateway.EndTurnUpdatable;

/**
 * Presenter of end turn use case which implements output boundary.
 * Let UI display message and instructions after the player decide to end turn
 **/
public class EndTurnPresenter implements EndTurnOutputBoundary{
    private EndTurnUpdatable UI;

    public EndTurnPresenter(EndTurnUpdatable UI) {
        this.UI = UI;
    }

    /**
     * Transmit end turn message and instructions (represented by end turn response model) to UI.
     * @param endTurnResponseModel A response model containing end turn message and instructions
     **/
    @Override
    public void displayInstruction(EndTurnResponseModel endTurnResponseModel) {
        EndTurnViewModel.getInstance().updateView(endTurnResponseModel.getNextTurn(),endTurnResponseModel.getMessage());
        UI.throwView(EndTurnViewModel.getInstance());
    }
}
