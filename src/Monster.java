// Monster class with attributes specific to monster
public class Monster extends Character implements Modifiable{
    //    name, level, hp, base_damage, defense, dodge

    private int baseDamage; // can be injected using strategy pattern instead bcoz this can also be
                        // applied to other game elements like car in a game

    private int defense; // like an armor
    private int dodge;

    Monster(String name, int level, int damage, int defense, int dodge){
        // defense is hp
        super(name, level, 0);
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

    @Override
    public void printCharacter() {
//        Name level damage defense dodge chance
        System.out.print(getName() + "\t");
        for(int attr: MONSTER_ATTRIBUTES){
            switch (attr){
                case(LEVEL):
                    System.out.print(Utility.getString(getIntLevel()) + "\t");
                    break;
                case(DAMAGE):
                    System.out.print(Utility.getString(this.baseDamage) + "\t");
                    break;
                case(DEFENSE):
                    System.out.print(Utility.getString(this.defense) + "\t");
                    break;
                case(AGILITY):
                    System.out.print(Utility.getString(this.dodge) + "\t");
                    break;
            }
        }

        Utility.newLine();
    }

    public int getAttribute(int type){
        switch (type){
            case(DEFENSE):
                return this.defense;
            case(AGILITY):
                return this.dodge;
            case(XP):
                return this.getLevel().getXp();
            case(LEVEL):
                return this.getIntLevel();
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
        switch (type){
            case(DEFENSE):
                this.defense += value;
                break;
            case(DAMAGE):
                this.baseDamage += value;
                break;
            case(AGILITY):
                this.dodge += value;
                break;
        }
    }

    @Override
    public void dealAttack(Attack attack) {
        // calculate dodge chance here
        int num = Utility.getIntForDouble(getDodge());
        if(!Utility.checkProbability(num)){
            super.dealAttack(attack);
        }
        else{
            System.out.println(getName() + " dodged the attack");
        }
    }
}
