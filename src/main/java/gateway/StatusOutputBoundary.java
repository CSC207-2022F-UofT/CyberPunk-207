package gateway;

import java.util.LinkedList;
import java.util.List;

public interface StatusOutputBoundary {
    void displayGlobalStatus(LinkedList<List<String>> globalStatus);
}
