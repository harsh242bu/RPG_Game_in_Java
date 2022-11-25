public class AttackHeroAction implements HeroActionState {
    @Override
    public void handleAction(ValorRPG game) {
        boolean monsterNearby = true; // change it later
        if(monsterNearby){
            Hero hero = game.getHero();
            Monster monster = new Monster(null, 0, 0, 0,0); // (Monster)game.getNearbyMonster();

            Battle battle = new Battle(hero, monster);
            // check monster alive else remove from the game

            battle.startBattle(new HeroAttack());
            // set hero back in the game (bcoz stored in new reference inside battle)
            // set monster back in the game

        }
        else{
            System.out.println("Cannot attack! No monster nearby");
            game.setHeroNextAction(new ChooseHeroAction());
        }
    }

//    public static void main(String[] args) {
//        new GameSetup().loadData();
//        HeroFactory heroFactory = new HeroFactory();
//        heroFactory.initializeHeroes();
//
//
//        MonsterFactory monsterFactory = new MonsterFactory();
//
//        Hero hero = WarriorData.getHero(0);
//        Monster monster = monsterFactory.getMonster(1);
//
//        Battle battle = new Battle(hero, monster);
//        // check monster alive else remove from the game
//
//        battle.startBattle(new HeroAttack());
//    }
}
