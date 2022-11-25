/**
 * inaccessible tile
 */
public class InaccessibleTile implements Tile {

    @Override
    public String print() {
        return Utils.getBlackInaccessibleString("    ");
    }

    @Override
    public String print(String input) {
        return print();
    }
}
