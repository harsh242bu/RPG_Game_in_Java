// Quit market state. Used to quit the market
public class QuitMarket implements InMarketState{
    @Override
    public void handleInMarketState(Market market, Hero hero) {
        System.out.println("Exit market ? (Y/n): ");
        String yesNo = Utility.yesNoInput();
        if(yesNo.equals("n")){
            Market.marketOptions();
            int input = Utility.intInput(1, 3);
            if(input == 1){
                market.setState(new BuyingState(), hero);
            }
            else if(input == 2){
                market.setState(new SellingState(), hero);
            }
        }
        else {
            System.out.println("Thank you for shopping with us");
        }
    }
}
