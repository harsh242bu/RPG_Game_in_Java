// Contains data of Exoskeleton monster
public class ExoskeletonsData {
    static public Party exoskeletons;
    // inject getHeader as a strategy pattern here

    ExoskeletonsData(){
        exoskeletons = new Party();

//        Name/level/damage/defense/dodge chance

        exoskeletons.addCharacter(new Monster("Doctor_Doom", 7, 180, 800, 75));
        exoskeletons.addCharacter(new Monster("Magneto", 3, 80, 450, 30));
        exoskeletons.addCharacter(new Monster("Green_Goblin", 1, 40, 250, 15));
        exoskeletons.addCharacter(new Monster("Red_Skull", 2, 60, 350, 25));
        exoskeletons.addCharacter(new Monster("Loki", 4, 100, 500, 45));
        exoskeletons.addCharacter(new Monster("Galactus", 6, 140, 750, 60));
        exoskeletons.addCharacter(new Monster("Ultron", 8, 200, 950, 85));
    }

    public static int size(){
        return exoskeletons.size();
    }

    //    public static Monster getMonster(int index) {
//        Hero hero = (Hero)warriors.get(index);
//        hero.setLevelBehaviour(new WarriorBehaviour());
//        return hero;
//    }
    public static void removeMonster(int index) {
        exoskeletons.remove(index);
    }
}
