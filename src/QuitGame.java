// Used to quit the game altogether
public class QuitGame implements TurnState{

    @Override
    public void handleNextTurn(ValorRPG game) {
        Hero hero = game.getHero();
        Monster monster = game.getMonster();

        if(CharacterLocation.anyCharacterReachedNexus(monster)){
            System.out.println("Heroes lost the game!!");
        }
        else if(CharacterLocation.anyCharacterReachedNexus(hero)){
            System.out.println("Heroes won the game. Congratulations!!");
        }
        else{
            Utility.printStrLn("Quitting the game...! Thank you for playing");
            System.exit(0);
        }
    }
}
