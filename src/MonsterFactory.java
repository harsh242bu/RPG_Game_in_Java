// Used to randomly generate monster of hero's maximum level
import java.util.ArrayList;
import java.util.List;

public class MonsterFactory {
    MonsterFactory(){
        MonsterData.getMonsterDataInstance();
    }

    public Monster getMonster(int maxHeroLevel){
        List<Character> newList = new ArrayList<Character>();

        for(Character character: MonsterData.monsters.getLegion()){
            if(character.getIntLevel() <= maxHeroLevel) {
                newList.add(character);
            }
        }
//        if(newList.size() == 0){
//            new MonsterData();
//            for(Character character: MonsterData.monsters.getLegion()){
//                if(character.getIntLevel() <= maxHeroLevel) {
//                    newList.add(character);
//                }
//            }
//        }
        if(newList.size() == 0){
            return null;
        }
        int rand_num = Utility.getRandomNum(newList.size());
        Monster monster = (Monster) newList.get(rand_num);
        MonsterData.monsters.remove(monster);

        return monster;
    }
}
