package manager;

import java.util.ArrayList;
import java.util.List;

public interface OutputBoundary {


    void displayPocket(List<String> pc);

    String displayInstruction(String s);

    int displayHp(int hp);

    Object displayEquipment(Object equipment);

    String displayName(String name);

    String displayRole(String role);

    boolean isPolice(boolean ispolice);

    ArrayList<Integer> displayOthersHp(ArrayList<Integer> lhp);

    String displayPhaseStage(String s);

    String displayLog(String s);

    void output(String s);
}
