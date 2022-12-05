package UseCase.ThrowCard;

import entity.Player;

public class ThrowCardController {
    private ThrowInputBoundary throwInputBoundary;

    public ThrowCardController(ThrowInputBoundary throwInputBoundary) {
        this.throwInputBoundary = throwInputBoundary;
    }

    public void throwCard(Player player, int card){
        throwInputBoundary.throwCard(new ThrowCardRequestModel(card, player));
    }
}
