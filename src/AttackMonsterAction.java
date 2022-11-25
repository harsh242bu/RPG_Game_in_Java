public class AttackMonsterAction implements MonsterActionState{
    @Override
    public void handleAction(ValorRPG game) {

        Hero hero = game.getHero();
        Monster monster = game.getMonster();

        Battle battle = new Battle(hero, monster);
        // check monster alive else remove from the game

        battle.startBattle(new MonsterAttack());
        // set hero back in the game (bcoz stored in new reference inside battle)
        // set monster back in the game

    }
}
