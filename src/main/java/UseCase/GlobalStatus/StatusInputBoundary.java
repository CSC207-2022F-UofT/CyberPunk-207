package UseCase.GlobalStatus;

import entity.Player;

import java.util.List;

public interface StatusInputBoundary {
    void turnChange();

    void init(List<Player> players);
}
