public class MonsterAttack implements BattleState{
    @Override
    public void handleAttack(Battle battle) {
        Attack attack = battle.getMonster().getAttack();
        battle.getHero().dealAttack(attack);
    }

    @Override
    public void printOpponent(Battle battle) {
        HeroData.getHeader();
        battle.getHero().printCharacter();
        Utility.newLine();
    }
}
