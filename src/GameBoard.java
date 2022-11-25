// Represents 8x8 board of our game
public abstract class GameBoard {
    protected Cell matrix[][];
    private int rows;
    private int cols;


    GameBoard(int rows, int cols){

        this.rows = rows;
        this.cols = cols;
        this.matrix = new Cell[rows][cols];
    }
    GameBoard(int size){
        this(size, size);
    }


    public Cell getCell(Location loc){
        Cell cell = this.matrix[loc.getX()][loc.getY()];
        return cell;
    }

    public void printBoard(){
        for(int i = 0; i < rows; i++){
            Utility.printLine(cols);
            for(int j = 0; j < cols; j++){
                System.out.print("|");
                System.out.print("  ");

                matrix[i][j].printCell();

                System.out.print("  ");
            }
            System.out.print("|\n");
        }
        Utility.printLine(cols);
    }

    public boolean isValidLocation(Location loc){
        int x = loc.getX();
        int y = loc.getY();
        if(x < rows && x >= 0 && y < cols && y >= 0){
            return true;
        }
        else return false;
    }

    public Location getLocationFromMove(String move, Location loc){
        int x = loc.getX();
        int y = loc.getY();

        switch(move){
            case(GameStaticData.W):
                return new Location(x-1, y);
            case(GameStaticData.A):
                return new Location(x, y-1);
            case(GameStaticData.S):
                return new Location(x+1,y);
            case(GameStaticData.D):
                return new Location(x,y+1);
        }
        return loc;
    }

    public abstract void setupGame();
    public abstract void startGame();

//    public abstract void setState(GameState state);
}
