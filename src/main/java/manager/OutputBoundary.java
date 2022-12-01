package manager;

import java.util.ArrayList;
import java.util.List;

public interface OutputBoundary {


    void displayPocket(List<String> pc);

    void displayInstruction(String s);

    void displayHp(int hp);

    Object displayEquipment(Object equipment);

    void displayName(String name);

    String displayRole(String role);

    boolean isPolice(boolean ispolice);

    ArrayList<Integer> displayOthersHp(ArrayList<Integer> lhp);

    String displayPhaseStage(String s);

    String displayLog(String s);

    void output(String s);


}
