package entity;

public class Medkit extends basic_card{
    @Override
    public void use(int num){
        if (getTarget().gethp() < getTarget().getmaxhp()){
            getTarget().recover(1);
        }
    }
}
