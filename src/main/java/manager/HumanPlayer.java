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
            //output("num for cards, 0 for end turn");
            int order = gameboard.askOrder();
            if(order == -1){
                return;
            } else{
                useCard(order);
            }
        }

    }

    public void useCard(int num) {
        Card card = playerModel.getPocketcards().get(num);
        card.setSource(playerModel);
        gameboard.askTarget(card);
        if(card instanceof Shoot){
            if(playerModel.isUseShoot() && playerModel.getEquipment().get("Weapon") == null){
                //output("shoot used, try another card");
                return;
            } else{
                playerModel.setUseShoot(true);
            }
        }
        //System.out.println(player.getPocketcards());
        card.use();
        playerModel.loosCard(num);
        //System.out.println(player.getPocketcards());
        //output(card.toString());
    }

    public void throwCard() {
        int card = gameboard.askOrder() - 1;
        loosCard(card);
    }
}
