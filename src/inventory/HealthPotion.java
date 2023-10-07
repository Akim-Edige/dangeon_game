package inventory;

import java.util.Random;

public class HealthPotion extends Consumable{
    private int healingPower;
    private String name;

    public HealthPotion(String n){
        name=n;
        Random power=new Random();
        healingPower = power.nextInt(9)+1;
    }
    public String getName(){
        return name;
    }
    public String toString(){
        return "\tHealth Potion: with Healing power: "+healingPower+"\n";
    }
}
