// Cell class - cell represents 1 unit in the game board

public abstract class Cell {
    String type;
    Piece group;

    public Cell(String type) {
        this.type = type;
        this.group = new EmptyPiece();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Piece getGroup() {
        return group;
    }

    public void setGroup(Piece group) {
        this.group = group;
    }

    public void printCell() {
        System.out.print("C");
    }
    public void removeParty(){
        setGroup(new EmptyPiece());
    }

    public abstract String addParty(PartyPiece party);
}
