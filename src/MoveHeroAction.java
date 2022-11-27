public class MoveHeroAction implements HeroActionState {
    @Override
    public void handleAction(ValorRPG game) {
        GameStaticData.displayMoveOptions();

        String move;
        Hero hero = game.getHero();
        move = Utility.validateCharInput(GameStaticData.movesList);
        if (move.equals(GameStaticData.I)) {
            // print info
            System.out.println("Heroes info:");
            HeroData.getHeader();

//            Hero hero = game.getHero();
            hero.printCharacter();

            game.setHeroNextAction(new MoveHeroAction());
        }
        else if (move.equals(GameStaticData.Q)) {
            game.setTurnState(new QuitGame());
        }

        // Change heroes location here
        Controller controller = new Controller();
        if(!controller.move(hero, move, game.getGameBoard())){
            game.setHeroNextAction(new MoveHeroAction());
        };
        // check for reach nexus condition
        if(CharacterLocation.anyCharacterReachedNexus(hero)){
            game.setNextTurn(new QuitGame());
        }
    }
}
