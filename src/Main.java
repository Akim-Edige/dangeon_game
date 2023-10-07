import game.GameMap;
import actors.Player;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player();
        Game dangeon = new Game(5,5,2,player1);
        dangeon.MapSet();

        System.out.print("\033c");
        System.out.println("___________________________");
        dangeon.printGame();

        dangeon.Start();



    }
}