// Represents modifiable attributes of hero and monster. Ex: Mana, defense, xp, etc

public interface Modifiable {
    // mana/strength/agility/dexterity/starting money/starting experience

    int[] HERO_ATTRIBUTES = {1, 2, 3, 4, 5, 6};
    int[] MONSTER_ATTRIBUTES = {10, 9, 8, 3};
    int[] ALL_ATTRIBUTES = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    int MANA = 1;
    int STRENGTH = 2;
    int AGILITY = 3;
    int DEXTERITY = 4;
    int GOLD = 5;
    int XP = 6;
//    int MP = 7;
    int HP = 7;
    int DEFENSE = 8;
    int DAMAGE = 9;
    int LEVEL = 10;

    abstract void modify(int type, int value);

}
