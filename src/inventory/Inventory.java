package inventory;
import inventory.Item;
import java.util.Random;

import java.util.ArrayList;

public class Inventory {

    private ArrayList<Item> loot;

    public Inventory(){
        loot=new ArrayList<Item>();
    }

    public boolean hasItem(Item it){
        if(loot.contains(it)){
            return true;
        }else{
            return false;
        }
    }

    public void addItem(Item i){
        loot.add(i);
    }
    public void addArmor(){
        Armor kirasa=new Armor("Armor");
        loot.add(kirasa);
    }

    public void addWeapon(){
        Weapon qaru=new Weapon("Weapon");
        loot.add(qaru);
    }

    public void addPoison(){
        Poison uy=new Poison("Poison");
        loot.add(uy);
    }
    public void addHealthPotion(){
        HealthPotion emdeu=new HealthPotion("Health Potion");
        loot.add(emdeu);
    }

    public void removeItem(Item item){
       loot.remove(item);
    }

    public int sizeof(){
        return loot.size();
    }

    public void randomAddItems(){
        Random random = new Random();
        int n_items = random.nextInt(2)+1; // random number of items range of 0-3
        for(int k=0; k<n_items;k++){
            // We run random from 0 - 3, n_item times, if we got 0 - room will have an armor,
            // 1 - weapon, 2 - HealthPotion, 3 - Poison. Each items power is randomly assigned inside the constructor of an item
            int pick;
            pick = random.nextInt(4);
            if(pick==0){
                addArmor();
            }else if(pick==1){
                addWeapon();
            }else if(pick==2){
                addHealthPotion();
            }else if(pick==3){
                addPoison();
            }
        }

    }

    public ArrayList<Item> getLoot(){
        return loot;
    }
    public String toString(){
        String res="";
        for(int i=0;i<loot.size();i++){
            res+= loot.get(i).toString();
        }
        return res;
    }

}
