package entity;

public class Destruction extends strategy_card{
    @Override
    public Object use(int pick_num){

        getTarget().removeCard(getTarget().get_pocketcards().get(pick_num));
    }

}
