package UseCase.EndTurn;

/**
 *An input boundary interface contains end turn method being implemented by EndTurn class.
 **/
public interface EndTurnInputBoundary {

    /**
     * Check if player need to throw card.
     * If so, pass the output boundary with a response model variable with next turn equals false, meaning not to enter next turn
     * Otherwise, pass the output boundary with a response model variable with next turn equals ture, meaning entering next turn
     * @param endTurnRequestModel An End Turn Request Model containing player information
     **/
    void endTurn(EndTurnRequestModel endTurnRequestModel);
}
