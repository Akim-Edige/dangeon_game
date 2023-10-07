package actors;
import inventory.Inventory;
public abstract class Actor {
private Inventory kalta;

    Actor(){
        kalta=new Inventory();
    }

    public void addArmor(){
        kalta.addArmor();
    }

    public void addWeapon(){
        kalta.addWeapon();
    }

    public void addPoison(){
        kalta.addPoison();
    }

    public void addHealthPotion(){
        kalta.addHealthPotion();
    }

}
