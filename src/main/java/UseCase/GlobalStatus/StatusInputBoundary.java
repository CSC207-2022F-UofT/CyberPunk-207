package UseCase.GlobalStatus;

import entity.Player;

import java.util.List;

/**
 *An input boundary interface contains methods updating and initialize status, implemented by Status class.
 **/
public interface StatusInputBoundary {
    /**
     * Change global status when changing turn
     * Including rolling the sequence of global status forward for one player, and add one to the turns attribute
     **/
    void turnChange();

    /**
     * Initialize global status at the start of game
     * @param players List of players within current game
     **/
    void init(List<Player> players);
}
