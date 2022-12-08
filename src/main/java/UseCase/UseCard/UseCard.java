package UseCase.UseCard;

import entity.Card.Card;
import entity.Card.Shoot;
import entity.Player;

import static UseCase.GameBoard.GameboardInteractor.getPlayers;

/**
 * UseCard use case, handling use card request
 **/
public class UseCard implements UseCardInputBoundary {

    private UseCardOutputBoundary useCardOutputBoundary;

    public UseCard(UseCardOutputBoundary useCardOutputBoundary) {
        this.useCardOutputBoundary = useCardOutputBoundary;
    }

    /**
     * Handle card use request. Setup source and target of card based on input.
     * Check whether the player used shoot before. If so, end and send message to output boundary
     * Use the card and loose the card.
     * @param useCardRequestModel A request model containing player, card to use and target player information
     **/
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

    /**
     * A helper function finding target player based on input target No.
     * @param target An integer of No of intended target
     * @return A corresponding target player if the input target is valid. Otherwise, return null.
     **/
    public Player findTarget(int target){
        for(Player player: getPlayers()){
            if(player.getPlayerNO() == target){
                return player;
            }
        }
        return null;
    }

}