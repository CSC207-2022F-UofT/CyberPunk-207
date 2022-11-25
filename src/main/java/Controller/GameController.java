package Controller;

import manager.InputBoundary;
import java.util.Scanner;

public class GameController {
    private final InputBoundary inputBoundary;
    private static final Scanner scan = new Scanner(System.in);

    public GameController(InputBoundary inputBoundary){
        this.inputBoundary = inputBoundary;
    }
    // trigger by ui add actionListener
    public void startGame(){
        inputBoundary.startGame();
    }
    // trigger by ui
    public void endGame(){
        inputBoundary.endGame();
    }

    public static int input(){
        String ans = "";
        ans = scan.next();
        return Integer.parseInt(ans);
    }
}
