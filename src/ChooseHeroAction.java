public class ChooseHeroAction implements HeroActionState {
    @Override
    public void handleAction(ValorRPG game) {
        GameStaticData.displayActions();
//        Utility.printStr("Enter a number: ");

        int input = Utility.intInput(1, 7);

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
        }
    }
}
