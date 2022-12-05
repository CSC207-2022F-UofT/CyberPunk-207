package UseCase.GlobalStatus;

import entity.Player;

import java.util.*;

public class Status implements StatusInputBoundary{

    private LinkedList<List<String>> globalStatus;
    private int turns;
    private final StatusOutputBoundary statusOutputBoundary;

    public Status(StatusOutputBoundary statusOutputBoundary) {
        globalStatus = new LinkedList<>();
        turns = 1;
        this.statusOutputBoundary = statusOutputBoundary;
    }


    public void updateHp(int hp, int PlayerNo) {
        int index = getIndex(PlayerNo);
        globalStatus.get(index).set(2, String.valueOf(hp));
        statusOutputBoundary.displayStatus(new StatusResponseModel(globalStatus, getHands()));
    }

    public void updateHandSize(int size, int PlayerNo) {
        int index = getIndex(PlayerNo);
        globalStatus.get(index).set(1, String.valueOf(size));
        statusOutputBoundary.displayStatus(new StatusResponseModel(globalStatus, getHands()));
    }

    public void updateEquipment(String type, String card, int PlayerNo) {
        int index = getIndex(PlayerNo);
        if(Objects.equals(type, "Weapon")){
            globalStatus.get(index).set(3, String.valueOf(card));
        }else if(Objects.equals(type, "Plus")){
            globalStatus.get(index).set(4, String.valueOf(card));
        }else{
        globalStatus.get(index).set(5, String.valueOf(card));
        }
        statusOutputBoundary.displayStatus(new StatusResponseModel(globalStatus, getHands()));
    }


    public void updateHand(String cards, int PlayerNo) {
        int index = getIndex(PlayerNo);
        globalStatus.get(index).set(6, cards);
        statusOutputBoundary.displayStatus(new StatusResponseModel(globalStatus, getHands()));
    }

    public int getIndex(int PlayerNo){
        int current = turns%5;
        int index = PlayerNo - current;
        if(index < 0 ){
            index = Math.abs(index);
        }
        return index;
    }

    @Override
    public void turnChange() {
        globalStatus.addLast(globalStatus.removeFirst());
        turns ++;
        statusOutputBoundary.displayStatus(new StatusResponseModel(globalStatus, getHands()));
    }

    public ArrayList<String> getHands(){
        String[] handCard1 =  globalStatus.get(0).get(6).trim().split(",");
        ArrayList<String> handCard = new ArrayList<>();
        Collections.addAll(handCard, handCard1);
        return handCard;
    }

    @Override
    public void init(List<Player> players) {
        for(Player player: players){
            player.setStatus(this);
            List<String> status = new ArrayList<>();
            HashMap<String, String> equipment = player.getEquipment();
            status.add("Player" + player.getPlayerNO());
            status.add(String.valueOf(player.getPocketCards().size()));// handsize for index1
            status.add(String.valueOf(player.getHp()));// hp for index2
            status.add(equipment.get("Weapon"));
            status.add(equipment.get("Plus"));
            status.add(equipment.get("Minus"));
            status.add(player.getPocketCardNames());
            globalStatus.add(status);
        }
    }
}
