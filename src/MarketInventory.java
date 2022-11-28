// Contains list of armors, weapons, spells and potions. Used to represent market items as well as hero backpack
public class MarketInventory implements Cloneable{
    private ItemInventory<Weapon> weapons;
    private ItemInventory<Spell> spells;
    private ItemInventory<Potion> potions;
    private ItemInventory<Armor> armors;

    MarketInventory(){
        weapons = new ItemInventory<Weapon>();
        spells = new ItemInventory<Spell>();
        potions = new ItemInventory<Potion>();
        armors = new ItemInventory<Armor>();
    }

    @Override
    public MarketInventory clone() {
        MarketInventory inventory = null;
        try{
            inventory = (MarketInventory) super.clone();
        }
        catch(Exception e){
            inventory.weapons = new ItemInventory<Weapon>();
            inventory.spells = new ItemInventory<Spell>();
            inventory.potions = new ItemInventory<Potion>();
            inventory.armors = new ItemInventory<Armor>();

            for(Weapon weapon: getWeapons().getItems()){
                inventory.weapons.addItem(weapon.clone());
            }
            for(Spell spell: getSpells().getItems()){
                inventory.spells.addItem(spell.clone());
            }
            for(Potion potion: getPotions().getItems()){
                inventory.potions.addItem(potion.clone());
            }
            for(Armor armor: getArmors().getItems()){
                inventory.armors.addItem(armor.clone());
            }
        }

        return inventory;
    }

    public int numOfSpells(){
        return spells.getSize();
    }

    public int numOfPotions(){
        return potions.getSize();
    }

    public int numOfWeapons(){
        return weapons.getSize();
    }

    public int numOfArmors(){
        return armors.getSize();
    }

    public ItemInventory<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(ItemInventory<Weapon> weapons) {
        this.weapons = weapons;
    }

    public ItemInventory<Spell> getSpells() {
        return spells;
    }

    public void setSpells(ItemInventory<Spell> spells) {
        this.spells = spells;
    }

    public void addSpells(ItemInventory<Spell> spells) {
        this.spells.addItems(spells.getItems());
    }

    public ItemInventory<Potion> getPotions() {
        return potions;
    }

    public void setPotions(ItemInventory<Potion> potions) {
        this.potions = potions;
    }

    public ItemInventory<Armor> getArmors() {
        return armors;
    }

    public void setArmors(ItemInventory<Armor> armors) {
        this.armors = armors;
    }

    public void addWeapon(Item item) {
        this.weapons.addItem((Weapon) item);
    }

    public void addSpell(Item item) {
        this.spells.addItem((Spell) item);
    }

    public void addPotion(Item item) {
        this.potions.addItem((Potion) item);
    }

    public void addArmor(Item item) {
        this.armors.addItem((Armor) item);
    }

    public void removeArmor(Armor item) { this.armors.remove(item); }

    public void removeWeapon(Weapon item) { this.weapons.remove(item); }

    public void removeSpell(Spell item) { this.spells.remove(item); }

    public void removePotion(Potion item) { this.potions.remove(item); }

    public boolean hasWeapons(){
        return (getWeapons().getSize() > 0);
    }

    public boolean hasSpells(){
        return (getSpells().getSize() > 0);
    }

    public boolean hasPotions(){
        return (getPotions().getSize() > 0);
    }

    public boolean hasArmors(){
        return (getArmors().getSize() > 0);
    }

    public void printAllItems(){
//        int counter = 0;
        if(getArmors().getSize() > 0) {
            System.out.println("Armors:");
            getArmors().printItems(1);
            Utility.newLine();
        }

        if(getWeapons().getSize() > 0) {
            System.out.println("Weapons:");
            getWeapons().printItems(1);
            Utility.newLine();
        }

        if(getSpells().getSize() > 0) {
            System.out.println("Spells:");
            getSpells().printItems(1);
            Utility.newLine();
        }

        if(getPotions().getSize() > 0) {
            System.out.println("Potions:");
            getPotions().printItems(1);
            Utility.newLine();
        }
    }
}
