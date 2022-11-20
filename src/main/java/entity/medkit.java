package entity;

public class medkit extends basic_card{
    public void use(int num){
        if (getTarget().gethp() < getTarget().getmaxhp()){
            getTarget().recover(1);
        }
    }
}
