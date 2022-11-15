// Quit market state. Used to quit the market
public class QuitMarket implements InMarketState{
    @Override
    public void handleInMarketState(Market market) {
        System.out.println("Exit market ? (Y/n): ");
        String yesNo = Utility.inputChar();
        if(yesNo.equals("n")){
            System.out.println("Choose whether to buy or sell an item.");
            System.out.println("1. Buy items from the market");
            System.out.println("2. Sell items to the market");
            int input = Utility.intInput(1, 3);
            if(input == 1){
                market.setState(new BuyingState());
            }
            else if(input == 2){
                market.setState(new SellingState());
            }
        }
        else {
            System.out.println("Thank you for shopping with us");
        }
    }
}
