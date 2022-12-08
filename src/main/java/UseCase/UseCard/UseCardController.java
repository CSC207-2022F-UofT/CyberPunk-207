package UseCase.UseCard;

import entity.Player;

public class UseCardController {
    private UseCardInputBoundary useCardInputBoundary;

    public UseCardController(UseCardInputBoundary useCardInputBoundary) {
        this.useCardInputBoundary = useCardInputBoundary;
    }

    public void useCard(Player player, int card, int target){
        useCardInputBoundary.useCard(new UseCardRequestModel(player, card, target));
    }

}
