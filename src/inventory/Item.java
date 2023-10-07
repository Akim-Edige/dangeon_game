package inventory;
import java.util.Random;

public abstract class Item {

    public Item(){

    }
    private String name;
    public Item(String n){
        name=n;
    }

    public String getName(){
        return name;
    }
}
