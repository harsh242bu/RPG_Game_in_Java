// Contains selling logic of the market
public class SellingState implements InMarketState{

    @Override
    public void handleInMarketState(Market market) {
        for(Character character: market.getHeroParty().getLegion()) {
            Hero hero = (Hero) character;
            System.out.println(hero.getName() + " Lets start selling...");

            int counter = 0;
            int input;
            Item item;
            String yesNo;
            System.out.println("Select an item from the list below: ");

            System.out.println("Armors:");
            hero.getBackPack().getArmors().printItems(counter + 1);
            System.out.println("Sell an armor ? (Y/n): ");
            yesNo = Utility.inputChar();
            if(yesNo.equals("y")) {
                System.out.println("Enter an option from above list: ");
                input = Utility.intInput(1, market.getMarketItems().getArmors().getSize() + 1);
                item = hero.getBackPack().getArmors().getItem(input - 1);
                hero.getBackPack().removeArmor((Armor)item);
                hero.changeMoney(item.getCost()/2);
            }

            counter = 0;
            System.out.println("Weapons:");
            hero.getBackPack().getWeapons().printItems(counter + 1);
            System.out.println("Sell a weapon ? (Y/n): ");
            yesNo = Utility.inputChar();
            if(yesNo.equals("y")) {
                System.out.println("Enter an option from above list: ");
                input = Utility.intInput(1, market.getMarketItems().getWeapons().getSize() + 1);
                item = hero.getBackPack().getWeapons().getItem(input - 1);
                hero.getBackPack().removeWeapon((Weapon)item);
                hero.changeMoney(item.getCost()/2);
            }

            counter = 0;
            System.out.println("Spells:");
            hero.getBackPack().getSpells().printItems(counter + 1);
            System.out.println("Sell a spell ? (Y/n): ");
            yesNo = Utility.inputChar();
            if(yesNo.equals("y")) {
                System.out.println("Enter an option from above list: ");
                input = Utility.intInput(1, market.getMarketItems().getSpells().getSize() + 1);
                item = hero.getBackPack().getSpells().getItem(input - 1);
                hero.getBackPack().removeSpell((Spell)item);
                hero.changeMoney(item.getCost()/2);
            }

            counter = 0;
            System.out.println("Potions:");
            hero.getBackPack().getPotions().printItems(counter + 1);
            System.out.println("Sell a potion ? (Y/n): ");
            yesNo = Utility.inputChar();
            if(yesNo.equals("y")) {
                System.out.println("Enter an option from above list: ");
                input = Utility.intInput(1, market.getMarketItems().getPotions().getSize() + 1);
                item = hero.getBackPack().getPotions().getItem(input - 1);
                hero.getBackPack().removePotion((Potion)item);
                hero.changeMoney(item.getCost()/2);
            }

            Utility.newLine();
            Utility.newLine();
        }

        market.setState(new QuitMarket());
    }
}
