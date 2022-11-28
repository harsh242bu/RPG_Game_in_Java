// The main game class. Contains the board, heroes, monsters and everything required to play the game
import java.util.List;

public class ValorRPG implements Game {
    //    private PartyPiece party;
    private Party heroes;
    private Party monsters;
    private Board gameBoard;
    private Controller gameController;
    //    private final Location startLoc = new Location(0,0);
    private final int TOTAL_PLAYERS = 3;
    private final int monsterRandomMoveChance = 18;
    private TurnState turnState;
    private HeroActionState heroActionState;
    private MonsterActionState monsterActionState;
    private MonsterFactory monsterFactory;
    private int heroTurnIndex = 0;
    private int monsterTurnIndex = 0;
    private Rounds gameRounds;

    ValorRPG() {
//        super(rows, cols);
        GameSetup.loadData();
        this.gameBoard = new Board();
        this.gameController = new Controller();

        this.heroes = new Party();
        this.monsters = new Party();

        this.turnState = new HeroesTurn();
        this.heroActionState = new ChooseHeroAction();
        this.monsterFactory = MonsterFactory.getMonsterFactoryInstance();
        this.monsterActionState = new MoveMonsterAction();
        this.gameRounds = Rounds.getRoundsInstance();
    }
//    ValorRPG(int size){
//        this(size, size);
//    }

    public MonsterFactory getMonsterFactory() {
        return monsterFactory;
    }

    public void setMonsterFactory(MonsterFactory monsterFactory) {
        this.monsterFactory = monsterFactory;
    }

    public Board getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(Board gameBoard) {
        this.gameBoard = gameBoard;
    }

    public Controller getGameController() {
        return gameController;
    }

    public void setGameController(Controller gameController) {
        this.gameController = gameController;
    }

    public TurnState getTurnState() {
        return turnState;
    }

    public HeroActionState getHeroActionState() {
        return heroActionState;
    }

    public void setHeroActionState(HeroActionState heroActionState) {
        this.heroActionState = heroActionState;
    }

    public MonsterActionState getMonsterActionState() {
        return monsterActionState;
    }

    public void setMonsterActionState(MonsterActionState monsterActionState) {
        this.monsterActionState = monsterActionState;
    }

    public int getMonsterRandomMoveChance() {
        return monsterRandomMoveChance;
    }

    public void setTurnState(TurnState turnState) {
        this.turnState = turnState;
    }

    public Party getHeroes() {
        return heroes;
    }

    public void setHeroes(Party heroes) {
        this.heroes = heroes;
    }

    public Party getMonsters() {
        return monsters;
    }

    public void setMonsters(Party monsters) {
        this.monsters = monsters;
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

    public Rounds getGameRounds() {
        return gameRounds;
    }

    public void setGameRounds(Rounds gameRounds) {
        this.gameRounds = gameRounds;
    }

    @Override
    public void setupGame() {
        GameInstruction.printGameInstruction();
        GameSetup.viewHeroMenu();
        this.setHeroes(GameSetup.inputHeroes());
        GameSetup.displayHeroes(getHeroes());
        this.gameController.respawnAllHero(getHeroes().getLegion());
        // set the monsters

        try {
            List<Monster> monsters = this.gameController.respawnMonster(this.getMaxHeroLevel());

            for (Monster monster : monsters) {
                getMonsters().addCharacter(monster);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void startGame() {
        this.setNextTurn(new HeroesTurn());
    }

    public void generateNewMonster() {
        try {
            List<Monster> newMonsters = this.gameController.respawnMonster(this.getMaxHeroLevel());
            Utility.printStrLn("Caution!! New monsters spawned in the Game.");
            MonsterData.getMonsterHeader();
            for (Monster monster : newMonsters) {
                monster.printCharacter();
                getMonsters().addCharacter(monster);
            }
            Utility.newLine();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void setNextTurn(TurnState state) {
        this.setTurnState(state);
        this.turnState.handleNextTurn(this);
    }

    public void setHeroNextAction(HeroActionState state) {
        this.setHeroActionState(state);
        this.heroActionState.handleAction(this);
    }

    public void setMonsterNextAction(MonsterActionState state) {
        this.setMonsterActionState(state);
        this.monsterActionState.handleAction(this);
    }

    public boolean isHeroAlive() {
        return this.getHero().isAlive();
    }

    public boolean isMonsterAlive() {
        return this.getMonster().isAlive();
    }

    public boolean anyHeroReachedNexus() {
//        boolean alive = false;
//        for(Character ch: getHeroes().getLegion()){
//            if(ch.isAlive()){
//                alive = true;
//                break;
//            }
//        }
        return false;
    }

    public boolean anyMonsterReachedNexus() {
//        boolean alive = false;
//        for(Character ch: getMonsters().getLegion()){
//            if(ch.isAlive()){
//                alive = true;
//                break;
//            }
//        }
        return false;
    }

    public void removeHero() {
        this.getHeroes().remove(getHeroTurnIndex());
    }

    public void removeMonster() {
        this.getMonsters().remove(getMonsterTurnIndex());
    }

    public Hero getHero() {
        return (Hero) this.getHeroes().get(getHeroTurnIndex());
    }

    public Monster getMonster() {
        return (Monster) this.getMonsters().get(getMonsterTurnIndex());
    }

    public int getMaxHeroLevel() {
        int maxLevel = 0;
        for (Character character : this.getHeroes().getLegion()) {
            if (character.getIntLevel() > maxLevel) {
                maxLevel = character.getIntLevel();
            }
        }
        return maxLevel;
    }

//    public boolean battleProbability(){
//        return Utility.checkProbability(battleChance);
//    }

//    public Location getLocation(String move) {
//        Location currLoc = party.getLoc();
//        Location newLoc = getLocationFromMove(move, currLoc);
//        while(!isValidLocation(newLoc)){
//            System.out.println("Location out of bounds!! Enter again:");
//            move = Utility.validateCharInput(GameMovesData.movesList);
//            newLoc = getLocationFromMove(move, currLoc);
//        }
//        return newLoc;
//    }
}
