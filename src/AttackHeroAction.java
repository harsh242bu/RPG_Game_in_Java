// Responsible for creating and starting the battle if a monster is nearby
public class AttackHeroAction implements HeroActionState {
    @Override
    public void handleAction(ValorRPG game) {
        Hero hero = game.getHero();
        Monster monster = CharacterLocation.getSurroundingMonster(hero);
        if(monster != null){

            Battle battle = new Battle(hero, monster);

            battle.startBattle(new HeroAttack());

        }
        else{
            System.out.println("Cannot attack! No monster nearby");
            game.setHeroNextAction(new ChooseHeroAction());
        }
    }

}
