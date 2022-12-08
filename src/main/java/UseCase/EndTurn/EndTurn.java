package UseCase.EndTurn;

/**
 *End turn use case. Player need to throw certain number of cards so that the hand size equals to hp
 **/
public class EndTurn implements EndTurnInputBoundary {
    /** An Output Boundary attribute transmitting information to presenter **/
    private EndTurnOutputBoundary endTurnOutputBoundary;

    public EndTurn(EndTurnOutputBoundary endTurnOutputBoundary){
        this.endTurnOutputBoundary = endTurnOutputBoundary;
    }

    /**
     * Check if player need to throw card.
     * If so, pass the output boundary with a response model variable with next turn equals false, meaning not entering next turn
     * Otherwise, pass the output boundary with a response model variable with next turn equals ture, meaning entering next turn
     * @param endTurnRequestModel An End Turn Request Model containing player information
     **/
    @Override
    public void endTurn(EndTurnRequestModel endTurnRequestModel) {
        int numOfThrow = endTurnRequestModel.getPlayer().needThrow();
        endTurnRequestModel.getPlayer().setUseShoot(false);
        if(numOfThrow > 0){
            String message = String.format("You need to throw %d Card(s), then click end turn", numOfThrow);
            endTurnOutputBoundary.displayInstruction(new EndTurnResponseModel(false, message ));
        }else {
            endTurnOutputBoundary.displayInstruction(new EndTurnResponseModel(true, ""));
        }
    }

}
