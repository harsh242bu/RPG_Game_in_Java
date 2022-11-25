// Concrete implementation of GameState. This state is used to handle movement on the board
public class MoveState implements GameState{
    @Override
    public void handleNextState(LegendsRPG game) {
        // Calculate chance of monster
        PartyPiece party = game.getParty();
        Location oldLoc = party.getLoc();
        Cell oldCell = game.getCell(oldLoc);

        game.printBoard();
        GameStaticData.displayMoveOptions();
        String move;

        move = Utility.validateCharInput(GameStaticData.movesList);
        if (move.equals(GameStaticData.I)) {
            // print info
            System.out.println("Heroes info:");
            HeroData.getHeader();
            for(Character character: party.getParty().getLegion()){
                Hero tempHero = (Hero)character;
                tempHero.printCharacter();
            }
            game.setState(new MoveState());
        }
        else if (move.equals(GameStaticData.Q)) {
            game.setState(new QuitGameOld());
        }

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
                            game.setState(new QuitGameOld());
                        }
                        monsters.addCharacter(monster);
                    }
                    System.out.println("Monsters have arrived!!");
                    BattleOld battle = new BattleOld(monsters, party.getParty());

                    battle.startBattle();
                    party.setParty(battle.getActiveHeroes());

                    if(battle.isHeroWon()){
                        game.setState(new MoveState());
                    }
                    else{
                        System.out.println("All heroes died. Quitting game now...");
                        game.setState(new QuitGameOld());
                    }

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
