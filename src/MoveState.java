// Concrete implementation of GameState. This state is used to handle movement on the board
public class MoveState implements GameState{
    @Override
    public void handleNextState(LegendsRPG game) {
        // Calculate chance of monster
        PartyPiece party = game.getParty();
        Location oldLoc = party.getLoc();
        Cell oldCell = game.getCell(oldLoc);

        game.printBoard();
        GameMovesData.displayMoveOptions();
        String move;
//        do {
            move = Utility.validateCharInput(GameMovesData.movesList);
            if (move.equals(GameMovesData.I)) {
                // print info
                System.out.println("Heroes info:");
                HeroData.getHeader();
                for(Character character: party.getParty().getLegion()){
                    Hero tempHero = (Hero)character;
                    tempHero.printCharacter();
                }
//                game.printBoard();
                game.setState(new MoveState());
//                GameData.displayMoveOptions();
            }
            else if (move.equals(GameMovesData.Q)) {
                game.setState(new QuitGame());
            }
//        }while(move.equals(GameData.I));

        Location nextLoc = game.getLocation(move);
        Cell nextCell = game.getCell(nextLoc);

        party.move(nextLoc);

        switch (nextCell.addParty(party)){
            case(CellData.COMMON):
                oldCell.removeParty();
                // check for battle or move state
                if(game.battleProbability()){
                    int maxLevel = game.getMaxHeroLevel();
                    Party monsters = new Party();
                    for(int i = 0; i < game.getParty().getPartySize(); i++){
                        Monster monster = game.getMonsterFactory().getMonster(maxLevel);
                        if(monster == null){
                            System.out.println("Not enough monsters to fight!!");
                            game.setState(new QuitGame());
                        }
                        monsters.addCharacter(monster);
                    }
                    System.out.println("Monsters have arrived!!");
                    Battle battle = new Battle(monsters, party.getParty());

//                    Party newParty =
                    battle.startBattle();
                    party.setParty(battle.getActiveHeroes());
                    // How to calculate
                    if(battle.isHeroWon()){
                        game.setState(new MoveState());
                    }
                    else{
                        System.out.println("All heroes died. Quitting game now...");
                        game.setState(new QuitGame());
                    }
                    // If battle won -> moveState
                    // If lost
                }
                game.setState(new MoveState());
                break;
            case (CellData.MARKET):
                oldCell.removeParty();
                game.setState(new MarketState());
                break;
            case (CellData.BLOCKED):
                party.move(oldLoc);
                game.setState(new MoveState());
                break;
        }

    }
}
