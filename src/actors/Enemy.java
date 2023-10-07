package actors;

import inventory.Inventory;

public class Enemy extends Actor{

    private Inventory kalta;

    public Enemy(){
        kalta=new Inventory();
        kalta.addWeapon();
        kalta.addArmor();
    }

    public String toString(){
        return "Enemy has: \n" + kalta.toString();
    }
}
