public class Player {
    private String name;
    private String charName;
    private int damage;
    private int health;
    private int money;
    private Inventory inventory;

    public Player(String name) {
        this.name = name;
    }

    public void selectChar() {
        charMenu();
    }

    public void charMenu() {
        System.out.println("Please choose a character");
        System.out.println("1. Samurai \t Damage : 5 \t Health : 21 \t Money : 15");
        System.out.println("2. Archer \t Damage : 7 \t Health : 18 \t Money : 20");
        System.out.println("3. Knight \t Damage : 8 \t Health : 24 \t Money : 5");
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
