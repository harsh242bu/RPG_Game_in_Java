public class QuitGameOld implements GameState{

    @Override
    public void handleNextState(LegendsRPG game) {
        System.out.println("Game Over!! Thank you for playing");
        System.exit(0);
    }
}