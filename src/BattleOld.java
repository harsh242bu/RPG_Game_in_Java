// Battle class to initialize and start the battle
public class BattleOld {
    private Party monsters;
    private Party activeHeroes;
    private Party faintHeroes;
    private BattleStateOld battleState;
    private boolean heroWon;

    BattleOld(Party monsters, Party heroes){
        this.monsters = monsters;
        this.activeHeroes = heroes;
        this.faintHeroes = new Party();
        this.battleState = new HeroTurn();
        this.heroWon = false;
        declareBattle();
    }

    public Party getMonsters() {
        return monsters;
    }

    public void setMonsters(Party monsters) {
        this.monsters = monsters;
    }

    public Party getActiveHeroes() {
        return activeHeroes;
    }

    public void setActiveHeroes(Party activeHeroes) {
        this.activeHeroes = activeHeroes;
    }

    public Party getFaintHeroes() {
        return faintHeroes;
    }

    public void setFaintHeroes(Party faintHeroes) {
        this.faintHeroes = faintHeroes;
    }

    public BattleStateOld getBattleState() {
        return battleState;
    }

    public void setBattleState(BattleStateOld battleState) {
        this.battleState = battleState;
    }

    public boolean isHeroWon() {
        return heroWon;
    }

    public void setHeroWon(boolean heroWon) {
        this.heroWon = heroWon;
    }

    public void setState(BattleStateOld state){
        setBattleState(state);
        this.battleState.handleTurn(this);
    }

    private void declareBattle() {
        System.out.println("You are fighting against the following monsters:");
        MonsterData.getMonsterHeader();
        for(Character monster : this.monsters.getLegion()){
            monster.printCharacter();
        }
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

    public boolean checkHeroesAlive(){
        Party active = new Party();
        for(Character character: activeHeroes.getLegion()){
            Hero hero = (Hero)character;
            if(hero.getAttribute(Modifiable.HP) > 0){
//                active.remove(hero);
                active.addCharacter(hero);
            }
        }
        if(active.size() == 0) { return false; }
        else { return true; }
    }

    public boolean checkMonstersAlive(){
        Party newMonsters = new Party();
        for(Character character: monsters.getLegion()){
            Monster monster = (Monster)character;
            if(monster.getAttribute(Modifiable.DEFENSE) > 0){
                newMonsters.addCharacter(monster);
            }
        }
        if(newMonsters.size() == 0) { return false; }
        else { return true; }
    }

//    public boolean checkMonstersAlive(){
//        for(Character character: monsters.getLegion()){
//            Monster monster = (Monster)character;
//            if(monster.getAttribute(Modifiable.DEFENSE) <= 0){
//                monsters.remove(monster);
//            }
//        }
//        if(monsters.size() == 0) { return false; }
//        else { return true; }
//    }

    public void startBattle() {
        setState(new HeroTurn());
    }

    public int getMonsterMaxLevel(){
        return getMonsters().getMaxLevel();
    }
}
