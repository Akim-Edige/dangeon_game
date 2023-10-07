package game;
import inventory.Inventory;
import inventory.Item;
import actors.Actor;
import actors.Enemy;

import java.util.ArrayList;
import java.util.Random;

public class Room{

    private ArrayList<Actor> personaji;
    private Inventory kalta;
    private int column;
    private int array;

    Room(int a,int c){
        kalta = new Inventory();
        personaji=new ArrayList<>();
        column=c;
        array=a;
    }

    //Adding actor into the room
    public void addActor(Actor a){
        personaji.add(a);
    }
    public void deleteActor(Actor a){ personaji.remove(a);}

    // Adding seperate item into the inventar

//    public void addArmor(){
//        kalta.addArmor();
//    }
//
//    public void addWeapon(){
//        kalta.addWeapon();
//    }
//
//    public void addPoison(){
//        kalta.addPoison();
//    }
//
//    public void addHealthPotion(){
//        kalta.addHealthPotion();
//    }

    public void deleteItem(Item item){kalta.removeItem(item);}
    public void randomItems(){
        kalta.randomAddItems();
    }

    public void randomEnemies(int enemiesEachRoom){
        if(personaji.size()<2){
            Random random = new Random();
            int n_enemies = random.nextInt(enemiesEachRoom)+1;
            for(int i=0;i<n_enemies;i++){
                Enemy zhau = new Enemy();
                personaji.add(zhau);
            }
        }
    }

    public boolean hasItem(Item it){
        return kalta.hasItem(it);
    }

    public Inventory getKalta(){
        return kalta;
    }



    public String toString(){
        String res="\nRoom " + array + column + ":\n Inventories:\n ";
        res+=kalta.toString()+"\n";
        for(int i=0; i<personaji.size(); i++){
            res=res+personaji.get(i)+" ";
        }

        return res;
  //      return "room " + array + " " + column +" ";
    }
}
