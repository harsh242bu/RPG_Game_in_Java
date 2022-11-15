// Weapons data class
public class WeaponsData {
    static public ItemInventory weapons;

    WeaponsData(){
        weapons = new ItemInventory();

//        Name/cost/level/damage/required hands
//        Sword           500     1    800    1
//        Bow             300     2    500    2
//        Scythe          1000    6    1100   2
//        Axe             550     5    850    1
//        TSwords     	1400    8    1600   2
//        Dagger          200     1    250    1

        weapons.addItem(new Weapon("Sword", 500, 1, 180, 1));
        weapons.addItem(new Weapon("Bow", 300, 2, 200, 2));
        weapons.addItem(new Weapon("Scythe", 1000, 6, 350, 2));
        weapons.addItem(new Weapon("Axe", 550, 5, 300, 1));
        weapons.addItem(new Weapon("TSwords", 1400, 8, 600, 2));
        weapons.addItem(new Weapon("Dagger", 200, 1, 170, 1));
    }

    public static void getHeader(){
        System.out.println("Name\t\tCost\tRequired level\tDamage\tRequired hands");
    }
}
