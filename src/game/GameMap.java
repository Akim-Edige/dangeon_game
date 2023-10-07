package game;
import actors.Enemy;
import game.Room;
import inventory.Armor;
import inventory.Weapon;
import inventory.Poison;
import inventory.HealthPotion;
import actors.Player;

import java.util.ArrayList;
import java.util.Random;


public class GameMap {

    private int width;
    private int height;
    private int enemiesEachRoom;
    ArrayList<ArrayList<Room>> map;

    int gowidth;
    int goheight;

   // Random random= new Random();

    public GameMap(int w,int h, int enemy){
        enemiesEachRoom=enemy;
        width=w;
        height=h;
        map=new ArrayList<>();
        for(int array=0;array<height;array++){
            map.add(new ArrayList<Room>());
            for(int column=0;column<width;column++){
                map.get(array).add(new Room(array,column));
            }
        }
    }

    public void MapSetter(){
        Random random= new Random();
        int min = (width*height*20)/100;
        int notempty= random.nextInt(width*height-min)+min;   // Calculates how many rooms to fill with items and enemies
                                                            // from maximum amount of rooms
        for(int i=0; i<notempty;i++){

            int gowidth = random.nextInt(width);     // width of random room for items
            int goheight = random.nextInt(height);   // height of random room for items
            map.get(gowidth).get(goheight).randomItems();

            int gowidthEnemies = random.nextInt(width);     // width of random room for items
            int goheightEnemies = random.nextInt(height);   // height of random room for items
            map.get(goheightEnemies).get(gowidthEnemies).randomEnemies(enemiesEachRoom);

        }

    }

    public void Spawn(Player Steve){
        Random random= new Random();
        gowidth = random.nextInt(width);     // width of random room
        goheight = random.nextInt(height);   // height of random room

        Steve.setCoordinates(goheight,gowidth);
        map.get(goheight).get(gowidth).addActor(Steve);

    }


    public void printMap(){
        for(int array=0;array<width;array++){
            for(int column=0;column<height;column++){
                System.out.print(map.get(array).get(column).toString()+" ");
            }
            System.out.println();
        }
    }

    public Room getRoom(int height,int width){
        return map.get(height).get(width);
    }


    public void movePlayer(String direction, Player Steve){
        if(direction.equals("north")){
            if(goheight==0){
                System.out.println("Can not move to the North, map is ended");
            }else{
                map.get(goheight).get(gowidth).deleteActor(Steve);
                goheight-=1;
                map.get(goheight).get(gowidth).addActor(Steve);
                Steve.setCoordinates(goheight,gowidth);
                System.out.println("Move to north, player now in the room: array "+goheight+" column "+gowidth);
            }

        }else if(direction.equals("south")){

            if(goheight==(height-1)){
                System.out.println("Can not move to the South, map is ended");
            }else{
                map.get(goheight).get(gowidth).deleteActor(Steve);
                goheight+=1;
                Steve.setCoordinates(goheight,gowidth);
                map.get(goheight).get(gowidth).addActor(Steve);
                System.out.println("Move to south, now player now in the room: array "+goheight+" column "+gowidth);
            }

        }else if(direction.equals("west")){
            if(gowidth==(0)){
                System.out.println("Can not move to the west, map is ended");
            }else{
                map.get(goheight).get(gowidth).deleteActor(Steve);
                gowidth-=1;
                Steve.setCoordinates(goheight,gowidth);
                map.get(goheight).get(gowidth).addActor(Steve);
                System.out.println("Move to west, now player now in the room: array "+goheight+" column "+gowidth);
            }
        }else if(direction.equals("east")){
            if(gowidth==(width-1)){
                System.out.println("Can not move to the east, map is ended");
            }else{
                map.get(goheight).get(gowidth).deleteActor(Steve);
                gowidth+=1;
                Steve.setCoordinates(goheight,gowidth);
                map.get(goheight).get(gowidth).addActor(Steve);
                System.out.println("Move to east, now player now in the room: array "+goheight+" column "+gowidth);
            }
        }else{
            System.out.println("Invalid direction input");
        }
    }

//    public String getPlayerLocation(Player pl){
//        return "Coordinates of player are "+ pl.getCoordinates_Height()+pl.getCoordinates_Width();
//    }
}
