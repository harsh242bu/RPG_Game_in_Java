// Concrete class of GameState interface. Implementation of handle state methods
public class MarketState implements GameState{

    @Override
    public void handleNextState(LegendsRPG game) {
        System.out.println("You have arrived at the Market!!");
        System.out.print("Want to go inside ?? (Y/n): ");
        String str = Utility.inputChar();
        if(str.equals("y")) {
            Utility.newLine();
            Market market = new Market(game.getParty().getParty());
            market.getInsideMarket();
            game.getParty().setParty(market.getHeroParty());
        }

        game.setState(new MoveState());
    }
}
