

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 * class of world with two-dimensional array
 */
public class Board {
    private final int DEFAULT_SIZE = 8;
    private final double PLAIN_RATIO = 0.4;
    private final double BUSH_RATIO = 0.2;
    private final double CAVE_RATIO = 0.2;
    private final double KOULOU_RATIO = 0.2;
    private final long seed = 1234;

    public int getDEFAULT_SIZE() {
        return DEFAULT_SIZE;
    }

    private final Random random;
    private Tile[][] board;

    public Board() {
        this.random = new Random(this.seed);
        initializeWorld();
    }

    /**
     * allow user to insert a seed to create different map
     *
     * @param seed
     */
    public Board(long seed) {
        this.random = new Random(seed);
        initializeWorld();
    }

    /**
     * initialize the map with the given seed and default board size and ratio of map
     */
    private void initializeWorld() {
        TileFactory tileFactory = new TileFactory(random, CAVE_RATIO, PLAIN_RATIO, BUSH_RATIO, KOULOU_RATIO);
        board = new Tile[DEFAULT_SIZE][DEFAULT_SIZE];
        // create the monster nexus row
        for (int i = 0; i < board.length; i++) {
            if (i != 2 && i != 5) {
                board[0][i] = new NexusTile();
            } else {
                board[0][i] = new InaccessibleTile();
            }
        }
        // create the lane
        for (int i = 1; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (j != 2 && j != 5) {
                    board[i][j] = tileFactory.getTile();
                } else {
                    board[i][j] = new InaccessibleTile();
                }
            }
        }
        //create the hero nexus
        for (int i = 0; i < board.length; i++) {
            if (i != 2 && i != 5) {
                board[board.length - 1][i] = new NexusTile();
            } else {
                board[board.length - 1][i] = new InaccessibleTile();
            }
        }

    }

    /**
     * print the board with the player position
     *
     * @return String of board
     */
    public String printBoard(CharacterLocation cbr) {
        return null;
    }

    /**
     * print the board without the player position
     *
     * @return String of board
     */
    public String printBoard() {
        String result = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                result += board[i][j].print();
            }
            result += "\n";
        }
        return result;
    }


    /**
     * print the board without the player position
     *
     * @return String of board
     */
    public String printBoardWithCharacter() {
        System.out.println("Game Board ");
        Set<Position> heroPositions = CharacterLocation.getheroLocation();
//        System.out.println(heroPositions);
        Set<Position> monsterPositions = CharacterLocation.getmonsterLocation();
//        System.out.println("Monster position: "+monsterPositions);
        Set<Position> monsterPosition = CharacterLocation.getmonsterLocation();
        String result = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                String tag="";

                Position position = new Position(i, j);
                if(heroPositions.contains(position) && monsterPosition.contains(position)){
                    tag+=CharacterLocation.getHero(position ).getTag();
                    tag+=CharacterLocation.getMonster(position).getTag();
                } else if (heroPositions.contains(position)) {
                    tag+=CharacterLocation.getHero(position ).getTag()+"  ";
                } else if (monsterPosition.contains(position)) {
                    tag+="  "+CharacterLocation.getMonster(position).getTag();
                }
                else {
                    tag+="    ";
                }
                result += board[i][j].print(tag);
            }
            result += "\n";
        }
        return result;
    }

    /**
     * @param i row value
     * @param j column value
     * @return tile
     */
    public Tile getTile(int i, int j) {
        return board[i][j];
    }

//    public static void main(String[] args) throws CloneNotSupportedException {
//        Board board = new Board();
//        HeroFactory heroFactory = new HeroFactory();
//        Hero hero = heroFactory.getHero(1);
//        hero.setTag("H1");
//        Hero hero1 = heroFactory.getHero(2);
//        hero1.setTag("H2");
//
//        Hero hero2 = heroFactory.getHero(3);
//        hero2.setTag("H3");
//        Controller controller= new Controller();
//        ArrayList<Hero> list = new ArrayList<>();
//        list.add(hero);
//        list.add(hero1);
//        list.add(hero2);
//        controller.respawnAllHero(list);
//        controller.respawnMonster(1);
//
//        Scanner scanner = new Scanner(System.in);
//        while(true) {
//            System.out.println(board.printBoardWithCharacter());
//            System.out.print("Type in command for h1: ");
//            String s = scanner.nextLine();
//            if(s.matches("[wasd]")){
//                controller.move(hero,s, board);
//            }
//            else if(s.equalsIgnoreCase("b")){
//                controller.backToBase(hero, board);
//            } else if (s.equalsIgnoreCase("t")) {
//                System.out.println("which lane you want to teleport to:");
//                int lane = scanner.nextInt();
//                scanner.nextLine();
//                System.out.println("which side you want to teleport to b for back s for side:");
//                String direction = scanner.nextLine();
//                controller.teleport(hero,lane,direction, board);
//
//
//            }
//
//        }
//    }


}
