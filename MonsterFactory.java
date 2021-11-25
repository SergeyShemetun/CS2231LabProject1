package com.LabProject;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
public class MonsterFactory {

    public MonsterFactory(){

    }

    public Map<Location,Monster> fillMonsterMap(){
        Map<Location,Monster> monsterMap=new HashMap<>();
        Random rand = new Random();

        for (int i=0; i<8;i++){
            int chance = rand.nextInt(100);
            if((chance<33)){
                monsterMap.put(User.locations.get(i),new Drake());
            }
            if((chance>33)&&(chance<60)){
                monsterMap.put(User.locations.get(i),new SpaceVampire());
            }
            else if((chance>60)&&(chance<80)){
                monsterMap.put(User.locations.get(i),new Syth());
            }
            else if(chance>80){
                monsterMap.put(User.locations.get(i),null);
            }

        }

        return monsterMap;
    }

}
