package Gateway;

import UseCase.PlayerJoin.PlayerJoinViewModel;

/**
 * An interface for UI to implement
 **/
public interface PlayerJoinUpdatable {

    /**
     * An interface for UI to implement
     * @param playerJoinViewModel A view model containing all join player and role assignment information
     **/
    void viewPlayers(PlayerJoinViewModel playerJoinViewModel);
}
