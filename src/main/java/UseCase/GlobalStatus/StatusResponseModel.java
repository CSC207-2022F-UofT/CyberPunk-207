package UseCase.GlobalStatus;

import java.util.LinkedList;
import java.util.List;

public class StatusResponseModel {
    private LinkedList<List<String>> GlobalStatus;

    public StatusResponseModel(LinkedList<List<String>> globalStatus) {
        GlobalStatus = globalStatus;
    }

    public LinkedList<List<String>> getGlobalStatus() {
        return GlobalStatus;
    }
}
