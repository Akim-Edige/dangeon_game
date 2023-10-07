package inventory;

import java.util.Random;

public class Weapon extends Equipment {
    private int attackPower;
    private String name;

    public Weapon(String n){
        name=n;
        Random power=new Random();
        attackPower = power.nextInt(9)+1;
    }

    public String getName(){
        return name;
    }

    public String toString(){
        return "\tWeapon: with Attack power: "+attackPower+" \n ";
    }
}
