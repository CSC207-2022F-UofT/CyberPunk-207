package manager;

import entity.Card;
import entity.Shoot;
import entity.Status;

public class HumanStrategy implements playStrategy{
    Gameboard gameboard;
    PlayerManager player;

    public HumanStrategy(Gameboard gameboard, PlayerManager player) {
        this.gameboard = gameboard;
        this.player = player;
    }

    public void playCard(){
        while(player.isAlive()){
            gameboard.displayInstruction("Please choose card or end phase");
            int order = gameboard.askOrder();
            if(order == -1){
                gameboard.displayInstruction("You have chosen to end playing phase. Now start throwing card.");
                return;
            }
            else if (order + 1 > player.getPocketcards().size()){
                gameboard.displayInstruction("Input out of range. Please enter again.");
                    playCard();
                }
            else{
                useCard(order);
            }
        }

    }

    public void useCard(int num) {
        Card card = player.getPocketcards().get(num);
        card.setSource(player);
        gameboard.askTarget(card);
        if(card instanceof Shoot){
            if(player.getPlayer().isUseShoot() && player.getEquipment().get("Weapon").equals("")){
                gameboard.displayInstruction("shoot used, try another card");
                return;
            } else{
                player.getPlayer().setUseShoot(true);
            }
        }
        card.use();
        player.loosCard(num);
    }

    public void throwCard() {
        int card = gameboard.askOrder() - 1;
        try {
            player.loosCard(card);
        }
        catch (Exception e){
            gameboard.displayInstruction("Index out of range. Please enter again.");
            throwCard();
        }
    }
}
