public class MoveHeroAction implements HeroActionState {
    @Override
    public void handleAction(ValorRPG game) {
        GameStaticData.displayMoveOptions();

        String move;

        move = Utility.validateCharInput(GameStaticData.movesList);
        if (move.equals(GameStaticData.I)) {
            // print info
            System.out.println("Heroes info:");
            HeroData.getHeader();

            Hero hero = game.getHero();
            hero.printCharacter();

            game.setHeroNextAction(new MoveHeroAction());
        }
        else if (move.equals(GameStaticData.Q)) {
            game.setTurnState(new QuitGame());
        }

        // Change heroes location here

        Location nextLoc = game.getLocation(move);
        Cell nextCell = game.getCell(nextLoc);

        }
}
