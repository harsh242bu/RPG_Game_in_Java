public class Battle {
    private Monster monster;
    private Hero hero;
    private BattleState battleState;

    Battle(Hero hero, Monster monster){
        this.hero = hero;
        this.monster = monster;
        declareBattle();
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public BattleState getBattleState() {
        return battleState;
    }

    public void setBattleState(BattleState battleState) {
        this.battleState = battleState;
    }

    public void setAttack(BattleState state){
        this.setBattleState(state);
        this.battleState.handleAttack(this);
    }

    private void declareBattle() {
        System.out.println("You are fighting against the following monsters:");
        MonsterData.getMonsterHeader();
        monster.printCharacter();
    }

    public void startBattle(BattleState attackState) {
        this.setAttack(attackState);
    }

}
