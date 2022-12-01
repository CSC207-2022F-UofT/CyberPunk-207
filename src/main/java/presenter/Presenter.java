package presenter;

import manager.Identity;
import manager.OutputBoundary;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Presenter implements OutputBoundary {

    @Override
    public String displayInstruction(String s){
        return s;
    }

    public void displayRoles() {

    }


    @Override
    public void displayRound() {

    }

    @Override
    public void displayGlobalStatus(LinkedList<List<String>> globalStatus) {

    }

    @Override
    public void displayRole(Identity role) {

    }


    @Override
    public ArrayList<String> displayHand(ArrayList<String> lc) {
        return lc;
    }



}
