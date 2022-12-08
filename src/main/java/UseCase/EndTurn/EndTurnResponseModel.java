package UseCase.EndTurn;

/**
 *A response model of end turn, containing information of whether proceed to next turn and message passing to UI
 * Serve as input for display instruction method of output boundary
 **/
public class EndTurnResponseModel {
    /** A boolean attribute indicating whether the player is free to end turn (if hand size equals hp) **/
    private  Boolean nextTurn;
    private String message;

    public EndTurnResponseModel(Boolean nextTurn, String message) {
        this.nextTurn = nextTurn;
        this.message = message;
    }

    public Boolean getNextTurn() {
        return nextTurn;
    }

    public String getMessage() {
        return message;
    }
}
