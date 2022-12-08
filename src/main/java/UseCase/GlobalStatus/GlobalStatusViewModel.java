package UseCase.GlobalStatus;

import java.util.LinkedList;
import java.util.List;

public class GlobalStatusViewModel {

    private static GlobalStatusViewModel instance;

    private LinkedList<List<String>> globalStatus;
    private List<String> hands;

    public static GlobalStatusViewModel getInstance(){
        if(instance == null){
            instance = new GlobalStatusViewModel();
        }
        return instance;
    }
    public void updateView(LinkedList<List<String>> globalStatus, List<String> hands) {
        this.globalStatus = globalStatus;
        this.hands = hands;
    }

    public LinkedList<List<String>> getGlobalStatus() {
        return globalStatus;
    }

    public List<String> getHands() {
        return hands;
    }
}
