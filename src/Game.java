import java.util.Scanner;
import actors.Player;
import game.GameMap;
import game.Room;
import inventory.Inventory;
import inventory.Weapon;
import inventory.Item;

import java.util.ArrayList;



public class Game {


    //printMap method in GameMap class, which is called by printMap method in
    //Game classes.

    private int width;
    private int height;
    private int enemiesEachRoom;

    private Room playersRoom;

    private GameMap map;
    Player Steve;
    public Game(int w, int h, int e, Player s){
        width=w;
        height=h;
        enemiesEachRoom=e;
        Steve=s;

        map=new GameMap(width,height,enemiesEachRoom);
    }

    //Setts all items and enemies and Player
    public void MapSet(){
        map.MapSetter();
        map.Spawn(Steve);
        playersRoom = map.getRoom(Steve.getCoordinates_Height(), Steve.getCoordinates_Width());
    }

    public void printGame(){
        map.printMap();
    }

    // Some get functions
    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public GameMap getMap(){
        return map;
    }

    public String PlayerLocation(Player pl){return "Coordinates of player are "+pl.getCoordinates_Height()+pl.getCoordinates_Width();}

    public void movePlayer(String direction, Player pl){map.movePlayer(direction,pl);}

    public boolean pickUp(Player pl, String item_type){
        int w=pl.getCoordinates_Width();
        int h=pl.getCoordinates_Height();

        Inventory kalta = playersRoom.getKalta();
        ArrayList<Item> loot= kalta.getLoot();

        ArrayList<Item> listofItem=new ArrayList<>();

        for(int i=0;i<loot.size();i++){
          //  System.out.println("=="+loot.get(i).getName());
            if(loot.get(i).getName().equals(item_type)){
                listofItem.add(loot.get(i));
            }
        }

        if(listofItem.isEmpty()){
            System.out.println("There is no such item in the room");
            return false;
        }else if(listofItem.size()==1){
            boolean res=Steve.pickUp(listofItem.get(0));
            System.out.println("Picked "+item_type);
            playersRoom.deleteItem(listofItem.get(0));
            System.out.println(pl.toString());
            return res;
        }else{
            // If there are two or more items of the same item: For example if there are two weapons
            System.out.println("Which item you want to pick up?");
            for(int i=1;i<=listofItem.size();i++){
                System.out.println(i+") -"+listofItem.get(i-1).toString());
            }

            int ind=1;
            while(ind==1){
                Scanner myObj = new Scanner(System.in);
                String userInput = myObj.nextLine();
                int vibor = Integer.parseInt(userInput);

                if(vibor<=listofItem.size()&&vibor>0){
                    ind=0;
                }else{
                    System.out.println("Invalid number of item");
                }
            }
            boolean res=Steve.pickUp(listofItem.get(0));
            System.out.println("Picked "+item_type);
            playersRoom.deleteItem(listofItem.get(0));
            System.out.println(pl.toString());
            return res;
        }

    }

    public void Start(){
        int ind=1;
        Scanner myObj = new Scanner(System.in);
        String userInput;

        System.out.println(playersRoom.toString());
        while(ind==1){
            System.out.print("\033c");
            System.out.println("___________________________");
            System.out.println("Move | Coordinates | PickUp an item| Print Room | Drop Item | Exit");

            userInput = myObj.nextLine();
           // System.out.println("tvoi input " + userInput);
            if(userInput.equals("west")){
                map.movePlayer("west",Steve);
                playersRoom = map.getRoom(Steve.getCoordinates_Height(), Steve.getCoordinates_Width());
                System.out.println(playersRoom.toString());
            }else if(userInput.equals("east")){
                map.movePlayer("east",Steve);
                playersRoom = map.getRoom(Steve.getCoordinates_Height(), Steve.getCoordinates_Width());
                System.out.println(playersRoom.toString());
            }else if(userInput.equals("north")){
                map.movePlayer("north",Steve);
                playersRoom = map.getRoom(Steve.getCoordinates_Height(), Steve.getCoordinates_Width());
                System.out.println(playersRoom.toString());
            }else if(userInput.equals("south")){
                map.movePlayer("south",Steve);
                playersRoom = map.getRoom(Steve.getCoordinates_Height(), Steve.getCoordinates_Width());
                System.out.println(playersRoom.toString());
            }

            if(userInput.equals("Coordinates")){
                System.out.println("Players Coordinates are "+Steve.getCoordinates_Height()+Steve.getCoordinates_Width());
            }
            if(userInput.equals("Exit")){
                ind=0;
            }

            if(userInput.equals("PickUp")){
                // Maximum size of the inventary is Seven.
                if(Steve.howmanyItems()<7){
                    int k=1;
                    System.out.println("What type of item you want pick up?");
                    while(k==1){
                        userInput = myObj.nextLine();
                        if(userInput.equals("Weapon")){
                            pickUp(Steve, userInput);
                            k=0;
                        }else if(userInput.equals("Armor")){
                            pickUp(Steve,userInput);
                            k=0;
                        }else if(userInput.equals("Poison")){
                            pickUp(Steve,userInput);
                            k=0;
                        }else if(userInput.equals("Health Potion")){
                            pickUp(Steve,userInput);
                            k=0;
                        }else{
                            System.out.println("Invalid Type of Item");
                        }
                    }
                }else{
                    System.out.println("Inventary is full");
                    System.out.println(Steve.toString());
                }

            }

            if(userInput.equals("Print Room")){
                System.out.println(playersRoom.toString());
            }

            if(userInput.equals("Drop Item")){
                if(!Steve.getKalta().getLoot().isEmpty()){
                    System.out.println("Which item you want to drop? Choose number:");

                    for(int i=1;i<=Steve.howmanyItems();i++){
                        System.out.println(i+") -"+Steve.getKalta().getLoot().get(i-1));
                    }
                    int c=1;
                    while(c==1){
                        userInput = myObj.nextLine();
                        int choice=Integer.parseInt(userInput);
                        if(choice<=Steve.howmanyItems()&&choice>0){
                            Steve.dropItem(Steve.getKalta().getLoot().get(choice-1));  // Dropping choosed number
                            c=0;
                        }else{
                            System.out.println("Incorrect number input");
                        }
                    }
                }else{
                    System.out.println("Inventary is empty");
                }

            }

        }

        System.out.println("Game is ended");
    }
}
