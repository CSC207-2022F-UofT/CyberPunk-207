package presenter;

import UI.GamePageCompo.OtherPlayers;
import UI.GamePageCompo.panel1;
import manager.Gameboard;
import manager.OutputBoundary;

import java.util.ArrayList;
import java.util.List;


public class Presenter implements OutputBoundary {

    OtherPlayers op;
    panel1 p1;

    @Override
    public void displayInstruction(String s){
        p1.displayIns(s);
    }
    @Override
    public void displayHp(int hp){
        p1.displayHP(String.valueOf(hp));
    }
    @Override
    public Object displayEquipment(Object equipment) { return equipment;}
    @Override
    public void displayName(String name) {

    }
    @Override
    public String displayRole(String role){
        return role;
    }

    @Override
    public boolean isPolice(boolean ispolice) {return ispolice;}
    @Override
    public ArrayList<Integer> displayOthersHp(ArrayList<Integer> lhp){
        return lhp;
    }


    public void displayPocket(List<String> pc) {
        p1.displayPc(pc);
    }



    @Override
    public String displayPhaseStage(String s) {
        return s;
    }

    @Override
    public String displayLog(String s) {
        return s;
    }


    @Override
    public void output(String output) {
            System.out.println(output);
    }
}
