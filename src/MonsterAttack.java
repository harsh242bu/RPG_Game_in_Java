public class MonsterAttack implements BattleState{
    @Override
    public void handleAttack(Battle battle) {
        Attack attack = battle.getMonster().getAttack();
        battle.getHero().dealAttack(attack);
    }
}
