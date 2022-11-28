// Monster class with attributes specific to monster
public class Monster extends Character implements Modifiable {
    //    name, level, hp, base_damage, defense, dodge

    private int baseDamage;

    private int defense; // like an armor
    private int dodge;

    Monster(String name, int level, int damage, int defense, int dodge) {
        // defense is hp
        super("M", name, level, 0, level * 100);
        this.defense = defense;
        this.baseDamage = damage;
        this.dodge = dodge;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getDodge() {
        return dodge;
    }

    public void setDodge(int dodge) {
        this.dodge = dodge;
    }

    public Monster clone() throws CloneNotSupportedException {
        return (Monster) super.clone();
    }

    @Override
    public boolean isAlive() {
        return (getHp() > 0);
    }

    @Override
    public void printCharacter() {

        String output = String.format("%-15s%-20s%-15s%-15s%-15s%-15s%-15s", getTag(), getName(), getHp(),
                getBaseDamage(), getDefense(), getDodge(), getIntLevel());
        System.out.println(output);
    }

    public int getAttribute(int type) {
        switch (type) {
            case (DEFENSE):
                return this.defense;
            case (AGILITY):
                return this.dodge;
            case (XP):
                return this.getLevel().getXp();
            case (LEVEL):
                return this.getIntLevel();
            case (DAMAGE):
                return this.getBaseDamage();
            case (HP):
                return this.getHp();
            default:
                return 0;
        }
    }

    @Override
    public Attack getAttack() {
        Attack monsterAttack = new Attack(Modifiable.HP, getBaseDamage());
        System.out.println(getName() + " attacked " +
                " for " + getBaseDamage() + " damage !");
        return monsterAttack;
    }

    @Override
    public void modify(int type, int value) {
        switch (type) {
            case (DEFENSE):
                this.defense += value;
                break;
            case (DAMAGE):
                this.baseDamage += value;
                break;
            case (AGILITY):
                this.dodge += value;
                break;
            case (HP):
                setHp(getHp() + value);
                break;
        }
    }

    @Override
    public void dealAttack(Attack attack) {
        // calculate dodge chance here
        int num = Utility.getIntForDouble(getDodge());
        if (!Utility.checkProbability(num)) {
            // change the attack according to defense
            modify(attack.getAttribute(), attack.getValue());
            super.dealAttack(attack);
        } else {
            System.out.println(getTag() + " monster (" + getName() + ") dodged the attack");
        }
    }

    public void printMonsterStats() {
        MonsterData.getMonsterHeader();
        this.printCharacter();
        Utility.newLine();
    }
}
