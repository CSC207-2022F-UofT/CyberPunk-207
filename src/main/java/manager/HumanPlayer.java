package manager;

import entity.Card;
import entity.PlayerModel;
import entity.Shoot;

public class HumanPlayer extends PlayerManager{
    public HumanPlayer(int playerNO, Gameboard gameboard) {
        super(playerNO, gameboard);
    }

    public void playCard(){
        while(isAlive()){
            outputBoundary.displayInstruction("Please choose card or end phase");
            int order = gameboard.askOrder();
            if(order == -1){
                outputBoundary.displayInstruction("You have chosen to end playing phase. Now start throwing card.");
                return;
            }
            else if (order + 1 > playerModel.getPocketcards().size()){
                outputBoundary.displayInstruction("Input out of range. Please enter again.");
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
            if(playerModel.isUseShoot() && playerModel.getEquipment().get("Weapon") == null){
                outputBoundary.displayInstruction("shoot used, try another card");
                return;
            } else{
                playerModel.setUseShoot(true);
            }
        }
//        outputBoundary.displayPocket(getPocketcardnames());
        card.use();
        playerModel.loosCard(num);
        outputBoundary.displayPocket(getPocketcardnames());
    }

    public void throwCard() {
        int card = gameboard.askOrder() - 1;
        try {
            loosCard(card);
        }
        catch (Exception e){
            outputBoundary.displayInstruction("Index out of range. Please enter again.");
            throwCard();
        }
    }
}
