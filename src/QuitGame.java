// Used to quit the game altogether
public class QuitGame implements TurnState{

    @Override
    public void handleNextTurn(ValorRPG game) {
        Hero hero = game.getHero();
        Monster monster = game.getMonster();

        Utility.printStrLn(game.getGameBoard().printBoardWithCharacter());
        if(CharacterLocation.anyCharacterReachedNexus(monster)){
            System.out.println("Sorry!! Heroes lost the game!!");
            System.exit(0);
        }
        else if(CharacterLocation.anyCharacterReachedNexus(hero)){
            System.out.println("Heroes won the game. Congratulations!!");
            System.exit(0);
        }
        else{
            Utility.printStrLn("Quitting the game...! Thank you for playing");
            System.exit(0);
        }
    }
}
