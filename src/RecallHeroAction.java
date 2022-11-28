// Recalls hero to the base nexus. One of the possible hero action
public class RecallHeroAction implements HeroActionState {
    @Override
    public void handleAction(ValorRPG game) {
        Hero hero = game.getHero();

        // Recall hero here
        Controller controller = new Controller();
        controller.recall(hero, game.getGameBoard());
        game.getHero().resetHero();
    }
}
