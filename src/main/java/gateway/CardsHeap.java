package gateway;

import entity.Card;

import java.util.ArrayList;
import java.util.List;

public class CardsHeap {
    private List<Card> Cards = new ArrayList<>();
    public Card draw(int i) {
        return Cards.get(i);
    }
}
