package UseCase.UseCard;

import entity.Player;

/**
 * UseCard use case's controller.
 **/
public class UseCardController {
    private UseCardInputBoundary useCardInputBoundary;

    public UseCardController(UseCardInputBoundary useCardInputBoundary) {
        this.useCardInputBoundary = useCardInputBoundary;
    }

    /**
     * Let input boundary handle card use request,
     * by creating and passing a new request model containing three attributes:
     * source player, No. of card to use(Integer type), and intended target player's No.(Integer type)
     * @param player Source player input
     * @param card An integer attribute representing No. of card intended to use
     * @param target An integer attribute representing No. of target player intended to attack
     **/
    public void useCard(Player player, int card, int target){
        useCardInputBoundary.useCard(new UseCardRequestModel(player, card, target));
    }

}
