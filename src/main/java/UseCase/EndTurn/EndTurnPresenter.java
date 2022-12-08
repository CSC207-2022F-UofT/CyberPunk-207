package UseCase.EndTurn;

public class EndTurnPresenter implements EndTurnOutputBoundary{
    private EndTurnUpdatable UI;

    public EndTurnPresenter(EndTurnUpdatable UI) {
        this.UI = UI;
    }

    @Override
    public void displayInstruction(EndTurnResponseModel endTurnResponseModel) {
        EndTurnViewModel.getInstance().updateView(endTurnResponseModel.getNextTurn(),endTurnResponseModel.getMessage());
        UI.throwView(EndTurnViewModel.getInstance());
    }
}
