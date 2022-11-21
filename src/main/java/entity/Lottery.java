package entity;

import gateway.CardsHeap;

public class Lottery extends strategy_card{
    public void use(){
        Card c1 = CardsHeap.draw();
        Card c2 = CardsHeap.draw();
        getTarget().addCard(c1);
        getTarget().addCard(c2);
    }

    @Override
    public String toString() {
        return "Lottery";
    }
}
