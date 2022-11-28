// Used to randomly generate monster of hero's maximum level
import java.util.ArrayList;
import java.util.List;

public class MonsterFactory {
    private static MonsterFactory monsterFactoryInstance;
    private int monsterCount;
    private MonsterFactory(){
        this.monsterCount = 1;
        MonsterData.getMonsterDataInstance();
    }

    public static MonsterFactory getMonsterFactoryInstance(){
        if(monsterFactoryInstance == null){
            monsterFactoryInstance = new MonsterFactory();
        }
        return monsterFactoryInstance;
    }

    public int getMonsterCount() {
        return monsterCount;
    }

    public void setMonsterCount(int monsterCount) {
        this.monsterCount = monsterCount;
    }

    public Monster getMonster(int maxHeroLevel){
        List<Character> newList = new ArrayList<Character>();

        for(Character character: MonsterData.monsters.getLegion()){
            if(character.getIntLevel() == maxHeroLevel) {
                newList.add(character);
            }
        }
        if(newList.size() == 0){
            return null;
        }
        int rand_num = Utility.getRandomNum(newList.size());
        Monster monster = null;
        try {
            monster = ((Monster)newList.get(rand_num)).clone();
        }
        catch (Exception e){
            System.out.println(e);
        }

//        MonsterData.monsters.remove(monster);
        monster.setTag("M" + getMonsterCount());
        setMonsterCount(this.monsterCount + 1);
        return monster;
    }
}
