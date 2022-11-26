public class NexusTile extends MarketTile {



    private Position position;
    public NexusTile() {

    }

    @Override
    public String print() {
        return TileStatic.getBlueNexusString("    ");
    }

    @Override
    public String print(String characterIdentifier) {
        return TileStatic.getBlueNexusString(characterIdentifier);
    }


}
