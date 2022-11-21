package entity;

public class Shoot extends basic_card{

    public void use(){
        if (!getTarget().whether_has_dodge()){
                getTarget().hurted(1);
            }
    }
    @Override
    public String toString(){
        return "Shoot";
    }
}
