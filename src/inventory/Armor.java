package inventory;
import java.util.Random;
public class Armor extends Equipment{
    private int defencePower;
    private String name;

    public Armor(String n){
        name=n;
        Random power=new Random();
        defencePower = power.nextInt(9)+1;
    }

    public String getName(){
        return name;
    }

    public String toString(){
        return "\tArmor: with Defence power: "+defencePower+" \n ";
    }
}
