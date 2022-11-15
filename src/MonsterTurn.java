// Concrete implementation of Battle state interface. Used to implement monster's turn in the battle
public class MonsterTurn implements BattleState{
    @Override
    public void handleTurn(Battle battle) {
        if(battle.checkMonstersAlive()){
            Utility.newLine();
            System.out.println("Monster turn now ---");

            Party heroes = battle.getActiveHeroes();
            Party monsters = battle.getMonsters();
            Party deadMonsters = new Party();

            for(Character character: monsters.getLegion()){
                Monster monster = (Monster)character;
                if(monster.getAttribute(Modifiable.DEFENSE) <= 0){
                    deadMonsters.addCharacter(monster);
//                    monsters.remove(monster);
                }
            }
            for(Character character: deadMonsters.getLegion()){
                Monster monster = (Monster)character;
                monsters.remove(monster);
            }

            for(int i = 0; i < Math.min(heroes.size(), monsters.size()); i++){
                MonsterData.getMonsterHeader();
                monsters.get(i).printCharacter();
                Attack monsterAttack = monsters.get(i).getAttack();
                if(monsterAttack != null){
                    heroes.get(i).dealAttack(monsterAttack);
                }
            }

            battle.setActiveHeroes(heroes);
            battle.setMonsters(monsters);

//            battle.setBattleState(new HeroTurn());
            battle.setState(new HeroTurn());
        }
        else{
            System.out.print("All monsters died!!");
            battle.setHeroWon(true);
            battle.setState(new QuitBattle());
        }
//        return battle.getBattleState().handleTurn(battle);
    }
}
