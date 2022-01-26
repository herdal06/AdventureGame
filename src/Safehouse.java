public class Safehouse extends NormalLocation {
    public Safehouse(Player player) {
        super(player, "Safe House");
    }


    public boolean getLocation() {
        player.setHealth(player.getRealHealth()); // fill the health.
        System.out.println("Your are healed!");
        System.out.println("You are in the safe house now.");
        return true;
    }
}
