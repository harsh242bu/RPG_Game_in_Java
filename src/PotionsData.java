// Potions data
import java.util.ArrayList;
import java.util.List;

public class PotionsData {
    static public ItemInventory potions;

    PotionsData(){
        potions = new ItemInventory();

//        Healing_Potion  250     1   100		Health
//        Strength_Potion 200     1   75		Strength
//        Magic_Potion    350     2   100		Mana
//        Luck_Elixir     500     4   65  	Agility
//        Mermaid_Tears   850     5   100  	Health/Mana/Strength/Agility
//        Ambrosia        1000    8   150		All Health/Mana/Strength/Dexterity/Defense/Agility


        potions.addItem(new Potion("Healing_Potion", 250, 1, 100,
                new ArrayList<Integer>() {{add(Modifiable.HP);}} ));
        potions.addItem(new Potion("Strength_Potion", 200, 1, 75,
                new ArrayList<Integer>() {{add(Modifiable.STRENGTH);}} ));
        potions.addItem(new Potion("Magic_Potion", 350, 2, 100,
                new ArrayList<Integer>() {{add(Modifiable.MANA);}} ));
        potions.addItem(new Potion("Luck_Elixir", 500, 4, 65,
                new ArrayList<Integer>() {{add(Modifiable.AGILITY);}} ));
        potions.addItem(new Potion("Mermaid_Tears", 850, 5, 100,
                new ArrayList<Integer>() {{add(Modifiable.HP); add(Modifiable.MANA);
            add(Modifiable.STRENGTH); add(Modifiable.AGILITY);}} ));
        potions.addItem(new Potion("Ambrosia", 1000, 8, 150,
                new ArrayList<Integer>() {{add(Modifiable.HP); add(Modifiable.MANA);
                    add(Modifiable.STRENGTH); add(Modifiable.DEXTERITY); add(Modifiable.AGILITY);}} ));
    }
}
