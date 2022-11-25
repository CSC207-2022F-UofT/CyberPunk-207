package entity;

public class Shoot extends basic_card{

    @Override
    public boolean needTarget() {
        return true;
    }

    public void use(){
        if (getTarget().whether_has_dodge()){
                getTarget().hurt(1);
            }
    }
    @Override
    public String toString(){
        return "Shoot";
    }
}
