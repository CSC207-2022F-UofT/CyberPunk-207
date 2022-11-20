package entity;

public class shoot extends basic_card{

    public void use(){
        if (!getTarget().check_dodge()){
            getTarget().hurted(1);
        }
    }
}
