import Controller.GameController;
import manager.Gameboard;
import manager.InputBoundary;
import manager.OutputBoundary;
import presenter.Presenter;

public class GameLauncher {
    public static void main(String[] args) {
//        AccountManager accountManager = new AccountManager();
//        Deserialization deserialization = new Deserialization();
//        accountManager.getAccounts(deserialization);
        OutputBoundary outputBoundary = new Presenter();
        InputBoundary inputBoundary = new Gameboard(outputBoundary);
        GameController controller = new GameController(inputBoundary);
        controller.startGame();
    }
}
