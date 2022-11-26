public class RecallHeroAction implements HeroActionState {
    @Override
    public void handleAction(ValorRPG game) {
        Hero hero = game.getHero();

        // Recall hero here
        Controller controller = new Controller();
        controller.recall(hero, game.getGameBoard());
    }
}
