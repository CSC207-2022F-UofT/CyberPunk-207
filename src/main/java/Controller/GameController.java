package Controller;

import manager.InputBoundary;
import manager.OutputBoundary;

import java.util.Scanner;

import static java.lang.Thread.sleep;

public class GameController {
    private final InputBoundary inputBoundary;
    //private static final Scanner scan = new Scanner(System.in);
    private final OutputBoundary outputBoundary;
    public GameController(InputBoundary inputBoundary, OutputBoundary outputBoundary){
        this.inputBoundary = inputBoundary;
        this.outputBoundary = outputBoundary;
    }
    // trigger by ui add actionListener
    public void startGame(){
        outputBoundary.displayInstruction("Initiating Game");
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
    }

    public void discardCard() {

    }

    }
