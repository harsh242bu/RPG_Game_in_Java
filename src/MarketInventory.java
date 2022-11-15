// Contains list of armors, weapons, spells and potions. Used to represent market items as well as hero backpack
public class MarketInventory {
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
}
