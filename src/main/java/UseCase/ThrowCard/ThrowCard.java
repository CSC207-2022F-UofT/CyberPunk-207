package UseCase.ThrowCard;

import entity.Player;

public class ThrowCard implements ThrowInputBoundary {
    @Override
    public void throwCard(ThrowCardRequestModel throwCardRequestModel) {
        Player player = throwCardRequestModel.getPlayer();
        int card = throwCardRequestModel.getCard();
        player.looseCard(card);
    }
}
