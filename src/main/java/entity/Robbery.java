package entity;

public class Robbery extends strategy_card{
    public void use(int pick_num){
        getSource().addCard(getTarget().get_pocketcards().get(pick_num));
        getTarget().removeCard(getTarget().get_pocketcards().get(pick_num));
    }
}
