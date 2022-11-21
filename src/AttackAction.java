public class AttackAction implements ActionState{
    @Override
    public void handleAction(ValorRPG game) {
        boolean monsterNearby = true;
        if(monsterNearby){
            Hero hero = (Hero)game.getHeroes().get(game.getHeroTurnIndex());
            Monster monster = (Monster)game.getNearbyMonster();

            Battle battle
        }
        else{
            System.out.println("Cannot attack! No monster nearby");
            game.setNextAction(new ChooseAction());
        }
    }
}
