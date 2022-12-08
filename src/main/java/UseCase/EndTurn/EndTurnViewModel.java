package UseCase.EndTurn;

public class EndTurnViewModel {
    private static EndTurnViewModel instance;
    private  Boolean nextTurn;
    private String message;

    public static EndTurnViewModel getInstance(){
        if(instance == null){
            instance = new EndTurnViewModel();
        }
        return instance;
    }

    public void updateView(Boolean nextTurn, String message){
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
