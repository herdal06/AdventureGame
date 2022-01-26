import java.util.Scanner;

public class Game {
    Player player;
    Location location;

    Scanner scanner = new Scanner(System.in);

    public void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Game!");
        System.out.println("Please Enter Your Name: ");
        String playerName = scanner.nextLine();
        player = new Player(playerName);
        player.selectChar();
        start();
    }

    public void start() {
       while(true) {
           System.out.println();
           System.out.println("=================");
           System.out.println();
           System.out.println("Choose a location : ");
           System.out.println("1. Safe House --> There is no enemies. You can fill your health.");
           System.out.println("2. Cave --> There will be zombies!");
           System.out.println("3. Forest --> There will be vampires!");
           System.out.println("4. River --> There will be bears!");
           System.out.println("5. Toolstore --> You can buy item!");
           System.out.println("Where do you want to go? ");
           int selectLocation = scanner.nextInt();
           while(selectLocation < 0 || selectLocation > 5) {
               System.out.println("Please select a valid character.");
               selectLocation = scanner.nextInt();
           }

           switch (selectLocation) {
               case 1:
                   location = new Safehouse(player);
                   break;
               case 2:
                   location = new Cave(player);
               case 3:
                   location = new Forest(player);
               case 4:
                   location = new River(player);
                   break;
               case 5:
                   location = new Toolstore(player);
                   break;
               default: // safehouse is default location.
                   location = new Safehouse(player);
                   break;
           }
           if(!location.getLocation()) {
               System.out.println("Game Over...");
               break;
           }

       }
    }
}
