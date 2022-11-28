import java.util.*;

/**
 * controls players movement
 */
public class Controller {
    public Controller() {
    }

    /**
     * move down
     */
    public void moveDown(Character character, Board board){
        move(character, "s", board);
    }


    /**
     * move side
     */
    public void moveSide(Character character, Board board){
        if(!move(character,"a",board)){
            move(character,"d",board);
        }
    }

    /**
     * respawn monster with the highest level caller check the highest level hero on board
     */
    public List<Monster> respawnMonster(int level) throws CloneNotSupportedException {
//    public void respawnMonster(int level) throws CloneNotSupportedException {
        MonsterFactory monsterFactory = new MonsterFactory();
        ArrayList<Monster> list = new ArrayList<>();
        for(int i=0;i<3;i++){
            list.add(monsterFactory.getMonster(level));
        }
        CharacterLocation.respawnMonsters(list);
        return list;
    }

    /**
     * called after hero die
     * @param hero
     * @param board
     */
    public void respawnHero(Hero hero, Board board){
        recall(hero, board);
//        backToBase(hero, board);
//        hero.resetBattleStats();// set hero stats to the original value
    }

    /**
     * initailize all heros
     * @param list
     */
    public void respawnAllHero(List<Character> list){
        CharacterLocation.addCharacter(list.get(0),new Position(7,0));
        CharacterLocation.addCharacter(list.get(1),new Position(7,3));
        CharacterLocation.addCharacter(list.get(2),new Position(7,6));
    }




    /**
     *  activate and deactivate after entering a tile
     */
    /**
     * return true if move is success and false  if move is failed
     * @param character
     * @param command
     * @return
     */
    public boolean move(Character character, String command, Board board) {
        Position location = CharacterLocation.getLocation(character);


        boolean b=false;
        Tile tile = board.getTile(location.getX(), location.getY());
        if(character instanceof Hero){
            ((CommonTile) tile).deactivate((Hero) character);
        }
        if (command.equalsIgnoreCase("w")) {
            Position futurePosition = new Position(location.getX() - 1, location.getY());
            //check valid move
            b = ValidateMove.checkPassingMonster(location);
            b = b && ValidateMove.checkInaccessible(futurePosition);
            b = b && ValidateMove.checkDuplicateHero(futurePosition);
            b = b && ValidateMove.checkMapRange(futurePosition);


            if(b) {
                CharacterLocation.moveUp(character);
            }

        } else if (command.equalsIgnoreCase("s")) {
            Position futurePosition = new Position(location.getX() + 1, location.getY());

            //check valid move
            b = ValidateMove.checkInaccessible(futurePosition);
            b = b && ValidateMove.checkDuplicateHero(futurePosition);
            b = b && ValidateMove.checkMapRange(futurePosition);

            if(b) {
                CharacterLocation.moveDown(character);
            }


        } else if (command.equalsIgnoreCase("a")) {
            Position futurePosition = new Position(location.getX(), location.getY()-1);

            //check valid move
            b = ValidateMove.checkInaccessible(futurePosition);
            b = b && ValidateMove.checkDuplicateHero(futurePosition);
            b = b && ValidateMove.checkMapRange(futurePosition);

            if(b) {
                CharacterLocation.moveLeft(character);
            }

            return b;

// check valid move


        } else if (command.equalsIgnoreCase("d")) {
            //check valid move
            Position futurePosition = new Position(location.getX(), location.getY()+1);

            //check valid move
            b = ValidateMove.checkInaccessible(futurePosition);
            b = b && ValidateMove.checkDuplicateHero(futurePosition);
            b = b && ValidateMove.checkMapRange(futurePosition);

            if(b) {
                CharacterLocation.moveRight(character);
            }




        }
        tile = board.getTile(location.getX(), location.getY());
//        ((CommonTile) tile).activate((Hero) character);
//        System.out.println("new location is : "+location);
//        System.out.println("current hero attributes: "+ (Hero)character);
        if(character instanceof Hero){
            ((CommonTile) tile).activate((Hero) character);
        }
        return b;

    }


    /**
     * give a character and teleport to other two lanes
     *
     * 1. ask option here, pros can check if option is valid cons cannot intergrate the input
     * 2. give the command of lanes and position as arguments pros intergrate input cons should do checking in the caller
     * lane in int 1 2 3
     * direction take b for back and s for side
     * @param character
     */
    public boolean teleport(Character character, int lane, String direction, Board board){
        Set<Position> characterInDiffernetlane = getCharacterInDiffernetlane(character);
        Position p = null;
        for(Position i: characterInDiffernetlane){
            if(getLane(i)==lane-1){
                if(direction.equalsIgnoreCase(GameStaticData.NEXT)){
                    p = getValidSide(i);
                }
                else if(direction.equalsIgnoreCase(GameStaticData.BACK)){
                    p = new Position(i.getX() + 1, i.getY());
                }
                else {
                    System.out.println("Invalid input for direction.");
                }
                break;
            }
        }
        try {
            if(p!=null && ValidateMove.checkMapRange(p)&&ValidateMove.checkInaccessible(p)&&ValidateMove.checkDuplicateHero(p)) {
                CharacterLocation.changeLocation(character, p,board);
                return true;
            }else {
                Utility.printStrLn("Wrong Teleport action!! Choose again:");
                Utility.newLine();
                return false;
            }
        }catch (Exception e){
            return false;
        }

    }

    /**
     * get a valid position on the side
     * @param position
     * @return
     */
    private Position getValidSide(Position position){
        Position position1 = new Position(position.getX(), position.getY() + 1);
        if(ValidateMove.checkMapRange(position1) && ValidateMove.checkInaccessible(position1)){
            return position1;
        }
        else {
            return new Position(position.getX(), position.getY() - 1);
        }
    }

    private Set<Position> getCharacterInDiffernetlane(Character c){
        Set<Position> characters = new HashSet<>();
        Position location = CharacterLocation.getLocation(c);
        int lane=getLane(location);
        Set<Position> positions = CharacterLocation.getheroLocation();
        for(Position i:positions){
            if(getLane(i)!=lane){
                characters.add(i);
            }
        }
        return characters;
    }

    private int getLane(Position position){
        return position.getY()/3;
    }

    /**
     * take character as input
     * change the location of this character to his nexus
     * @param character
     */
    public void recall(Character character, Board board){
        Position nexus = CharacterLocation.getNexus(character);
        CharacterLocation.changeLocation(character,nexus, board);
    }
}
