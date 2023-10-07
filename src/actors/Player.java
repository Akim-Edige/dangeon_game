package actors;

import inventory.Inventory;
import inventory.Item;

public class Player extends Actor{

    private int base_attack=3;  // attack without weapon

    private Inventory kalta;

    private int coordinate_width;
    private int coordinate_height;

    public Player(){
        kalta = new Inventory();
        kalta.addWeapon();
        kalta.addArmor();
        kalta.addHealthPotion();
    }
    public void setCoordinates(int h,int w){
        coordinate_height=h;
        coordinate_width=w;
    }

    public int getCoordinates_Height(){
        return coordinate_height;
    }

    public int getCoordinates_Width(){
        return coordinate_width;
    }

    //Dropping an item
    public void dropItem(Item item){
        kalta.removeItem(item);
    }

    // Pickking up an item;
    public boolean pickUp(Item item){
        if(kalta.sizeof()==7){
            System.out.println("Inventary is full");
            return false;
        }else {
            kalta.addItem(item);
            return true;
        }
    }

    public void addItem(Item item){
        kalta.addItem(item);
    }

    public Inventory getKalta(){
        return kalta;
    }

    public int howmanyItems(){
        return kalta.sizeof();
    }

    public String toString(){
        return "Player has: \n" + kalta.toString();
    }
}
