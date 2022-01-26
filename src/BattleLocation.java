public abstract class BattleLocation extends Location {

    Obstacle obstacle;

    public BattleLocation(Player player, String name, Obstacle obstacle) {
        super(player);
        this.name = name;
        this.obstacle = obstacle;
    }

    public boolean getLocation() {
        return true;
    }
}
