import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * controls players movement
 */
public class Controller {
    4654654
    /**
     *  activate and deactivate after entering a tile
     */
    /**
     * return true if move is success and false  if move is failed
     * @param character
     * @param command
     * @return
     */
    public boolean move(Character character, String command) {
        Position location = CharacterLocation.getLocation(character);
        if (command.equalsIgnoreCase("w")) {
            Position futurePosition = new Position(location.getX() - 1, location.getY());
            //check valid move
            boolean b = ValidateMove.checkPassingMonster(location);
            b = b && ValidateMove.checkInaccessible(futurePosition);
            b = b && ValidateMove.checkDuplicateHero(futurePosition);
            b = b && ValidateMove.checkMapRange(futurePosition);


            if(b) {
                CharacterLocation.moveUp(character);
                return b;
            }
            else {
                return b;
            }
        } else if (command.equalsIgnoreCase("s")) {
            Position futurePosition = new Position(location.getX() + 1, location.getY());

            //check valid move
            boolean b = ValidateMove.checkInaccessible(futurePosition);
            b = b && ValidateMove.checkDuplicateHero(futurePosition);
            b = b && ValidateMove.checkMapRange(futurePosition);

            if(b) {
                CharacterLocation.moveDown(character);
                return b;
            }
            else {
                return b;
            }

        } else if (command.equalsIgnoreCase("a")) {
            Position futurePosition = new Position(location.getX(), location.getY()-1);

            //check valid move
            boolean b = ValidateMove.checkInaccessible(futurePosition);
            b = b && ValidateMove.checkDuplicateHero(futurePosition);
            b = b && ValidateMove.checkMapRange(futurePosition);

            if(b) {
                CharacterLocation.moveLeft(character);
                return b;
            }
            else {
                return b;
            }

// check valid move


        } else if (command.equalsIgnoreCase("d")) {
            //check valid move
            Position futurePosition = new Position(location.getX(), location.getY()+1);

            //check valid move
            boolean b = ValidateMove.checkInaccessible(futurePosition);
            b = b && ValidateMove.checkDuplicateHero(futurePosition);
            b = b && ValidateMove.checkMapRange(futurePosition);

            if(b) {
                CharacterLocation.moveRight(character);
                return b;
            }
            else {
                return b;
            }



        }
        else {
            return false;
        }
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
    public boolean teleport(Character character, int lane, String direction){
        Set<Position> characterInDiffernetlane = getCharacterInDiffernetlane(character);
        Position p = null;
        for(Position i: characterInDiffernetlane){
            if(getLane(i)==lane-1){
                if(direction.equalsIgnoreCase("s")){
                    p = getValidSide(i);
                }
                else if(direction.equalsIgnoreCase("b")){
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
                CharacterLocation.changeLocation(character, p);
                return true;
            }else return false;
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
    public void backToBase(Character character){
        Position nexus = CharacterLocation.getNexus(character);
        CharacterLocation.changeLocation(character,nexus);
    }
}
