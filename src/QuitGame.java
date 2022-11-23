// Used to quit the game altogether
public class QuitGame implements TurnState{

    @Override
    public void handleNextTurn(ValorRPG game) {
        if(game.anyMonstersAlive()){
            System.out.println("Heroes lost the game!!");
        }
        else{
            System.out.println("Heroes won the game. Congratulations!!");
        }
    }
}
