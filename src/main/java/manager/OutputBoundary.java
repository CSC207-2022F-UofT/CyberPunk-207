package manager;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public interface OutputBoundary {


    void displayInstruction(String s);

   void displayHand(ArrayList<String> l);

    void displayGlobalStatus(LinkedList<List<String>> globalStatus);

    void displayMainName(String name);

    void displayOtherNames(List<String> names);

    void displayRound(int round);

    void showChief();

}
