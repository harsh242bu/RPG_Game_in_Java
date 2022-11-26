// Buying state contains buying logic of market
public class BuyingState implements InMarketState{

    @Override
    public void handleInMarketState(Market market, Hero hero) {

        HeroData.getHeader();
        hero.printCharacter();

        System.out.println(hero.getName() + " Lets start shopping...");
        int counter = 0;
        Utility.newLine();
        System.out.println("Select your item from the list of items below: ");

        System.out.println("Armors:");
        market.getMarketItems().getArmors().printItems(counter + 1);

        int armorSize = market.getMarketItems().getArmors().getSize();
        counter = armorSize;

        Utility.newLine();
        System.out.println("Weapons:");
        market.getMarketItems().getWeapons().printItems(counter + 1);

        int weaponSize = market.getMarketItems().getWeapons().getSize();
        counter = armorSize + weaponSize;

        Utility.newLine();
        System.out.println("Spells:");
        market.getMarketItems().getSpells().printItems(counter + 1);

        int spellSize = market.getMarketItems().getSpells().getSize();
        counter = armorSize + weaponSize + spellSize;

        Utility.newLine();
        System.out.println("Potions:");
        market.getMarketItems().getPotions().printItems(counter + 1);

        int potionSize = market.getMarketItems().getPotions().getSize();
        counter = armorSize + weaponSize + spellSize + potionSize;
        int total = counter;

        int input = Utility.intInput(1, total + 1);

        Item item;
        int index = input - 1;
        if (index < armorSize) {
            item = market.getMarketItems().getArmors().getItem(index);
            if (item.getCost() > hero.getMoney()){
                System.out.println("Cannot buy this item. You don't have enough money!");
            }
            else if(item.getReqLevel() > hero.getIntLevel()) {
                System.out.println("Cannot buy this item. Required level is higher!");
            }
            else{
                System.out.println("You bought the following item:");
                item.getHeader();
                item.printItem();
                hero.getBackPack().addArmor(item);
                hero.changeMoney(item.getCost()*(-1));
            }
        } else if (index < armorSize + weaponSize) {
            item = market.getMarketItems().getWeapons().getItem(index - armorSize);
            if (item.getCost() > hero.getMoney()){
                System.out.println("Cannot buy this item. You don't have enough money!");
            }
            else if(item.getReqLevel() > hero.getIntLevel()) {
                System.out.println("Cannot buy this item. Required level is higher!");
            }
            else{
                System.out.println("You bought the following item:");
                item.getHeader();
                item.printItem();
                hero.getBackPack().addWeapon(item);
                hero.changeMoney(item.getCost()*(-1));
            }

        } else if (index < armorSize + weaponSize + spellSize) {
            item = market.getMarketItems().getSpells().getItem(index - armorSize - weaponSize);
            if (item.getCost() > hero.getMoney()){
                System.out.println("Cannot buy this item. You don't have enough money!");
            }
            else if(item.getReqLevel() > hero.getIntLevel()) {
                System.out.println("Cannot buy this item. Required level is higher!");
            }
            else{
                System.out.println("You bought the following item:");
                item.getHeader();
                item.printItem();
                hero.getBackPack().addSpell(item);
                hero.changeMoney(item.getCost()*(-1));
            }
        } else if (index < total) {
            item = market.getMarketItems().getPotions().getItem(index - armorSize - weaponSize - spellSize);
            if (item.getCost() > hero.getMoney()){
                System.out.println("Cannot buy this item. You don't have enough money!");
            }
            else if(item.getReqLevel() > hero.getIntLevel()) {
                System.out.println("Cannot buy this item. Required level is higher!");
            }
            else{
                System.out.println("You bought the following item:");
                item.getHeader();
                item.printItem();
                hero.getBackPack().addPotion(item);
                hero.changeMoney(item.getCost()*(-1));
            }
        }

        Utility.newLine();
        Utility.newLine();

        market.setState(new QuitMarket(), hero);
    }

}
