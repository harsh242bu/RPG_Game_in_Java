// Legends Monster and heroes game
public class LegendsRPG extends GameBoard{
    private PartyPiece party;
    private final Location startLoc = new Location(0,0);
    private final static int battleChance = 40;
    private GameState gameState;
    private MonsterFactory monsterFactory;

    LegendsRPG(int rows, int cols){
        super(rows, cols);
        this.party = new PartyPiece("X", startLoc);

        BalancedCellFactory factory = new BalancedCellFactory();
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                matrix[i][j] = factory.generateCell();
            }
        }
        getCell(startLoc).addParty(party);
        this.gameState = new MoveState();
        this.monsterFactory = new MonsterFactory();
    }
    LegendsRPG(int size){
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

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
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
        this.setState(new MoveState());
    }

    @Override
    public void setState(GameState state) {
        setGameState(state);
//        this.gameState = state;
        this.gameState.handleNextState(this);
    }

//    public void displayHeroes() {
//        System.out.print("Your party is spawned at location: " );
//        party.printLoc();
//        Utility.newLine();
//        Utility.newLine();
//        System.out.println("You have chosen the following heroes:" );
//
//        HeroData.getHeader();
//        for(Character hero: party.getParty().getLegion()){
//            hero.printCharacter();
//        }
//    }

    public int getMaxHeroLevel(){
        int maxLevel = 0;
        for(Character character: this.party.getParty().getLegion()){
            if(character.getIntLevel() > maxLevel){
                maxLevel = character.getIntLevel();
            }
        }
        return maxLevel;
    }

    public boolean battleProbability(){
        return Utility.checkProbability(battleChance);
    }

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
