// Generates random cell of different types in 20:30:50 ratio
public class BalancedCellFactory<T extends Cell> implements CellFactoryCreator{
    boolean firstCell = true;
    private final int INACCESSIBLE = 20;
    private final int MARKET = 30;
    private final int NEUTRAL = 50;

    @Override
    public T generateCell() {
        int total = INACCESSIBLE + MARKET + NEUTRAL;
        int rand_num = Utility.getRandomNum(total);
        if(firstCell){
            firstCell = false;
            return (T)new CommonCell();
        }
        if(rand_num < INACCESSIBLE){
            return (T)new BlockedCell();
        }
        else if(rand_num < INACCESSIBLE + MARKET){
            return (T)new MarketCell();
        }
        else return (T)new CommonCell();
    }

    // Random cell generation logic
    // Balanced cell generation -> 20% inaccessible, 30% market, 50% common spaces

}
