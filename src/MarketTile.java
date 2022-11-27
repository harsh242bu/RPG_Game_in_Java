/**
 * market tile on the board
 */
public class MarketTile extends CommonTile {
    private Market market;

    public Market getMarket() {
        return market;
    }

    public MarketTile() {
        market = Market.getMarketInstance();
    }

    @Override
    public String print() {
        return "M";
    }

    @Override
    public String print(String input) {
        return print();
    }
}
