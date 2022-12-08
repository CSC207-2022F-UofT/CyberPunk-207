package UseCase.UseCard;

import UseCase.EndTurn.EndTurnViewModel;

public class UseCardViewModel {
   private static UseCardViewModel instance;

    private String message;

    public void updateView(String message) {
        this.message = message;
    }

    public static UseCardViewModel getInstance(){
        if(instance == null){
            instance = new UseCardViewModel();
        }
        return instance;
    }
    public String getMessage() {
        return message;
    }
}
