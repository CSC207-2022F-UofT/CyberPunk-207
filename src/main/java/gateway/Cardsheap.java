package gateway;

import entity.Card;
import entity.Shoot;
import entity.Dodge;
import entity.Medkit;
import entity.Shootout;
import entity.Policeraid;
import entity.Traumateam;
import entity.Destruction;
import entity.Lottery;
import entity.Robbery;
import entity.R99MachineGun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static java.util.Collections.shuffle;
import static java.util.Collections.swap;

public class Cardsheap {

    private static ArrayList<Card> drawCards = new ArrayList<>(); //Cards to be drawn
    private static final ArrayList<Card> usedCards = new ArrayList<>(); //Cards already been used
    private static final ArrayList<Card> allCards = new ArrayList<>(); //All cards
    private static int numCards = 0;


    // Add certain number of cards to drawCards and allCards
    public static void addCard(Class<? extends Card> cls, int num) {
        int count = 0;
        Card c = cls.getConstructor();
        while (count < num) {
            drawCards.add(c);
            allCards.add(c);
            count += 1;
        }
    }

    public static void addBasicCards() {
        addCard(Shoot.class, 30);
        addCard(Dodge.class, 15);
        addCard(Medkit.class, 8);
    }

    public static void addStrategyCards() {
        addCard(Destruction.class, 6);
        addCard(Robbery.class, 6);
        addCard(Lottery.class, 4);
        addCard(Policeraid.class, 4);
        addCard(Shootout.class, 2);
        addCard(Traumateam.class, 1);
    }

    public static void addEquipmentCards() {
        addCard(R99MachineGun.class, 2);
    }

    //Initialize the cards heap.
    public static void init() {
        addBasicCards();
        addStrategyCards();
        addEquipmentCards();
        shuffle();
        numCards = drawCards.size();
    }

    //Draw one card from card heap
    public static Card draw() {
        //If no cards left in drawCards, add all used cards to drawCards
        if (drawCards.isEmpty()) {
            drawCards.addAll(usedCards);
            shuffle();
            usedCards.clear();
        }
        Card c = drawCards.get(0);
        c.setTaken(false);
        drawCards.remove(0);
        return c;
    }

    //Draw multiple cards from card heap
    public static ArrayList<Card> draw(int num) {
        ArrayList<Card> cs = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            cs.add(draw());
        }
        return cs;
    }

    //Discard one card, add it to usedCards
    public static void discard(Card c){
        usedCards.add(0, c);
    }

    public static void discard(ArrayList<Card> cs){
        usedCards.addAll(0, cs);
    }

    public static ArrayList<Card> getDrawCards(int num) {
        if (num > drawCards.size()) {
            shuffle();
        }
        return drawCards;
    }

    private static void shuffle() {
        Random r = new Random();
        for (int i = 77; i >= 1; i--){
            swap(allCards, i, r.nextInt(i));
        }
    }

    public static ArrayList<Card> getUsedCards() {
        return usedCards;
    }

    public static void setDrawCards(ArrayList<Card> drawCards) {
        Cardsheap.drawCards = drawCards;
    }

    public static int getNumCards() {
        return numCards;
    }

    public static ArrayList<Card> getAllCards() {
        return allCards;
    }
}
