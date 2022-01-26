import java.util.Scanner;

public class Game {
    Player player;
    Location location;

    public void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Game!");
        System.out.println("Please Enter Your Name: ");
        String playerName = scanner.nextLine();
        player = new Player(playerName);
        player.selectChar();
    }
}
