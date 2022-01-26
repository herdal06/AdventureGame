import java.util.Scanner;

public class Player {
    private String name;
    private String charName;
    private int damage;
    private int health;
    private int money;
    private Inventory inventory;

    Scanner scanner = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
    }

    public void selectChar() {
        switch (charMenu()) {
            // samurai selected
            case 1:
                initPlayer("Samurai",5,21,15);
                break;
            // archer selected
            case 2:
                initPlayer("Samurai",7,18,20);
                break;
            // knight selected
            case 3:
                initPlayer("Knight",8,24,5);
                break;
                // samurai is default character
            default:
                initPlayer("Samurai",5,21,15);
                break;
        }
        System.out.println("Your  character has been created.");
        System.out.println("Character : "+getCharName()+", Damage : "+getDamage()+", Health : "+getHealth()+", Money : "+getMoney());
    }

    public void initPlayer(String charName, int damage, int health, int money) {
        setCharName(charName);
        setDamage(damage);
        setHealth(health);
        setMoney(money);
    }

    public int charMenu() {
        System.out.println("Choose a character");
        System.out.println("1. Samurai \t Damage : 5 \t Health : 21 \t Money : 15");
        System.out.println("2. Archer \t Damage : 7 \t Health : 18 \t Money : 20");
        System.out.println("3. Knight \t Damage : 8 \t Health : 24 \t Money : 5");
        System.out.println("What is your choose ?");
        int charID = scanner.nextInt();
        while(charID < 1 || charID > 3) {
            System.out.println("Please select a valid character.");
            charID = scanner.nextInt();
        }
        return charID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
