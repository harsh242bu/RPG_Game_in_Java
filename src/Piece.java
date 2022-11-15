// Piece to place on the game board
import java.util.Objects;

public class Piece {
    private String displayStr;

    public Piece(String displayStr) {
        this.displayStr = displayStr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return Objects.equals(displayStr, piece.displayStr);
    }

    public void printPiece() {
        System.out.print(displayStr);
    }


    public String getDisplayStr() {
        return displayStr;
    }

    public void setDisplayStr(String displayStr) {
        this.displayStr = displayStr;
    }
}
