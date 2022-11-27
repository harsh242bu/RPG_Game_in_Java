// Represents Hero object
import java.util.ArrayList;
import java.util.List;

public class Hero extends Character implements Modifiable{
    // Inject user playing or computer playing behaviour as a strategy pattern
    // Attacking behaviour as strategy pattern ?

    private final int INITIAL_HP = 100;
    private int mana;
    private int strength;
    private int agility;
    private int dexterity;
    private int hp;
    private LevelUpBehaviour levelBehaviour;

    private Gold gold;
    private MarketInventory backPack;
    private Weapon weapon;
    private Armor armor;

    // mana/strength/agility/dexterity/starting money/starting experience
    public Hero(String name, int mana, int strength, int agility, int dexterity, int money, int xp) {
        super("H",name, 1, xp);
        this.hp = 1*INITIAL_HP;
        this.mana = mana;
        this.strength = strength;
        this.agility = agility;
        this.dexterity = dexterity;
        this.gold = new Gold(money);
        this.weapon = new Weapon("Bare_Hands", 0, 1, 180, 2);
        this.backPack = new MarketInventory();
        this.armor = new Armor("None", 0, 1,0);
//        addItemsToTest();
    }

    public void addItemsToTest(){
        this.weapon = new Weapon("Bare_Hands", 0, 1, 150, 2);
        this.backPack = new MarketInventory();
        this.backPack.addSpell(FireSpellsData.fireSpells.getItem(1));
        this.backPack.addPotion(PotionsData.potions.getItem(0));
        this.backPack.addArmor(ArmorsData.armors.getItem(0));
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public LevelUpBehaviour getLevelBehaviour() {
        return levelBehaviour;
    }

    public void setLevelBehaviour(LevelUpBehaviour levelBehaviour) {
        this.levelBehaviour = levelBehaviour;
    }

    public Gold getGold() {
        return gold;
    }

    public void setGold(Gold gold) {
        this.gold = gold;
    }

    @Override
    public boolean isAlive(){
        return (getHp() > 0);
    }

    public void changeMoney(int value){
        int newVal = getMoney() + value;
        this.gold.setAmount(newVal);
    }

    public int getMoney(){
        return getGold().getAmount();
    }

    public MarketInventory getBackPack() {
        return backPack;
    }

    public void setBackPack(MarketInventory backPack) {
        this.backPack = backPack;
    }

    public boolean hasWeapons(){
        return backPack.hasWeapons();
    }

    public boolean hasSpells(){
        return backPack.hasSpells();
    }

    public boolean hasPotions(){
        return backPack.hasPotions();
    }

    public boolean hasArmors(){
        return backPack.hasArmors();
    }

    public int getAttribute(int type){
        switch (type){
            case(MANA):
                return this.mana;
            case(STRENGTH):
                return this.strength;
            case(AGILITY):
                return this.agility;
            case(DEXTERITY):
                return this.dexterity;
            case(GOLD):
                return this.gold.getAmount();
            case(XP):
                return this.getLevel().getXp();
            case(LEVEL):
                return this.getIntLevel();
            case(HP):
                return this.getHp();
            default:
                return 0;
        }
    }

//    public int getAction(){
//        List<Integer> choiceList = new ArrayList<Integer>();
//        System.out.println("Choose one of the actions:");
//        System.out.println("1. Attack using " + getWeapon().getName() + " weapon");
//        choiceList.add(1);
//        if(backPack.getSpells().getSize() > 0){
//            System.out.println("2. Attack using a spell from the inventory");
//            choiceList.add(2);
//        }
//        if(backPack.getPotions().getSize() > 0){
//            System.out.println("3. Attack using a potion from the inventory");
//            choiceList.add(3);
//        }
//        if(backPack.getWeapons().getSize() > 0){
//            System.out.println("4. Equip a weapon from the inventory");
//            choiceList.add(4);
//        }
//        if(backPack.getArmors().getSize() > 0){
//            System.out.println("5. Equip a armor from the inventory");
//            choiceList.add(5);
//        }
//
//        System.out.println("6. Check out heroes info");
//        choiceList.add(6);
//
//        return Utility.intInputFromList(choiceList);
//    }

    public int getAction() {
        List<Integer> choiceList = new ArrayList<Integer>();
        System.out.println("Choose one of the actions:");
        choiceList.add(1);
        if (backPack.getSpells().getSize() > 0) {

            choiceList.add(2);
        }
        if (backPack.getPotions().getSize() > 0) {

            choiceList.add(3);
        }
        if (backPack.getWeapons().getSize() > 0) {

            choiceList.add(4);
        }
        if (backPack.getArmors().getSize() > 0) {

            choiceList.add(5);
        }


        choiceList.add(6);

        for (int i = 0; i < choiceList.size(); i++) {
            System.out.println((i + 1) + ": " + getActionString(choiceList.get(i)));
        }
        int choice = Utility.intInputFromList(choiceList);


        return choiceList.get(choice - 1);
    }

    public String getActionString(int input) {
        switch (input) {
            case 1:
                return "Attack using " + getWeapon().getName() + " weapon";

            case 2:
                return "Attack using a spell from the inventory";

            case 3:
                return "Attack using a potion from the inventory";

            case 4:
                return "Equip a weapon from the inventory";

            case 5:
                return "Equip a armor from the inventory";

            case 6:
                return "Check out heroes info";

            default:
                return null;
        }
    }

    @Override
    public void printCharacter() {
//        Name 	Mana	Strength	Agility	Dexterity	Starting money	Starting experience
        System.out.print(getTag() + "\t");
        System.out.print(getName() + "\t");
        if(getName().length() < 8){
            System.out.print("\t\t");
        }
        else if(getName().length() < 12){
            System.out.print("\t");
        }
        for(int attr: HERO_ATTRIBUTES){
            System.out.print(Utility.getString(getAttribute(attr)));
            if(getAttribute(attr) > 999)
                System.out.print("\t");
            else System.out.print("\t\t");

            switch (attr){
                case STRENGTH:
                case DEXTERITY:
                case XP:
                    System.out.print("\t");
                    break;
                case GOLD:
                    System.out.print("\t\t");
                    break;
            }
        }

        Utility.newLine();
    }

    @Override
    public void modify(int type, int value) {
        switch (type){
            case(HP):
                this.hp += value;
            case(MANA):
                this.mana += value;
                break;
            case(STRENGTH):
                this.strength += value;
                break;
            case(AGILITY):
                this.agility += value;
                break;
            case(DEXTERITY):
                this.dexterity += value;
                break;
            case(GOLD):
                this.gold.modify(value);
                break;
        }
    }

    @Override
    public Attack getAttack() {
        Attack heroAttack;
        int action;
        do {
            action = this.getAction();
            switch (action) {
                case (HeroAttackOptions.WEAPON): {
                    int weaponDamage = Utility.getIntForDouble((this.strength + weapon.getDamage()) * 0.15);
                    heroAttack = new Attack(Modifiable.DEFENSE, weaponDamage);
                    System.out.println(getName() + " attacked using " + getWeapon().getName() +
                            " for " + weaponDamage + " damage !");
                    return heroAttack;
                }
                case (HeroAttackOptions.SPELL): {
                    heroAttack = getSpellAttack();
                    return heroAttack;
                }
                case (HeroAttackOptions.POTION): {
                    consumePotion();
                    return null;
                }
                case (HeroAttackOptions.WEAPON_CHOOSE): {
                    switchWeapon();
                    return null;
                }
                case (HeroAttackOptions.ARMOR_CHOOSE): {
                    switchArmor();
                    return null;
                }
                case (HeroAttackOptions.SHOW_INFO): {
                    printHeroDetails();
//                    return null;
                }
            }
        } while(action == HeroAttackOptions.SHOW_INFO);
        return null;
    }

    public Hero getNewHero(){
        if(WarriorData.getCharacterIndexByName(getName()) != -1){
            return (Hero)WarriorData.getHero(WarriorData.getCharacterIndexByName(getName()));
        }
        else if(PaladinsData.getCharacterIndexByName(getName()) != -1){
            return (Hero)PaladinsData.getHero(PaladinsData.getCharacterIndexByName(getName()));
        }
        else if(SorcerersData.getCharacterIndexByName(getName()) != -1){
            return (Hero)SorcerersData.getHero(SorcerersData.getCharacterIndexByName(getName()));
        }
        else return null;
    }

    public void resetHero(){
        Hero temp = this.getNewHero();
//        int mana, int strength, int agility, int dexterity, int money, int xp
        this.setLevel(temp.getLevel());
        this.setMana(temp.getMana());
        this.setStrength(temp.getStrength());
        this.setAgility(temp.getAgility());
        this.setDexterity(temp.getDexterity());
        this.setGold(temp.getGold());
        this.setHp(1*INITIAL_HP);
    }

    public void switchWeapon(){
        int counter = 0;
        System.out.println("Choose from the following weapons: ");

        backPack.getWeapons().printItems(counter + 1);
        int input = Utility.intInput(1, backPack.getWeapons().getSize() + 1);

        Weapon oldWeapon = getWeapon();
        Weapon newWeapon = backPack.getWeapons().getItem(input - 1);

        backPack.addWeapon(oldWeapon);
        setWeapon(newWeapon);
    }

    public void switchArmor(){
        int counter = 0;
        System.out.println("Choose from the following armors: ");

        backPack.getArmors().printItems(counter + 1);
        int input = Utility.intInput(1, backPack.getArmors().getSize() + 1);

        Armor oldArmor = getArmor();
        Armor newArmor = backPack.getArmors().getItem(input - 1);

        backPack.addArmor(oldArmor);
        setArmor(newArmor);
    }

    public void consumePotion() {
        Potion potion = choosePotion();
        System.out.println(getName() + " used " + potion.getName() +
                " for " + potion.getAttrIncrease() + potion.printAttributesAffected() + " increase !");
        backPack.getPotions().remove(potion);
        for(int attr: potion.getAttrAffected()){
            modify(attr, potion.getAttrIncrease());
        }
    }

    public Attack getSpellAttack() {
        Spell spell = chooseSpell();
        Attack attack;
        if(spell.getManaCost() > getMana()){
            System.out.println("Cannot use this spell. Not enough mana available !!");
            attack = null;
        }
        else {
            int spellDamage = spell.getDamage();
            spellDamage = spellDamage + ((getDexterity() / 1000) * spellDamage);
            System.out.println(getName() + " used " + spell.getName() +
                    " for " + spellDamage + " damage !");
            attack = new Attack(spell.getAttrAffected(), spellDamage);

            backPack.removeSpell(spell);
        }
        return attack;
    }

    public Spell chooseSpell(){
        System.out.println("Choose from the following spells");
        backPack.getSpells().getItem(0).getHeader();
        for(int i = 0; i < backPack.numOfSpells(); i++){
            System.out.print("" + (i+1) + ". ");
            backPack.getSpells().getItem(i).printItem();
        }
        int choice = Utility.intInput(1, backPack.getSpells().getSize() + 1);
        return backPack.getSpells().getItem(choice - 1);
    }

    public Potion choosePotion(){
        System.out.println("Choose from the following potions");
        backPack.getPotions().getItem(0).getHeader();
        for(int i = 0; i < backPack.numOfSpells(); i++){
            System.out.print("" + (i+1) + ". ");
            backPack.getPotions().getItem(i).printItem();
        }
        int choice = Utility.intInput(1, backPack.getPotions().getSize() + 1);
        return backPack.getPotions().getItem(choice - 1);
    }

    public void activeLevelUp(int level) {
        // increase xp = level of monster
        // increase gold = 100*level of Mon
        gold.setAmount(gold.getAmount() + 100*level);
        if(increaseXp(level)){
            setMana((int)Math.round(getMana()*1.1));
            setStrength((int)Math.round(getStrength()*1.05));
            setAgility((int)Math.round(getAgility()*1.05));
            setDexterity((int)Math.round(getDexterity()*1.05));
            setHp(getIntLevel()*100);
            levelBehaviour.levelUp(this);
        }

        // xp req to level up = curr_level * 10

        // Fav skills increase extra 5%
        // Rest skill level up 5%
        // mp increase = 1.1 x curr_mana
    }

    public void inactiveLevelUp() {
        // hp = level * 100
        // increase half hp
        // increase half mana
        setHp(getIntLevel() * 50);
        int newMana = (int)Math.round(getMana() * 1.5);
        setMana(newMana);
    }

    public void printHeroDetails() {
        System.out.println("Hero details:");
        Utility.newLine();
        HeroData.getHeader();
        this.printCharacter();

        Utility.newLine();
        System.out.println("Weapon equipped:");
        getWeapon().getHeader();
        getWeapon().printItem();

        if(getArmor() != null) {
            Utility.newLine();
            System.out.println("Armor equipped:");
            getArmor().getHeader();
            getArmor().printItem();
        }

        Utility.newLine();
    }

    @Override
    public void dealAttack(Attack attack) {
        // calculate dodge chance here
        // implement armor here --
        int num = Utility.getIntForDouble(getAgility()*0.02);
        if(!Utility.checkProbability(num)){
            super.dealAttack(attack);
        }
        else{
            System.out.println(getName() + " dodged the attack");
        }
    }

//    name, level, hp, mp, strength, dexterity, agility, gold, inventory

}
