public class MoveMonsterAction implements MonsterActionState{
    @Override
    public void handleAction(ValorRPG game) {
        if(Utility.checkProbability(game.getMonsterRandomMoveChance())){
//            Monster move to the side
        }
        else{
//            Monster move forward
        }

    }
}
