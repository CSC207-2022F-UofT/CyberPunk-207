package presenter;

import UI.GamePage;
import UI.GamePageCompo.OtherPlayers;
import UI.GamePageCompo.panel1;
import manager.OutputBoundary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class Presenter implements OutputBoundary {

    OtherPlayers op;
    panel1 p1;

    GamePage gp;

    @Override
    public void displayGlobalStatus(LinkedList<List<String>> globalStatus) {

        //Display player numbers
        displayMainName(globalStatus.get(0).get(0));
        displayOtherNames(putOtherNames(globalStatus));

        //Display main player pocket cards
        displayHand(putPocketCards(globalStatus));

        //Display HP

    }



    @Override
    public void displayInstruction(String s) {
        p1.displayIns(s);
    }


    @Override
    public void displayRound(int rd) {
        p1.displayRD(rd);
    }

    public void displayMainName(String nm) {
        p1.displayName(nm);
    }

    public void displayOtherNames(List<String> names) {
        gp.displayOtherNames(names);
    }
    @Override
    public void displayHand (ArrayList<String> lc) {
        p1.displayPc(lc);
    }

    public void displayHP(LinkedList<List<String>> globalStatus) {
        List<String> hps = new ArrayList<>();
        for(int i = 0 ; i < 5; i++) {
            hps.add(globalStatus.get(i).get(2));
        }
        p1.displayHP(hps.get(0));
        gp.displayHP(hps.subList(1,4));
    }
    @Override
    public void showChief() {

    }

    private List<String> putOtherNames(LinkedList<List<String>> globalStatus) {
        List<String> on = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            on.add(globalStatus.get(i).get(0));
        }
        return on;
    }


    private ArrayList<String> putPocketCards(LinkedList<List<String>> globalStatus) {
        String[] names  = globalStatus.get(0).get(6).split(",");
        ArrayList<String> handCard = new ArrayList<>();
        Collections.addAll(handCard, names);
        return handCard;
    }
}