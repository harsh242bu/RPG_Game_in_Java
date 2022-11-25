// Used to quit the game altogether
public class QuitGame implements TurnState{

    @Override
    public void handleNextTurn(ValorRPG game) {
        if(game.anyMonsterReachedNexus()){
            System.out.println("Heroes lost the game!!");
        }
        else if(game.anyHeroReachedNexus()){
            System.out.println("Heroes won the game. Congratulations!!");
        }
        else{
            Utility.printStrLn("Quitting the game...! Thank you for playing");
        }
    }
}
