// Defining various moves used in the game
import java.util.ArrayList;
import java.util.List;

public class GameStaticData {
    final static String W = "w";
    final static String A = "a";
    final static String S = "s";
    final static String D = "d";
    final static String Q = "q";
    final static String I = "i";
    final static String BACK = "b";
    final static String NEXT = "n";
    final static int CHANGE_WEAPON = 1;
    final static int USE_POTION = 2;
    final static int ATTACK = 3;
    final static int MOVE = 4;
    final static int TELEPORT = 5;
    final static int RECALL = 6;
    final static int QUIT = 7;
    final static List<String> movesList = new ArrayList<String>() {{ add(W); add(A); add(S); add(D); add(I); add(Q);}};
    final static List<String> teleportOtionsList = new ArrayList<String>() {{ add(BACK); add(NEXT);}};

    static void displayMoveOptions(){
        System.out.println("Enter your move from the following:");
        System.out.println(W.toUpperCase() + " - To go up");
        System.out.println(A.toUpperCase() + " - To go left");
        System.out.println(S.toUpperCase() + " - To go down");
        System.out.println(D.toUpperCase() + " - To go right");
        System.out.println(I.toUpperCase() + " - To show info");
        System.out.println(Q.toUpperCase() + " - To quit the game");
    }

    static void displayActions(){
        Utility.newLine();
        Utility.printStrLn("Choose from one of the following actions:");
        Utility.printStrLn("1. Choose a weapon or armor");
        Utility.printStrLn("2. Use a potion");
        Utility.printStrLn("3. Attack a Monster using weapon or spell (if nearby)");
        Utility.printStrLn("4. Move in the map");
        Utility.printStrLn("5. Teleport to another lane");
        Utility.printStrLn("6. Recall");
        Utility.printStrLn("7. Quit game");
        Utility.newLine();
        Utility.enterNumberPrompt();
    }
}
