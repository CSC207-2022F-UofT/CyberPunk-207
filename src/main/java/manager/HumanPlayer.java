package manager;

import entity.Card;
import entity.PlayerModel;
import entity.Shoot;
import entity.Status;

public class HumanPlayer extends PlayerManager{
    public HumanPlayer(int playerNO, Gameboard gameboard, Status status) {
        super(playerNO, gameboard, status);
    }

    public void playCard(){
        while(isAlive()){
            gameboard.displayInstruction("Please choose card or end phase");
            int order = gameboard.askOrder();
            if(order == -1){
                gameboard.displayInstruction("You have chosen to end playing phase. Now start throwing card.");
                return;
            }
            else if (order + 1 > getPocketcards().size()){
                gameboard.displayInstruction("Input out of range. Please enter again.");
                    playCard();
                }
            else{
                useCard(order);
            }
        }

    }

    public void useCard(int num) {
        Card card = getPocketcards().get(num);
        card.setSource(this);
        gameboard.askTarget(card);
        if(card instanceof Shoot){
            if(playerModel.isUseShoot() && playerModel.getEquipment().get("Weapon") == ""){
                gameboard.displayInstruction("shoot used, try another card");
                return;
            } else{
                playerModel.setUseShoot(true);
            }
        }
        card.use();
        loosCard(num);
    }

    public void throwCard() {
        int card = gameboard.askOrder() - 1;
        try {
            loosCard(card);
        }
        catch (Exception e){
            gameboard.displayInstruction("Index out of range. Please enter again.");
            throwCard();
        }
    }
}
