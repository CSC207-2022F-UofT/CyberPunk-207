import UI.GameFrame;
import UI.LoginFrame;
import UseCase.EndTurn.*;
import UseCase.GameBoard.*;
import UseCase.GlobalStatus.*;
import UseCase.Login.*;
import UseCase.PlayerJoin.*;
import UseCase.UseCard.*;

public class GameLauncher {

    public static void main(String[] args) {
        LoginFrame loginFrame = new LoginFrame();
        LoginOutputBoundary loginPresenter = new LoginPresenter(loginFrame);
        AccountDatabaseGateway accountDatabase = new AccountDataBase();
        LoginInputBoundary accountManager = new AccountManager(accountDatabase, loginPresenter);
        LoginController loginController = new LoginController(accountManager);
        loginFrame.setLoginController(loginController);

        GameFrame gameFrame = new GameFrame();

        PlayerJoinOutputBoundary playerPresenter = new PlayerJoinPresenter(gameFrame);
        PlayerJoinInputBoundary playerJoin = new PlayerJoin(playerPresenter);
        PlayerJoinController playerJoinController = new PlayerJoinController(playerJoin);
        gameFrame.getRulePanel().setPlayerJoinController(playerJoinController);


        EndTurnOutputBoundary endTurnPresenter = new EndTurnPresenter(gameFrame.getCurrentPanel());
        EndTurnInputBoundary endTurn = new EndTurn(endTurnPresenter);
        EndTurnController endTurnController = new EndTurnController(endTurn);
        gameFrame.setEndTurnController(endTurnController);

        GameboardOutputBoundary gameboardPresenter = new GameboardPresenter(gameFrame);
        GameboardInputBoundary gameboard = new GameboardInteractor(gameboardPresenter);
        GameboardController gameboardController = new GameboardController(gameboard);
        gameFrame.setGameboardController(gameboardController);

        StatusOutputBoundary statusPresenter = new StatusPresenter(gameFrame);
        StatusInputBoundary status = new Status(statusPresenter);
        StatusController statusController = new StatusController(status);
        gameFrame.setStatusController(statusController);

        UseCardOutputBoundary useCardPresenter = new UseCardPresenter(gameFrame);
        UseCardInputBoundary useCard = new UseCard(useCardPresenter);
        UseCardController useCardController = new UseCardController(useCard);
        gameFrame.getCurrentPanel().setUseCardController(useCardController);

        gameFrame.setVisible(true);
        loginFrame.setVisible(true);

    }

}
