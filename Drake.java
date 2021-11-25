package com.LabProject;

public class Drake extends Monster{
    int health=30;
    public Drake(){


    }

    @Override
    public String greet(){
        return "Hello im Drake";
    }
    @Override
    public void takeDamage(User user) {
        if(user.playerInventory.contains("Deathsticks")){
            this.health-=10;
        } else {
            this.health-=5;
        }


    }
@Override
    public int attack(){return 10;}



}
