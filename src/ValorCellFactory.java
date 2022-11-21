public class ValorCellFactory <T extends Cell> implements CellFactoryCreator{
//    boolean firstCell = true;
//    private final int INACCESSIBLE = 20;
//    private final int MARKET = 30;
//    private final int NEUTRAL = 50;

    private int counter;
    private final int[] MONSTER_NEXUS = {0, 1, 3, 4, 6, 7};
    private final int[] HERO_NEXUS = {56, 57, 59, 60, 62, 63};


    ValorCellFactory(){
        super();
        this.counter = 0;
    }

    @Override
    public T generateCell() {
//        int total = INACCESSIBLE + MARKET + NEUTRAL;
//        int rand_num = Utility.getRandomNum(total);
//        if(firstCell){
//            firstCell = false;
//            return (T)new CommonCell();
//        }
//        if(rand_num < INACCESSIBLE){
//            return (T)new BlockedCell();
//        }
//        else if(rand_num < INACCESSIBLE + MARKET){
//            return (T)new MarketCell();
//        }
//        else return (T)new CommonCell();
        return (T)new CommonCell();
    }
}
