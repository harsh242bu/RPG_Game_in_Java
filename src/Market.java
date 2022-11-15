// Market class. Contains items we can buy from the market, heroes, etc
public class Market {
    private MarketInventory marketItems;
    private InMarketState marketState;
    private Party heroParty;

    Market(Party party){
        marketItems = new MarketInventory();
        this.heroParty = party;

        marketItems.setWeapons(WeaponsData.weapons);
        marketItems.setArmors(ArmorsData.armors);
        marketItems.setPotions(PotionsData.potions);
        marketItems.setSpells(FireSpellsData.fireSpells);
        marketItems.addSpells(IceSpellsData.iceSpells);
        marketItems.addSpells(LightningSpellsData.lightningSpells);
    }

    public MarketInventory getMarketItems() {
        return marketItems;
    }

    public void setMarketItems(MarketInventory marketItems) {
        this.marketItems = marketItems;
    }

    public InMarketState getMarketState() {
        return marketState;
    }

    public void setMarketState(InMarketState marketState) {
        this.marketState = marketState;
    }

    public Party getHeroParty() {
        return heroParty;
    }

    public void setHeroParty(Party heroParty) {
        this.heroParty = heroParty;
    }

    public void setState(InMarketState state){
        this.setMarketState(state);
        this.marketState.handleInMarketState(this);
    }

    public void getInsideMarket() {
        System.out.println("Choose whether to buy or sell an item.");
        System.out.println("1. Buy items from the market");
        System.out.println("2. Sell items to the market");
        int input = Utility.intInput(1, 3);
        if(input == 1){
            this.setState(new BuyingState());
        }
        else if(input == 2){
            this.setState(new SellingState());
        }
    }
}
