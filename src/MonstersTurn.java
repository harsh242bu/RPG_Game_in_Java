public class MonstersTurn implements TurnState{

    @Override
    public void handleNextTurn(ValorRPG game) {
        // check monsters alive else remove from the game
        game.getGameBoard().printBoardWithCharacter();
        int monsterIndex = game.getMonsterTurnIndex();
        if(game.isMonsterAlive()){
            boolean heroNearby = true;
            if(heroNearby){
                game.setMonsterNextAction(new AttackMonsterAction());
            }
            else{
                game.setMonsterNextAction(new MoveMonsterAction());
            }
        }
        else{
            game.removeMonster();
        }

        if(monsterIndex == game.getMonsters().size() - 1){
            game.setMonsterTurnIndex(0);
            game.setNextTurn(new HeroesTurn());
        }
        else{
            game.setMonsterTurnIndex(monsterIndex + 1);
            game.setNextTurn(new MonstersTurn());
        }

    }
}
