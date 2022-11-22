public class AttackAction implements ActionState{
    @Override
    public void handleAction(ValorRPG game) {
        boolean monsterNearby = true; // change it later
        if(monsterNearby){
            Hero hero = (Hero)game.getHeroes().get(game.getHeroTurnIndex());
            Monster monster = new Monster(null, 0, 0, 0,0); // (Monster)game.getNearbyMonster();

            Battle battle = new Battle(hero, monster);
            // check monster alive else remove from the game

            battle.startBattle(new HeroAttack());
            // set hero back in the game (bcoz stored in new reference inside battle)
            // set monster back in the game

        }
        else{
            System.out.println("Cannot attack! No monster nearby");
            game.setNextAction(new ChooseAction());
        }
    }
}
