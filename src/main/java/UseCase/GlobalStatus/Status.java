package UseCase.GlobalStatus;

import entity.Player;

import java.util.*;

/**
 * Status use case. Contains methods updating player's hp, handsize, equipment, etc.
 * Also contains initializer method initializing global status of all players at start of game
 **/
public class Status implements StatusInputBoundary{

    /** A linkedlist of list attribute storing all player's current status
     * Sequence of linkedlist is updated every turn
     * Each player's status is stored in a list. The list consists of:
     * 0 Player No; 1 Hand size; 2 Hp; 3,4,5 Three Equipments (Hashmap);
     * 6 Cards in hand (A string separating cards by comma); 7 Role **/
    private LinkedList<List<String>> globalStatus;
    private int turns;
    private final StatusOutputBoundary statusOutputBoundary;

    public Status(StatusOutputBoundary statusOutputBoundary) {
        globalStatus = new LinkedList<>();
        turns = 0;
        this.statusOutputBoundary = statusOutputBoundary;
    }

    /**
     * Update certain player's hp status
     * @param hp An integer of new hp to be updated
     * @param PlayerNo An integer of player's No
     **/
    public void updateHp(int hp, int PlayerNo) {
        int index = getIndex(PlayerNo);
        globalStatus.get(index).set(2, String.valueOf(hp));
        statusOutputBoundary.displayStatus(new StatusResponseModel(globalStatus, getHands()));
    }

    /**
     * Update certain player's hand size status
     * @param size An integer of new hand size to be updated
     * @param PlayerNo An integer of player's No
     **/
    public void updateHandSize(int size, int PlayerNo) {
        int index = getIndex(PlayerNo);
        globalStatus.get(index).set(1, String.valueOf(size));
        statusOutputBoundary.displayStatus(new StatusResponseModel(globalStatus, getHands()));
    }

    /**
     * Update certain player's equipment status, with respect to certain equipment type (Weapon, Plus or Minus)
     * @param type A string of equipment's type to be added
     * @param card A string of equipment card to be added
     * @param PlayerNo An integer of player's No
     **/
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

    /**
     * Update certain player's hand card status
     * @param cards A string representing a player's card to be updated
     * @param PlayerNo An integer of player's No
     **/
    public void updateHand(String cards, int PlayerNo) {
        int index = getIndex(PlayerNo);
        globalStatus.get(index).set(6, cards);
        statusOutputBoundary.displayStatus(new StatusResponseModel(globalStatus, getHands()));
    }

    /**
     * A helper function getting certain player's index within the global status
     * The sequence of player is unchanged in global status, but changes in each turn
     * @param PlayerNo An integer of player's No
     * @return An integer of player's index
     **/
    public int getIndex(int PlayerNo){
        int current = turns%5;
        int index = PlayerNo - 1  - current;
        if(index < 0 ){
            index = 5 + index;
        }
        return index;
    }

    /**
     * Change global status when changing turn
     * Including rolling the sequence of global status forward for one player, and add one to the turns attribute
     **/
    @Override
    public void turnChange() {
        globalStatus.addLast(globalStatus.removeFirst());
        turns ++;
        statusOutputBoundary.displayStatus(new StatusResponseModel(globalStatus, getHands()));
    }

    /**
     * A helper function returning all player's card in hand.
     * This function helps use case methods create new response model and transmit to output boundary
     * @return An array list of string representing all player's hand card (stored in 6th within each player's global status)
     **/
    public ArrayList<String> getHands(){
        String[] handCard1 =  globalStatus.get(0).get(6).trim().split(",");
        ArrayList<String> handCard = new ArrayList<>();
        Collections.addAll(handCard, handCard1);
        return handCard;
    }

    /**
     * Initialize global status at the start of game
     * @param players List of players within current game
     **/
    @Override
    public void init(List<Player> players) {
        for(Player player: players){
            player.setStatus(this);
            List<String> status = new ArrayList<>();
            HashMap<String, String> equipment = player.getEquipment();
            status.add("Player" + player.getPlayerNO());
            status.add(String.valueOf(player.getPocketCards().size()));// handsize for index1
            status.add(String.valueOf(player.getHp()));// hp for index2
            status.add(equipment.get("Weapon"));//3
            status.add(equipment.get("Plus"));//4
            status.add(equipment.get("Minus"));//5
            status.add(player.getPocketCardNames());//6
            globalStatus.add(status);
        }
        turns = 0;
    }

    public LinkedList<List<String>> getStatus(){
        return globalStatus;
    }
}
