package entity;

import manager.PlayerManager;

import java.util.ArrayList;
import java.util.List;

public interface Listener {
    public void update();

    void updateHp(int hp);

    void updateHand(ArrayList<Card> cards);

    void updateHandSize(int size);

    void updateAlivePeople(List<PlayerManager> players);

    void updateAlivePeopleSize(int size);

    void updateCardHeap(int size);

    void updateEquipment(String type, equipment_card card);
}
