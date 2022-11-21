package entity;

public class Shoot extends basic_card{

    public Shoot(){
        super();
    }

    @Override
    public void use(){
        if (!getTarget().check_dodge()){
            getTarget().hurted(1);
        }
    }

    @Override
    public String toString(){
        return "Shoot";
    }
}
