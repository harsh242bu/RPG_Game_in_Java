/**
 * common tile object
 */
public class CommonTile implements Tile {
    @Override
    public String print() {
        return "    ";
    }

    @Override
    public String print(String characterIdentifier) {
        return characterIdentifier;
    }

    public void activate(Hero hero) {

    }

    public void deactivate(Hero hero){

    }

}
