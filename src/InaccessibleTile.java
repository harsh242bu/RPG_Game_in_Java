/**
 * inaccessible tile
 */
public class InaccessibleTile implements Tile {

    @Override
    public String print() {
        return TileStatic.getBlackInaccessibleString("    ");
    }

    @Override
    public String print(String input) {
        return print();
    }
}
