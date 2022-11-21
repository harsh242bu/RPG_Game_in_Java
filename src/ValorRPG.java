public class ValorRPG extends GameBoard{
    private PartyPiece party;
    private Party Heroes;
    private Party Monsters;
    private final Location startLoc = new Location(0,0);
    private final int TOTAL_PLAYERS = 3;
//    private final static int battleChance = 40;
    private TurnState turnState;
    private ActionState actionState;
    private MonsterFactory monsterFactory;
    private int heroTurnIndex;
    private int monsterTurnIndex;

    ValorRPG(int rows, int cols){
        super(rows, cols);
        this.party = new PartyPiece("X", startLoc);

        BalancedCellFactory factory = new BalancedCellFactory();
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                matrix[i][j] = factory.generateCell();
            }
        }
        getCell(startLoc).addParty(party);
        this.turnState = new HeroesTurn();
        this.monsterFactory = new MonsterFactory();
    }
    ValorRPG(int size){
        this(size, size);
    }

    public MonsterFactory getMonsterFactory() {
        return monsterFactory;
    }

    public void setMonsterFactory(MonsterFactory monsterFactory) {
        this.monsterFactory = monsterFactory;
    }

    public PartyPiece getParty() {
        return party;
    }

    public void setParty(PartyPiece party) {
        this.party = party;
    }

    public Location getStartLoc() {
        return startLoc;
    }

    public TurnState getTurnState() {
        return turnState;
    }

    public ActionState getActionState() {
        return actionState;
    }

    public void setActionState(ActionState actionState) {
        this.actionState = actionState;
    }

    public void setTurnState(TurnState turnState) {
        this.turnState = turnState;
    }

    public Party getHeroes() {
        return Heroes;
    }

    public void setHeroes(Party heroes) {
        Heroes = heroes;
    }

    public Party getMonsters() {
        return Monsters;
    }

    public void setMonsters(Party monsters) {
        Monsters = monsters;
    }

    public int getHeroTurnIndex() {
        return heroTurnIndex;
    }

    public void setHeroTurnIndex(int heroTurnIndex) {
        this.heroTurnIndex = heroTurnIndex;
    }

    public int getMonsterTurnIndex() {
        return monsterTurnIndex;
    }

    public void setMonsterTurnIndex(int monsterTurnIndex) {
        this.monsterTurnIndex = monsterTurnIndex;
    }

    @Override
    public void setupGame() {
        GameSetup.loadData();
        GameSetup.viewHeroMenu();
        this.party.setParty(GameSetup.inputHeroes());
        GameSetup.displayHeroes(getParty());
    }

    @Override
    public void startGame() {
        this.setNextTurn(new HeroesTurn());
    }

    public void setNextTurn(TurnState state){
        this.setTurnState(state);
        this.turnState.handleNextTurn(this);
    }

    public void setNextAction(ActionState state){
        this.setActionState(state);
        this.actionState.handleAction(this);
    }

    public int getMaxHeroLevel(){
        int maxLevel = 0;
        for(Character character: this.party.getParty().getLegion()){
            if(character.getIntLevel() > maxLevel){
                maxLevel = character.getIntLevel();
            }
        }
        return maxLevel;
    }

//    public boolean battleProbability(){
//        return Utility.checkProbability(battleChance);
//    }

    public Location getLocation(String move) {
        Location currLoc = party.getLoc();
        Location newLoc = getLocationFromMove(move, currLoc);
        while(!isValidLocation(newLoc)){
            System.out.println("Location out of bounds!! Enter again:");
            move = Utility.validateCharInput(GameMovesData.movesList);
            newLoc = getLocationFromMove(move, currLoc);
        }
        return newLoc;
    }
}
