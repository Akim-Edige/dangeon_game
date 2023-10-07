package inventory;

import java.util.Random;

public class Poison extends Consumable{

    String name;
    private int destroyPower;

    public Poison(String n){
        name=n;
        Random power=new Random();
        destroyPower = power.nextInt(9)+1;
    }

    public String getName(){
        return name;
    }

    public String toString(){
        return "\tPoison: Destroy power: "+destroyPower+"\n ";
    }
}
