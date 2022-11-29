package presenter;

import entity.Card;
import manager.OutputBoundary;
import manager.PlayerManager;

import java.util.ArrayList;

public class Presenter implements OutputBoundary {

    private PlayerManager plm;



//    public String displayIcon() {
//
//    }

    @Override
    public void displayHand() {
    }

    @Override
    public void displayStatus() {

    }

    @Override
    public void displayUsedCard() {

    }

    @Override
    public void displayPlayer() {

    }

    @Override
    public void displayGlobal() {

    }

    @Override
    public void displayLog() {

    }

    @Override
    public void output(String output) {
            System.out.println(output);
    }
}
