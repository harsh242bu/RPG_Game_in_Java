// Class for inaccessible cell
public class BlockedCell extends Cell {
    BlockedCell(){
        super(CellData.BLOCKED);
    }
    @Override
    public void printCell() {
        System.out.print("B");
    }

    @Override
    public String addParty(PartyPiece party) {
        System.out.println("Cannot move here. This is Inaccessible cell");
        return getType();
    }
}
