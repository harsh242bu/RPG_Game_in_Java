// Concrete implementation of turnState interface. Handles heroes turn in the game
public class HeroesTurn implements TurnState{

    @Override
    public void handleNextTurn(ValorRPG game) {
        // check heros alive
        // check hero alive else remove from the game
        Utility.printStrLn(game.getGameBoard().printBoardWithCharacter());
        int heroIndex = game.getHeroTurnIndex();
        if(game.isHeroAlive()){
            Hero hero = game.getHero();
            Utility.printStrLn(hero.getTag() + " your turn now:");
            hero.printHeroStats();
            if(CharacterLocation.inBase(game.getHero())){
//            if(true){
                Position location = CharacterLocation.getLocation(hero);

                MarketTile marketTile = (MarketTile) game.getGameBoard().getTile(location.getX(), location.getY());
                Market market = marketTile.getMarket();

                Utility.newLine();
                System.out.println("You have arrived at the Market!!");
                System.out.print("Want to go inside ?? (Y/n): ");
                String str = Utility.yesNoInput();
                if(str.equals("y")) {
                    market.getInsideMarket(hero);
                }
            }
            game.setHeroNextAction(new ChooseHeroAction());
        }
        else{
            Utility.printStrLn(game.getHero().getTag() + " is dead!");
            Utility.printStrLn("Resetting the hero...");
            game.getHero().resetHero();
            Controller controller = new Controller();
            controller.respawnHero(game.getHero(), game.getGameBoard());
//                game.removeHero();
            // reset hero attributes and respawn the hero
        }

        if(heroIndex == game.getHeroes().size() - 1){
            game.setHeroTurnIndex(0);
            game.setNextTurn(new MonstersTurn());
        }
        else{
            game.setHeroTurnIndex(heroIndex + 1);
            game.setNextTurn(new HeroesTurn());
        }

    }
}
