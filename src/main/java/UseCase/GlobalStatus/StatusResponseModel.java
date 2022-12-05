package UseCase.GlobalStatus;

import java.util.LinkedList;
import java.util.List;

public class StatusResponseModel {
    private LinkedList<List<String>> globalStatus;
    private List<String> hands;

    public StatusResponseModel(LinkedList<List<String>> globalStatus, List<String> hands) {
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
