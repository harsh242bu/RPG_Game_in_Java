// Used to quit the game altogether
public class QuitGame implements GameState{
    @Override
    public void handleNextState(LegendsRPG game) {
        System.out.println("Game Over!! Thank you for playing");
        System.exit(0);
//        game.setState(new MoveState());
    }
}
