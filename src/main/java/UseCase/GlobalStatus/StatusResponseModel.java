package UseCase.GlobalStatus;

import java.util.LinkedList;
import java.util.List;

/**
 * A response model of end turn, containing current status (incorporating all related information, see Status class) and hand cards for all players
 **/
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
