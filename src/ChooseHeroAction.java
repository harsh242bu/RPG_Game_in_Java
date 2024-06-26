// Responsible for populating all the possible actions hero can take and passing the
//        state to appropriate state on choosing an action
public class ChooseHeroAction implements HeroActionState {
    @Override
    public void handleAction(ValorRPG game) {

        GameStaticData.displayActions();

        int input = Utility.intInput(1, 9);

        switch (input){
            case GameStaticData.CHANGE_WEAPON:
                game.setHeroNextAction(new ChangeItemHeroAction());
                break;
            case GameStaticData.USE_POTION:
                game.setHeroNextAction(new PotionHeroAction());
                break;
            case GameStaticData.ATTACK:
                game.setHeroNextAction(new AttackHeroAction());
                break;
            case GameStaticData.MOVE:
                game.setHeroNextAction(new MoveHeroAction());
                break;
            case GameStaticData.TELEPORT:
                game.setHeroNextAction(new TeleportHeroAction());
                break;
            case GameStaticData.RECALL:
                game.setHeroNextAction(new RecallHeroAction());
                break;
            case GameStaticData.STAY:
                Utility.printStrLn("You skipped a turn");
//                game.setHeroNextAction(new RecallHeroAction());
                break;
            case GameStaticData.QUIT:
                game.setNextTurn(new QuitGame());
                break;
        }
    }
}
