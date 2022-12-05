package UseCase.EndTurn;

public class EndTurnPresenter implements EndTurnOutputBoundary{
    private EndTurnUpdatable UI;

    public EndTurnPresenter(EndTurnUpdatable UI) {
        this.UI = UI;
    }

    @Override
    public void displayInstruction(EndTurnResponseModel endTurnResponseModel) {
        UI.throwView(endTurnResponseModel);
    }
}
