// Represents a game character
public abstract class Character implements Modifiable, Cloneable {
    private String name;
    private CharacterLevel level;
    private String tag;
    private int hp;

    public Character(String tag, String name, int level, int xp, int hp) {
        this.tag = tag;
        this.name = name;
        this.level = new CharacterLevel(level, xp);
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CharacterLevel getLevel() {
        return level;
    }

    public int getIntLevel() {
        return level.getLevel();
    }

    public String getStringLevel() {
        return level.getLevel() + "(" + level.getXp() + "/" + (level.getLevel()) * 10 + ")";
    }

    public void setLevel(CharacterLevel level) {
        this.level = level;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public Character clone() throws CloneNotSupportedException {
        Character character = (Character) super.clone();

        character.level = (CharacterLevel) this.level.clone();
        return character;
    }

    public boolean increaseXp(int xp) {
        return level.increaseXp(xp);
    }

    public void modify(int type, int value) {

    }

    public abstract boolean isAlive();

    public abstract void printCharacter();

    public abstract Attack getAttack();

    public void dealAttack(Attack attack) {
        modify(attack.getAttribute(), attack.getValue());
    }
//    public abstract void dealAttack(Attack attack);
}
