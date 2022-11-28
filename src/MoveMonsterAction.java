// Responsible for monster's movement in the map
public class MoveMonsterAction implements MonsterActionState{
    @Override
    public void handleAction(ValorRPG game) {
        Monster monster = game.getMonster();
        if(Utility.checkProbability(game.getMonsterRandomMoveChance())){
//            Monster move to the side
            game.getGameController().moveSide(monster, game.getGameBoard());
        }
        else{
//            Monster move forward
            game.getGameController().moveDown(monster, game.getGameBoard());
        }
        if(CharacterLocation.anyCharacterReachedNexus(monster)){
            game.setNextTurn(new QuitGame());
        }

    }
}
