package entity;

import manager.Gameboard;
import manager.PlayerManager;

import java.util.*;

public class Status{
    private ArrayList<String> pocketcards;
    private LinkedList<List<String>> GlobalStatus;
    private Gameboard gameboard;
    private int turns;

    public Status(Gameboard gameboard) {
        this.gameboard = gameboard;
        LinkedList<List<String>> GlobalStatus = new LinkedList<>();
        this.pocketcards = new ArrayList<>();
        turns = 1;
    }



    public void updateHp(int hp, int PlayerNo) {
        int index = getIndex(PlayerNo);
        GlobalStatus.get(index).set(2, String.valueOf(hp));
        gameboard.updateGlobal(GlobalStatus);
    }

    public void updateHandSize(int size, int PlayerNo) {
        int index = getIndex(PlayerNo);
        GlobalStatus.get(index).set(1, String.valueOf(size));
        gameboard.updateGlobal(GlobalStatus);
    }

    public void updateEquipment(String type, String card, int PlayerNo) {
        int index = getIndex(PlayerNo);
        if(Objects.equals(type, "Weapon")){
            GlobalStatus.get(index).set(3, String.valueOf(card));
        }else if(Objects.equals(type, "Plus")){
            GlobalStatus.get(index).set(4, String.valueOf(card));
        }else{
        GlobalStatus.get(index).set(5, String.valueOf(card));
        }
        gameboard.updateGlobal(GlobalStatus);
    }


    public void updateHand(String cards, int PlayerNo) {
        int index = getIndex(PlayerNo);
        GlobalStatus.get(index).set(6, cards);
        gameboard.updateHand(getHands());
    }

    public int getIndex(int PlayerNo){
        int current = turns%5;
        int index = PlayerNo - current;
        if(index < 0 ){
            index = Math.abs(index);
        }
        return index;
    }

    public void turnChange() {
        GlobalStatus.addLast(GlobalStatus.removeFirst());
        turns ++;
        gameboard.updateGlobal(GlobalStatus);
    }

    public ArrayList<String> getHands(){
        String[] handCard1 =  GlobalStatus.get(0).get(6).split(",");
        ArrayList<String> handCard = new ArrayList<>();
        Collections.addAll(handCard, handCard1);
        return handCard;
    }

    public void init(List<PlayerManager> players) {
        for(PlayerManager player: players){
            List<String> status = new ArrayList<>();
            HashMap<String, String> equipment = player.getEquipment();
            status.add("Player" + player.getPlayerNO());
            status.add(String.valueOf(player.getPocketcards().size()));// handsize for index1
            status.add(String.valueOf(player.getHp()));// hp for index2
            status.add(equipment.get("Weapon"));
            status.add(equipment.get("Plus"));
            status.add(equipment.get("Minus"));
            status.add(player.getPocketcardnames());
            GlobalStatus.add(status);
        }
    }
}
