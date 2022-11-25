package manager;

public interface OutputBoundary {
    void displayHand();
    void displayStatus();// use notifier
    void displayUsedCard();
    void displayPlayer();
    void displayGlobal();
    void displayLog();
    void output(String s);
}
