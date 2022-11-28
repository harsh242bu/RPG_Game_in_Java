// Hero can consume a potion. One of the possible hero action
public class PotionHeroAction implements HeroActionState {
    @Override
    public void handleAction(ValorRPG game) {
        Hero hero = game.getHero();
        if(hero.hasPotions()) {
            hero.consumePotion();
        }
        else {
            Utility.printStrLn("Sorry! You don't have any potions in the inventory!");
            game.setHeroNextAction(new ChooseHeroAction());
        }

    }
}
