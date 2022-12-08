package UseCase.EndTurn;

/**
 *An output boundary interface contains end turn method being implemented by presenter.
 **/
public interface EndTurnOutputBoundary {

    /**
     *Transmit end turn message and instructions (represented by end turn response model) to UI.
     **/
    void displayInstruction(EndTurnResponseModel endTurnResponseModel);
}
