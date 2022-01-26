public class Toolstore extends NormalLocation {

    public Toolstore(Player player) {
        super(player, "Toolstore");
    }

    public boolean getLocation() {
        // Menu
        System.out.println("Money : "+ player.getMoney());
        System.out.println("1. Weapons");
        System.out.println("2. Armors");
        System.out.println("3. Exit");

        System.out.println("What is your choice ?");

        int selectedTool = scanner.nextInt();
        int selectedItemID;
        switch (selectedTool) {
            case 1:
                selectedItemID = weaponMenu();
                buyWeapon(selectedItemID);
                break;
            case 2:
                selectedItemID = armorMenu();
                buyArmor(selectedItemID);
                break;

            default:
                break;
        }

        return true;
    }

    public int weaponMenu() {
        System.out.println("1. Pistol\t  Money : 25, Damage : 2");
        System.out.println("1. Sword\t  Money : 35, Damage : 3");
        System.out.println("1. Rifle\t  Money : 45, Damage : 7");
        System.out.println("4. Exit");
        System.out.print("Choose one : ");
        int selectedWeaponID = scanner.nextInt();
        return  selectedWeaponID;
    }
    public int armorMenu() {
        System.out.println("1. Light armor\t  Money : 15, Avoid : 1");
        System.out.println("1. Medium armor\t  Money : 25, Avoid : 3");
        System.out.println("1. Heavy Armor\t  Money : 40, Avoid : 5");
        System.out.println("4. Exit");
        System.out.print("Choose one : ");
        int selectedArmorID = scanner.nextInt();
        return  selectedArmorID;
    }

    public void buyArmor(int itemID) {
            int avoid = 0;
            int price = 0;
            String armorName = null;
            switch (itemID) {
                case 1:
                    avoid = 1;
                    armorName = "Light armor";
                    price = 25;
                    break;
                case 2:
                    avoid = 3;
                    armorName = "Medium armor";
                    price = 35;
                    break;
                case 3:
                    avoid = 5;
                    armorName = "Heavy Armor";
                    price = 40;
                    break;
                default:
                    System.out.println("Please select a valid item.");
                    break;
            }

            if(player.getMoney() < price) {
                System.out.println("There's not enough money.");
            } else {
                player.getInventory().setAvoid(avoid);
                player.getInventory().setArmourName(armorName);
                player.setMoney(player.getMoney() - price);
                System.out.println("Congrats!. You bought a "+armorName + ". Blocked damage : +" + player.getInventory().getAvoid());
                System.out.println("Remaining money : "+player.getMoney());
            }

    }

    public void buyWeapon(int itemID) {
        int damage = 0;
        int price = 0;
        String weaponName = null;
        switch (itemID) {
            case 1:
                damage = 2;
                weaponName = "Pistol";
                price = 25;
                break;
            case 2:
                damage = 3;
                weaponName = "Sword";
                price = 35;
                break;
            case 3:
                damage = 7;
                weaponName = "Rifle";
                price = 45;
                break;
            default:
                System.out.println("Please select a valid item.");
                break;
        }

        if(player.getMoney() < price) {
            System.out.println("There's not enough money.");
        } else {
            player.getInventory().setDamage(damage);
            player.getInventory().setWeaponName(weaponName);
            player.setMoney(player.getMoney() - price);
            System.out.println("Congrats!. You bought a "+weaponName+
                    ". Prev damage : "+player.getDamage()+
                    " Current damage : "+ player.getTotalDamage());
            System.out.println("Remaining money : "+player.getMoney());
        }

    }
}
