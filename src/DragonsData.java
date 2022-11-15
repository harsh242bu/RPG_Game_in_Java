// Contains data of dragon monsters
public class DragonsData {
    static public Party dragons;
    // inject getHeader as a strategy pattern here

    DragonsData(){
        dragons = new Party();

//        Name/level/damage/defense/dodge chance

        dragons.addCharacter(new Monster("Carnage", 3, 70, 400, 35));
        dragons.addCharacter(new Monster("Sabertooth", 2, 55, 500, 20));
        dragons.addCharacter(new Monster("Mandarin", 4, 90, 500, 45));
        dragons.addCharacter(new Monster("Dormamu", 1, 35, 200, 10));
        dragons.addCharacter(new Monster("Venom", 7, 140, 600, 75));
        dragons.addCharacter(new Monster("Doctor_Octopus", 5, 600, 500, 60));
        dragons.addCharacter(new Monster("Thanos", 10, 300, 9000, 55));
    }

    public static int size(){
        return dragons.size();
    }

//    public static Monster getMonster(int index) {
//        Hero hero = (Hero)warriors.get(index);
//        hero.setLevelBehaviour(new WarriorBehaviour());
//        return hero;
//    }
    public static void removeMonster(int index) {
        dragons.remove(index);
    }
}
