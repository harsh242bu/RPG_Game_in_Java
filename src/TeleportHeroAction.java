public class TeleportHeroAction implements HeroActionState {

    @Override
    public void handleAction(ValorRPG game) {
        Hero hero = game.getHero();

        // Teleport hero here
        Controller controller = new Controller();
        // show prompts for lane and direction
        System.out.println("Which lane you want to teleport to:");
        int lane = Utility.intInput(1, 4);
        System.out.println("Which side you want to teleport to " + GameStaticData.BACK.toUpperCase() +
                        " for back " + GameStaticData.NEXT.toUpperCase() + " for next to another hero:");

        String direction = Utility.validateCharInput(GameStaticData.teleportOtionsList);
        controller.teleport(hero, lane, direction, game.getGameBoard());
    }
}
