package gateway;

import entity.CarBomb;
import entity.Card;

import java.util.ArrayList;
import java.util.List;

public class CardsHeap {
    private List<Card> Cards = new ArrayList<>();
    public Card draw(int i) {
        Card card = new CarBomb();
        Card card2 = new CarBomb();
        Card card3= new CarBomb();
        Card card4= new CarBomb();

        Cards.add(card);
        Cards.add(card2);
        Cards.add(card4);
        Cards.add(card3);
        return Cards.get(i);
    }
}
