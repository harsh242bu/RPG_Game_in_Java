// Contains all the list of available monsters
public class MonsterData {
    public static MonsterData monsterDataInstance;
    public static Party monsters;

    private MonsterData(){
        monsters = new Party();
        new DragonsData();
        new ExoskeletonsData();
        new SpiritsData();

        monsters.addAll(DragonsData.dragons.getLegion());
        monsters.addAll(ExoskeletonsData.exoskeletons.getLegion());
        monsters.addAll(SpiritsData.spirits.getLegion());
    }

    public static MonsterData getMonsterDataInstance(){
        if(monsterDataInstance == null){
            monsterDataInstance = new MonsterData();
        }
        return monsterDataInstance;
    }

    public void removeMonster(Character monster){
        monsters.remove(monster);
    }

//    Name/level/damage/defense/dodge chance
    public static void getMonsterHeader(){
        System.out.println("Name \t\t\tLevel\tDamage\tDefense\tDodge chance");
    };

//    public static Monster getMonster(int index) {
//        Hero hero = (Hero)warriors.get(index);
//        hero.setLevelBehaviour(new WarriorBehaviour());
//        return hero;
//    }

//    public static int viewMonsters(){
//        System.out.println("Warriors - Favored on Strength and Agility");
//        getHeader();
//
//        for(Character warrior: warriors.getLegion()){
//            System.out.print("" + counter++ + ". ");
//            warrior.printCharacter();
////            Utility.newLine();
//        }
//        return counter;
//    }
}
