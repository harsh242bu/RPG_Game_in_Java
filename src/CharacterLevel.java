//Represents xp and level of a character. An abstraction of xp and level.
public class CharacterLevel implements Cloneable{
    private int level;
    private int xp;

    public CharacterLevel(int level, int xp) {
        this.level = level;
        this.xp = xp;
    }

    public CharacterLevel(int xp) {
        this.level = 1;
        this.xp = xp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    @Override
    public CharacterLevel clone() {
        CharacterLevel level = null;
        try{
            return (CharacterLevel) super.clone();
        }
        catch (Exception e){
            return new CharacterLevel(getLevel(), getXp());
        }
    }

    public boolean increaseXp(int xp){
        boolean flag = false;
        this.xp += xp;
        if(this.xp > this.level*10){
            setLevel(this.level + 1);
            flag = true;
        }
        return flag;
    }
}
