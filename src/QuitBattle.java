// Concrete implementation of BattleState. Used to handle the quitting of the battle.
public class QuitBattle implements BattleState{
    @Override
    public void handleTurn(BattleOld battle) {
        System.out.println("Quitting the battle ---");
        // increase their hp
        // merge faint and active

        Party heroes = new Party();
        for(Character character: battle.getActiveHeroes().getLegion()){
            Hero hero = (Hero) character;
            hero.activeLevelUp(battle.getMonsterMaxLevel());

            heroes.addCharacter(hero);
        }
        for(Character character: battle.getFaintHeroes().getLegion()){
            Hero hero = (Hero) character;
            hero.inactiveLevelUp();

            heroes.addCharacter(hero);
        }
        battle.setActiveHeroes(heroes);
//        return heroes;
    }
}
