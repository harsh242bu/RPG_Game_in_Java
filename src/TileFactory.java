import java.util.Random;

/**
 * tile factory generate random tile with given probability
 */
public class TileFactory {
    private Random random;

    private double PLAIN_RATIO;
    private double BUSH_RATIO;
    private double CAVE_RATIO;
    private double KOULOU_RATIO;


    public TileFactory() {
    }

    public TileFactory(Random random, double cave, double plain, double bush, double koulou) {
        this.random = random;
        PLAIN_RATIO = plain;
        BUSH_RATIO = bush;
        CAVE_RATIO = cave;
        KOULOU_RATIO = koulou;
    }

    /**
     * return random tile with given probability
     *
     * @return tile
     */
    public Tile getTile() {
        double temp = 0;
        double i = random.nextDouble();
        if (i <= (temp = temp + BUSH_RATIO)) {
            return new BushTile();
        } else if (i <= (temp = temp + CAVE_RATIO)) {
            return new CaveTile();
        } else if (i <= (temp = temp + KOULOU_RATIO)) {
            return new KoulouTile();
        } else {
            return new CommonTile();
        }
    }


    public static void main(String[] args) {
        TileFactory tileFactory = new TileFactory(new Random(), 0.2, 0.4, 0.2, 0.2);
        System.out.println(tileFactory.getTile().print("M1  "));
        System.out.println();
        System.out.println(tileFactory.getTile().print());
        System.out.println();
        System.out.println(tileFactory.getTile().print());
        System.out.println();
        System.out.println(tileFactory.getTile().print());
        System.out.println();
        System.out.println(tileFactory.getTile().print());
        System.out.println();
        System.out.println(tileFactory.getTile().print());
        System.out.println();


    }
}
