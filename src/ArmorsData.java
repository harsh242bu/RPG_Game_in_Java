// Contains armor data to input into the game
public class ArmorsData {
    static public ItemInventory armors;

    ArmorsData(){
        armors = new ItemInventory();

//        Name/cost/required level/damage reduction

        armors.addItem(new Armor("Platinum_Shield", 150, 1, 200));
        armors.addItem(new Armor("Breastplate", 350, 3, 600));
        armors.addItem(new Armor("Full_Body_Armor", 1000, 8, 1100));
        armors.addItem(new Armor("Wizard_Shield", 1200, 10, 1500));
        armors.addItem(new Armor("Guardian_Angel", 1000, 10, 1000));
    }

    public static void getHeader(){
        System.out.println("Name\t\tCost\tRequired level\tDamage");
    }
}

