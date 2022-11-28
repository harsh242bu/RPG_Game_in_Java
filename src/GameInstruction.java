// Responsible for printing game instructions before start of the game
import java.util.concurrent.TimeUnit;

public class GameInstruction {
    public static void printGameInstruction() {
        System.out.println("Legends of Valor is played in an 8x8 grid of spaces. The grid is divided in three lanes, each \n" +
                "separated by a column of impassible spaces. Each lane has a width of two spaces. Each space\n" +
                "can hold up to one monster and up to one hero. A space cannot hold two monsters or two \n" +
                "heroes.\n\n" +
                "The first two columns are the first (top) lane. The third column is a wall between the first and \n" +
                "the second lane. The fourth and the fifth columns are the second (middle) lane. The sixth \n" +
                "column is another wall. The seventh and eighth columns are the third (bottom) lane. The first \n" +
                "and the last row will represent a Nexus. The first row (at the top of the screen) is the monsters’ \n" +
                "Nexus while the last row (at the bottom of the screen) is the heroes’ Nexus. See the layout\n" +
                "below:\n");
        System.out.println(new Board().printBoard());
        System.out.println();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("There are some features for the game:");
        System.out.println("1. Monster will randomly move forward or to the side with some probability.");
        System.out.println("2. Tile have different functionality and can enhance different hero attributes.");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("The game will start in 3 seconds, enjoy!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println(3 + "\n\n\n\n");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println(2 + "\n\n\n\n");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println(1 + "\n\n\n\n");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
