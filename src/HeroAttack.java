// Concrete implementation of battle state interface. Handles hero attack
public class HeroAttack implements BattleState{

    @Override
    public void handleAttack(Battle battle) {
        Attack attack = battle.getHero().getAttack();
        battle.getMonster().dealAttack(attack);
    }

    @Override
    public void printOpponent(Battle battle) {
        MonsterData.getMonsterHeader();
        battle.getMonster().printCharacter();
        Utility.newLine();
    }
}
