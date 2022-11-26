// Interface containing handle state method. All the concrete states will be an instance of this class.
public interface InMarketState {
    public void handleInMarketState(Market market, Hero hero);
}
