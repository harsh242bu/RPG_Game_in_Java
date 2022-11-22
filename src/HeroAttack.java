public class HeroAttack implements BattleState{

    @Override
    public void handleAttack(Battle battle) {
        Attack attack = battle.getHero().getAttack();
        battle.getMonster().dealAttack(attack);
    }
}
