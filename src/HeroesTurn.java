public class HeroesTurn implements TurnState{

    @Override
    public void handleNextTurn(ValorRPG game) {
        // check heros alive
        // check hero alive else remove from the game

        int heroIndex = game.getHeroTurnIndex();
        if(game.isHeroAlive()){
            game.setNextAction(new ChooseAction());
        }
        else{
            game.removeHero();
        }

//        int heroIndex = game.getHeroTurnIndex();

        if(heroIndex == game.getHeroes().size() - 1){
            game.setHeroTurnIndex(0);
            game.setNextTurn(new MonstersTurn());
        }
        else{
            game.setHeroTurnIndex(heroIndex + 1);
            game.setNextTurn(new HeroesTurn());
        }
    }
}
