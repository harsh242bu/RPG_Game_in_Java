// Represents a game character
public abstract class Character implements Modifiable{
    private String name;
    private CharacterLevel level;
//    private int hp;

    public Character(String name, int level, int xp) {
        this.name = name;
        this.level = new CharacterLevel(level, xp);
//        this.hp = hp;
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

    public void setLevel(CharacterLevel level) {
        this.level = level;
    }

    public boolean increaseXp(int xp){
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
