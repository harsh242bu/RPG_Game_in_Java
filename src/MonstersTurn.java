public class MonstersTurn implements TurnState{

    @Override
    public void handleNextTurn(ValorRPG game) {
        // check monsters alive else remove from the game
        Utility.newLine();
        int monsterIndex = game.getMonsterTurnIndex();
        if(game.isMonsterAlive()){
            Utility.printStrLn(game.getMonster().getTag() + " turn now:");
            game.getMonster().printMonsterStats();
            Utility.printStrLn(game.getGameBoard().printBoardWithCharacter());

            Hero hero = CharacterLocation.getSurroundingHero(game.getMonster());;

            if(hero != null){
                game.setMonsterNextAction(new AttackMonsterAction());
            }
            else{
                game.setMonsterNextAction(new MoveMonsterAction());
            }
        }
        else{
            Utility.printStrLn(game.getGameBoard().printBoardWithCharacter());
            Utility.printStrLn(game.getMonster().getTag() + " monster is dead!");
            for(Character character: game.getHeroes().getLegion()){
                Hero hero = (Hero) character;
                if(hero.increaseXp(2 * game.getMonster().getIntLevel())){
                    Utility.printStrLn("Hero " + hero.getTag() + " leveled up !!");
                };
                hero.getGold().setAmount(hero.getMoney() + 500 * game.getMonster().getIntLevel());
            }

            CharacterLocation.removeMonster(game.getMonster());
            game.removeMonster();
        }

        if(monsterIndex == game.getMonsters().size() - 1){
            game.setMonsterTurnIndex(0);
            game.setNextTurn(new HeroesTurn());
        }
        else{
            game.setMonsterTurnIndex(monsterIndex + 1);
            game.setNextTurn(new MonstersTurn());
        }

    }
}
