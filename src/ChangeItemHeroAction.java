// Hero action to change a weapon or armor in the game
public class ChangeItemHeroAction implements HeroActionState {
    @Override
    public void handleAction(ValorRPG game) {
        Hero hero = game.getHero();
        Utility.printStrLn("Choose to change a weapon or armor:");
        Utility.printStrLn("1. Weapon");
        Utility.printStrLn("2. Armor");
        Utility.enterNumberPrompt();

        int input = Utility.intInput(1, 3);
        Utility.newLine();

        switch(input){
            case 1:
                if(hero.hasWeapons())
                    hero.switchWeapon();
                else {
                    Utility.printStrLn("Sorry! You don't have any weapons in the inventory!");
                    game.setHeroNextAction(new ChooseHeroAction());
                }
                break;
            case 2:
                if(hero.hasArmors())
                    hero.switchArmor();
                else {
                    Utility.printStrLn("Sorry! You don't have any armors in the inventory!");
                    game.setHeroNextAction(new ChooseHeroAction());
                }
                break;
        }
        Utility.newLine();
    }
}
