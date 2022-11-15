// Lightning spell data
public class LightningSpellsData {
    static public ItemInventory lightningSpells;

    LightningSpellsData(){
        lightningSpells = new ItemInventory();

//        Name/cost/required level/damage/mana cost
//        Lightning_Dagger      400        1       500     150
//        Thunder_Blast         750        4       950     400
//        Electric_Arrows       550        5       650     200
//        Spark_Needles         500        2       600     200


        lightningSpells.addItem(new LightningSpell("Lightning_Dagger", 400, 1, 500, 150));
        lightningSpells.addItem(new LightningSpell("Thunder_Blast", 750, 4, 950, 400));
        lightningSpells.addItem(new LightningSpell("Electric_Arrows", 550, 5, 650, 200));
        lightningSpells.addItem(new LightningSpell("Spark_Needles", 500, 2, 600, 200));

    }
}
