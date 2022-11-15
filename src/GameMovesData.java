// Defining various moves used in the game
import java.util.ArrayList;
import java.util.List;

public class GameMovesData {
    final static String W = "w";
    final static String A = "a";
    final static String S = "s";
    final static String D = "d";
    final static String Q = "q";
    final static String I = "i";
    final static List<String> movesList = new ArrayList<String>() {{ add(W); add(A); add(S); add(D); add(I); add(Q);}};

    static void displayMoveOptions(){
        System.out.println("Enter your move from the following:");
        System.out.println(W + " - To go up");
        System.out.println(A + " - To go left");
        System.out.println(S + " - To go down");
        System.out.println(D + " - To go right");
        System.out.println(I + " - To show info");
        System.out.println(Q + " - To quit the game");
    }
}
