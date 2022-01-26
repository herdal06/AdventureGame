import java.util.Locale;

public abstract class BattleLocation extends Location {

    protected Obstacle obstacle;

    public BattleLocation(Player player, String name, Obstacle obstacle) {
        super(player);
        this.name = name;
        this.obstacle = obstacle;
    }

    public boolean getLocation() {
        int obstacleCount = obstacle.count();
        System.out.println("You are here : " + this.getName());
        System.out.println("Be careful. " + obstacleCount + " " + obstacle.getName() + " live here.");
        System.out.println("<A>ttack or <W>alk away");
        String selectCase = scanner.next();
        selectCase.toUpperCase();
        if(selectCase.equals("A")) {
            if(combat(obstacleCount)) {
                System.out.println("You defeated all the enemies!! Location : " + this.getName());
                return true;
            }
            else {
                System.out.println("You died :(");
                return false;
            }
        }
        return true;
    }

    public boolean combat(int obstacleCount) {
        for(int i = 0;i < obstacleCount; i++) {
            playerStats();
            enemyStats();
        }
        return true;
    }

    public void playerStats() {
        System.out.println("Player Stats\n-------------------");
        System.out.println("Health : " + player.getHealth());
        System.out.println("Damage : " + player.getTotalDamage());
        System.out.println("Money : " + player.getMoney());
        if(player.getInventory().getDamage() > 0)  // Player has a weapon
            System.out.println("Weapon : " + player.getInventory().getWeaponName());
        if(player.getInventory().getAvoid() > 0)  // Player has a weapon
            System.out.println("Armor : " + player.getInventory().getArmourName());
    }
    public void enemyStats() {

        System.out.println("\n" + obstacle.getName() + " Stats\n-------------------");
        System.out.println("Health : " + obstacle.getHealth());
        System.out.println("Damage : " + obstacle.getDamage());
        System.out.println("Award : " + obstacle.getAward());
    }
}
