package entity;

import java.util.ArrayList;

public class Player {
    private int hp;
    private int handlimit;
    private ArrayList<Card> pocketcards;
    private String role;
    private boolean status;

    public Player() {
        this.hp = 3;
        this.handlimit = hp;
        this.pocketcards = new ArrayList<>();
        this.role = null;
        this.status = true;
    }


    public void drawCards(int num) {
    }
}
