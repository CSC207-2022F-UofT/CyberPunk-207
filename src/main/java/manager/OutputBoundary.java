package manager;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public interface OutputBoundary {


    String displayInstruction(String s);

    ArrayList<String> displayHand(ArrayList<String> l);

    void displayRound();

    void displayGlobalStatus(LinkedList<List<String>> globalStatus);

    void displayRole(Identity role);

    void displayRoles();


}
