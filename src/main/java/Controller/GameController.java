package Controller;

import manager.InputBoundary;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class GameController {
    private final InputBoundary inputBoundary;
    //private static final Scanner scan = new Scanner(System.in);

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
        Scanner scan = new Scanner(System.in);
        String ans = "";
        ans = scan.next();
        try {
            return Integer.parseInt(ans);
        }
        catch(Exception e){
            System.out.println("Input must be integer. Please input again.");
            input();
        }
        return -1;
    }


    public void endRound() {

    }

    public void selectTarget() {

    }
    public void playCard(int num) {
        inputBoundary.getCurrPlayer().useCard(num);
    }

    public void discardCard() {

    }

    }
