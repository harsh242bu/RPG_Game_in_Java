public class MonstersTurn implements TurnState{

    @Override
    public void handleNextTurn(ValorRPG game) {
        // check monsters alive else remove from the game
        Utility.printStrLn(game.getMonster().getTag() + " turn now:");
        Utility.printStrLn(game.getGameBoard().printBoardWithCharacter());
        int monsterIndex = game.getMonsterTurnIndex();
        if(game.isMonsterAlive()){
            Hero hero = CharacterLocation.getSurroundingHero(game.getMonster());;

            if(hero != null){
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
