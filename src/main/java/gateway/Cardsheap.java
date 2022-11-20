package gateway;
import entity.*;

import java.util.ArrayList;
import java.util.Collections;

public class Cardsheap {

    private static ArrayList<Card> drawCards = new ArrayList<>(); //Cards to be drawn
    private static ArrayList<Card> usedCards = new ArrayList<>(); //Cards already been used
    private static ArrayList<Card> allCards = new ArrayList<>(); //All cards
    private static int numCards = 0;


    // Add certain number of cards to drawCards and allCards
    public static void addCard(Card c, int num) {
        int count = 0;
        while (count < num) {
            drawCards.add(c);
            allCards.add(c);
            count += 1;
        }
    }

    public static void addBasicCards() {
        addCard(new Shoot(), 30);
        addCard(new Dodge(), 15);
        addCard(new Medkit(), 8);
    }

    public static void addStrategyCards() {
        addCard(new Destruction(), 6);
        addCard(new Robbery(), 6);
        addCard(new Lottery(), 4);
        addCard(new Policeraid(), 4);
        addCard(new Shootout(), 2);
        addCard(new Traumateam(), 1);
    }

    public static void addEquipmentCards() {
        addCard(new R99MachineGun(), 2);
        addCard(new CarBomb(), 2);
    }

    //Initialize the cards heap.
    public static void init() {
        addBasicCards();
        addStrategyCards();
        addEquipmentCards();
        Collections.shuffle(drawCards);
        numCards = drawCards.size();
    }

    //Draw one card from card heap
    public static Card draw() {
        //If no cards left in drawCards, add all used cards to drawCards
        if (drawCards.isEmpty()) {
            drawCards.addAll(usedCards);
            Collections.shuffle(drawCards);
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
            drawCards.addAll(usedCards);
            Collections.shuffle(drawCards);
            usedCards.clear();
        }
        return drawCards;
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
