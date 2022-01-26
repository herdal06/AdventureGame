import java.util.Locale;

public abstract class BattleLocation extends Location {

    protected Obstacle obstacle;
    protected String award;

    public BattleLocation(Player player, String name, Obstacle obstacle, String award) {
        super(player);
        this.name = name;
        this.obstacle = obstacle;
        this.award = award;
    }

    public boolean getLocation() {
        int obstacleCount = obstacle.count();
        System.out.println("You are here : " + this.getName());
        System.out.println("Be careful. " + obstacleCount + " " + obstacle.getName() + " live here.");
        System.out.println("<A>ttack or <W>alk away");
        String selectCase = scanner.nextLine();
        selectCase.toUpperCase();
        if(selectCase.equals("A")) {
            if(combat(obstacleCount)) {
                System.out.println("You defeated all the enemies!! Location : " + this.getName());
                if(this.award.equals("Food") && !player.getInventory().isFood()) {
                    System.out.println("You won " + this.award + "!");
                    player.getInventory().setFood(true);
                }
                else if(this.award.equals("Water") && !player.getInventory().isWater()) {
                    System.out.println("You won " + this.award + "!");
                    player.getInventory().setWater(true);
                }
                else if(this.award.equals("Firewood") && !player.getInventory().isFirewood()) {
                    System.out.println("You won " + this.award + "!");
                    player.getInventory().setFirewood(true);
                }
                return true;
            }
            if(player.getHealth() <= 0) {
                System.out.println("You died :(");
                return false;
            }
        }
        return true;
    }

    public boolean combat(int obstacleCount) {
        int defaultObstacleHealth = obstacle.getHealth();
        for(int i = 0;i < obstacleCount; i++) {
            playerStats();
            enemyStats();
            while(player.getHealth() > 0 && obstacle.getHealth() > 0) {
                System.out.println("<H>it or <R>un away");
                String selectCase = scanner.nextLine();
                selectCase = selectCase.toUpperCase();
                if(selectCase.equals("H")) {
                    System.out.println("You did hit!");
                    obstacle.setHealth(obstacle.getHealth() - player.getTotalDamage());
                    afterHitStats();
                    if(obstacle.getHealth() > 0){
                        System.out.println();
                        System.out.println(obstacle.getName() + " did hit you!");
                        player.setHealth(player.getHealth() - (obstacle.getDamage() - player.getInventory().getAvoid()));
                        afterHitStats();
                    }
                }
                else
                    return false;
            }
            if(obstacle.getHealth() < player.getHealth()) {
                System.out.println("You defeated the enemies!");
                player.setMoney(player.getMoney() + obstacle.getAward());
                System.out.println("Your money : " + player.getMoney());
                obstacle.setHealth(defaultObstacleHealth);

            }
            else
                return false;
            System.out.println("-------------------");
        }
        return true;
    }

    public void afterHitStats() {
        System.out.println("Your Health : " + player.getHealth());
        System.out.println(obstacle.getName() + " Health : " + obstacle.getHealth());
        System.out.println();
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
