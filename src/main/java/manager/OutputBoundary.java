package manager;

import java.util.ArrayList;

public interface OutputBoundary {


    String displayInstruction(String s);
    ArrayList<String> displayHand(ArrayList<String> l);
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
