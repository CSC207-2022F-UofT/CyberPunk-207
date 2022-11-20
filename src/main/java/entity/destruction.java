package entity;

public class destruction extends strategy_card{
    public void use(int pick_num){
        getTarget().removeCard(getTarget().get_pocketcards().get(pick_num));
    }
}
