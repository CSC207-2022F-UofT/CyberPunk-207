package presenter;

import UI.GamePageCompo.OtherPlayers;
import UI.GamePageCompo.panel1;
import manager.Gameboard;
import manager.Identity;
import manager.OutputBoundary;

import java.util.ArrayList;
import java.util.LinkedList;
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

    public void displayRoles() {

    }
    @Override
    public Object displayEquipment(Object equipment) { return equipment;}
    @Override
    public void displayName(String name) {

    }


    @Override
    public void displayRound() {

    }

    @Override
    public void displayGlobalStatus(LinkedList<List<String>> globalStatus) {

    }

    @Override
    public void displayRole(Identity role) {


    public void displayPocket(List<String> pc) {
        p1.displayPc(pc);
    }


    @Override
    public ArrayList<String> displayHand(ArrayList<String> lc) {
        return lc;
    }



}
