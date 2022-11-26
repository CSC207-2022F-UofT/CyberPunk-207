package manager;

import entity.Card;

import java.util.ArrayList;

public interface OutputBoundary {
    void displayHand();

    void displayStatus();// use notifier
    void displayUsedCard();
    void displayPlayer();
    void displayGlobal();
    void displayLog();
    void output(String s);
}
