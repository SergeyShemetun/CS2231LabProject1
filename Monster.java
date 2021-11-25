package com.LabProject;

public class Monster {

    public int health;
    public String name="monster";

    public Monster(){

    }

    public String greet(){
        return "Hello";
    }

    public void takeDamage(User user) {
        if(user.playerInventory.contains("Deathsticks")){
            this.health-=10;
        } else {
            this.health-=5;
        }


    }

    public int attack(){
        return 2;
    }


}
