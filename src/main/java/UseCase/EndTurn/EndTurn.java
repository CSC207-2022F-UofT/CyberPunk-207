package UseCase.EndTurn;

public class EndTurn implements EndTurnInputBoundary {
    private EndTurnOutputBoundary endTurnOutputBoundary;

    public EndTurn(EndTurnOutputBoundary endTurnOutputBoundarye){
        this.endTurnOutputBoundary = endTurnOutputBoundarye;
    }

    @Override
    public void endTurn(EndTurnRequestModel endTurnRequestModel) {
        int numOfThrow = endTurnRequestModel.getPlayer().needThrow();
        if(numOfThrow > 0){
            String message = String.format("You need to throw %d Card(s), then click end turn", numOfThrow);
            endTurnOutputBoundary.displayInstruction(new EndTurnResponseModel(false, message ));
        }else {
            endTurnOutputBoundary.displayInstruction(new EndTurnResponseModel(true, ""));
        }
    }


}
