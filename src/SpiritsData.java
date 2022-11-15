// Spirits data class
public class SpiritsData {
    static public Party spirits;
    // inject getHeader as a strategy pattern here

    SpiritsData(){
        spirits = new Party();

//        Name/level/damage/defense/dodge chance

//        Andrealphus     2       600       500     40
//        Blinky          1       450       350     35
//        Andromalius     3       550       450     25
//        Chiang-shih     4       700       600     40
//        FallenAngel     5       800       700     50
//        Ereshkigall     6       950       450     35
//        Melchiresas     7       350       150     75

        spirits.addCharacter(new Monster("Mystique", 2, 60, 500, 40));
        spirits.addCharacter(new Monster("Juggernaut", 1, 35, 350, 35));
        spirits.addCharacter(new Monster("Modok", 3, 80, 450, 25));
        spirits.addCharacter(new Monster("Sinister", 4, 140, 600, 40));
        spirits.addCharacter(new Monster("Grandmaster", 5, 180, 700, 50));
        spirits.addCharacter(new Monster("Enchantress", 6, 220, 450, 35));
        spirits.addCharacter(new Monster("Ronan", 7, 290, 150, 75));
    }

    public static int size(){
        return spirits.size();
    }

    //    public static Monster getMonster(int index) {
//        Hero hero = (Hero)warriors.get(index);
//        hero.setLevelBehaviour(new WarriorBehaviour());
//        return hero;
//    }
    public static void removeMonster(int index) {
        spirits.remove(index);
    }
}
