// Neutral cell in the game
public class CommonCell extends Cell {
    CommonCell(){
        super(CellData.COMMON);
    }
    @Override
    public void printCell() {
        getGroup().printPiece();
    }
    @Override
    public String addParty(PartyPiece party) {
        setGroup(party);
        System.out.print("Your party moved to location: " );
        party.printLoc();
        Utility.newLine();
        return getType();
    }
}
