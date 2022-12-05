package UseCase.UseCard;

import entity.Card.Card;
import entity.Card.Shoot;
import entity.Player;

import static UseCase.GameBoard.GameboardInteractor.getPlayers;

public class UseCard implements UseCardInputBoundary {

    private UseCardOutputBoundary useCardOutputBoundary;

    public UseCard(UseCardOutputBoundary useCardOutputBoundary) {
        this.useCardOutputBoundary = useCardOutputBoundary;
    }


    public void useCard(UseCardRequestModel useCardRequestModel) {
        Player player = useCardRequestModel.getPlayer();
        int cardNum = useCardRequestModel.getCard();
        int target = useCardRequestModel.getTarget();
        Card card = player.getPocketCards().get(cardNum);
        card.setSource(player);
        if (card.needTarget()) {
            card.setTarget(findTarget(target));
        }
        if (card instanceof Shoot) {
            if (player.isUseShoot() && player.getEquipment().get("Weapon").equals("")) {
                useCardOutputBoundary.displayInstruction(new UseCardResponseModel("shoot used, try another card"));
                return;
            } else {
                player.setUseShoot(true);
            }
        }
        card.use();
        player.looseCard(card);
    }



    public Player findTarget(int target){
        for(Player player: getPlayers()){
            if(player.getPlayerNO() == target){
                return player;
            }
        }
        return null;
    }

}