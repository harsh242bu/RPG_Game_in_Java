// Subclass of cell. Represents market cell
public class MarketCell extends Cell{
    public MarketCell() {
        super(CellData.MARKET);
    }



    @Override
    public void printCell() {

        if(!getGroup().equals(new EmptyPiece()))
            getGroup().printPiece();
        else
            System.out.print("M");
    }

    @Override
    public String addParty(PartyPiece party) {
        setGroup(party);
//        System.out.println("You have arrived at the Market");
        return getType();
    }
}
