// Concrete implementation of battle state. Used to handle hero's turn in the battle
public class HeroTurn implements BattleState{
    @Override
    public void handleTurn(BattleOld battle) {
        if(battle.checkHeroesAlive()){
            Utility.newLine();
            System.out.println("Hero turn now ---");
            Party activeHeroes = battle.getActiveHeroes();
            Party faintHeroes = battle.getFaintHeroes();

            for(Character character: activeHeroes.getLegion()){
                Hero hero = (Hero)character;
                if(hero.getAttribute(Modifiable.HP) <= 0){
//                    activeHeroes.remove(hero);
                    faintHeroes.addCharacter(hero);
                }
            }
            for(Character character: faintHeroes.getLegion()){
                Hero hero = (Hero)character;
                activeHeroes.remove(hero);
            }

            Party monsters = battle.getMonsters();
            for(int i = 0; i < Math.min(activeHeroes.size(), monsters.size()); i++){

                Attack heroAttack = activeHeroes.get(i).getAttack();
                if(heroAttack != null){
                    monsters.get(i).dealAttack(heroAttack);
                }
            }

            battle.setActiveHeroes(activeHeroes);
            battle.setFaintHeroes(faintHeroes);
            battle.setMonsters(monsters);

//            battle.setBattleState(new MonsterTurn());
            battle.setState(new MonsterTurn());
        }
        else{
//            System.out.print("All heroes died!!");
            battle.setHeroWon(false);
//            battle.setBattleState(new QuitBattle());
            battle.setState(new QuitBattle());
        }
//        return battle.getBattleState().handleTurn(battle);
    }

//    public boolean checkHeroesAlive(){
//        for(Character character: activeHeroes.getLegion()){
//            Hero hero = (Hero)character;
//            if(hero.getAttribute(Modifiable.HP) <= 0){
//                activeHeroes.remove(hero);
//                faintHeroes.addCharacter(hero);
//            }
//        }
//        if(activeHeroes.size() == 0) { return false; }
//        else { return true; }
//    }
}
