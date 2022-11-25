public class HeroesTurn implements TurnState{

    @Override
    public void handleNextTurn(ValorRPG game) {
        // check heros alive
        // check hero alive else remove from the game
        if(!game.anyMonsterReachedNexus() && !game.anyHeroReachedNexus()){
            int heroIndex = game.getHeroTurnIndex();
            if(game.isHeroAlive()){
                game.setHeroNextAction(new ChooseHeroAction());
            }
            else{
                game.removeHero();
            }

            if(heroIndex == game.getHeroes().size() - 1){
                game.setHeroTurnIndex(0);
                game.setNextTurn(new MonstersTurn());
            }
            else{
                game.setHeroTurnIndex(heroIndex + 1);
                game.setNextTurn(new HeroesTurn());
            }
        }
        else{
            game.setNextTurn(new QuitGame());
        }


    }
}
