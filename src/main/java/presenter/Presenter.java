package presenter;

import manager.OutputBoundary;

import java.util.ArrayList;


public class Presenter implements OutputBoundary {

    @Override
    public String displayInstruction(String s){
        return s;
    }
    @Override
    public int displayHp(int hp){
        return hp;
    }
    @Override
    public ArrayList<String> displayHand(ArrayList<String> lc) {
        return lc;
    }
    @Override
    public Object displayEquipment(Object equipment) { return equipment;}
    @Override
    public String displayName(String name) {
        return name;
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
