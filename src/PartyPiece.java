// Hero Party with location information included. Used to place hero party on the board
public class PartyPiece extends Piece{
    private Location loc;
    private Party party;

    public PartyPiece(String displayStr, Location loc) {
        super(displayStr);
        this.party = new Party();
        this.loc = new Location(loc);
    }

    public Location getLoc() {
        return loc;
    }

    public void setLoc(Location loc) {
        this.loc = loc;
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    public int getPartySize(){
        return this.party.size();
    }

    public void move(Location nextLoc) {
        setLoc(nextLoc);
    }

    public void printLoc() {
        System.out.print("X = " + loc.getX() + ", Y = " + loc.getY());
    }
}
