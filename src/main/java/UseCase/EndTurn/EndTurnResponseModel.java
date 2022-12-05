package UseCase.EndTurn;

public class EndTurnResponseModel {
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
