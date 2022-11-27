import java.util.*;

public class CharacterLocation {
    /**
     * the position of the nexus for characters
     */
    private static Map<Character, Position> characterNexus = new HashMap<>();

    /**
     * use to find the position for the character
     */
    private static Map<Character, Position> characterLocation = new HashMap<>();

    private static Map<Position, Hero> locationHero = new HashMap<>();
    private static Map<Position, Monster> locationMonster = new HashMap<>();

    /**
     * respawn monster give three mosnters and give them a location
     */
    public static void respawnMonsters(List<Monster> list){
        Monster monster = list.get(0);
        addCharacter(monster,new Position(0,1));
        monster = list.get(1);
        addCharacter(monster,new Position(0,4));
        monster = list.get(2);
        addCharacter(monster,new Position(0,7));
    }

    /**
     * return if the input character reached the opposite nexus
     * @param character
     * @return
     */
    public static boolean anyCharacterReachedNexus(Character character){
        if(characterNexus.containsKey(character)){
            if(getLocation(character).getX()==0){
                return true;
            }
        }else {
            if(getLocation(character).getX()==7){
                return true;
            }
        }
        return false;
    }




    /**
     * return the set of location of hero
     * @return
     */
    public static Set<Position> getheroLocation(){
        return locationHero.keySet();
    }

    /**
     * return set of location of monster
     * @return
     */
    public static Set<Position> getmonsterLocation(){
        return locationMonster.keySet();
    }

    /**
     * record the nexus postion inforamtion for the hero
     * @param c
     * @param position
     */
    private static void setBase(Character c, Position position){
        characterNexus.put(c,position);
    }

    public static void addCharacter(Character character, Position position) {
        characterLocation.put(character, position);

        if (character instanceof Monster) {

            addMonsterLocation(position, (Monster) character);
        } else if (character instanceof Hero) {

            addHeroLocation(position, (Hero) character);
            setBase(character,new Position(position));
        }

    }

    public static Position getNexus(Character character){
        return characterNexus.get(character);
    }

    public static boolean inBase(Character character){
        Position location = getLocation(character);
        for(Character i: characterNexus.keySet()){
            if(location.equals(characterNexus.get(i))){
                return true;
            }
        }
        return false;
    }

    /**
     * return the surround hero for monster
     * if there is no hero return null
     */
    public static Hero getSurroundingHero(Monster monster){
        Position location = getLocation(monster);
        Set<Position> surroundingLocation = getSurroundingLocation(location);
        for(Position i: surroundingLocation){
            if(locationHero.containsKey(i)){
                return locationHero.get(i);
            }
        }
        return null;
    }

    /**
     * return the surround monster for hero
     * if there is no monster in attack range return null.
     */
    public static Monster getSurroundingMonster(Hero hero){
        Position location = getLocation(hero);
        Set<Position> surroundingLocation = getSurroundingLocation(location);
        for(Position i: surroundingLocation){
            if(locationMonster.containsKey(i)){
                return locationMonster.get(i);
            }
        }
        return null;
    }

    private static Set<Position> getSurroundingLocation(Position position){
        HashSet<Position> positions = new HashSet<>();
        positions.add(new Position(position.getX()-1,position.getY()-1));
        positions.add(new Position(position.getX()-1,position.getY()));
        positions.add(new Position(position.getX()-1,position.getY()+1));
        positions.add(new Position(position.getX(),position.getY()-1));
        positions.add(new Position(position.getX(),position.getY()));
        positions.add(new Position(position.getX(),position.getY()+1));
        positions.add(new Position(position.getX()+1,position.getY()-1));
        positions.add(new Position(position.getX()+1,position.getY()));
        positions.add(new Position(position.getX()+1,position.getY()+1));
        return positions;
    }






    /**
     * c is the character and position is the destination position
     * @param c
     * @param position
     */
    public static void changeLocation(Character c, Position position, Board board){
        Position location = getLocation(c);
        Tile tile = board.getTile(location.getX(), location.getY());
        ((CommonTile) tile).deactivate((Hero) c);
        locationHero.remove(location);
        location.setX(position.getX());
        location.setY(position.getY());
        locationHero.put(location, (Hero) c);
        tile = board.getTile(location.getX(), location.getY());
        ((CommonTile) tile).activate((Hero) c);
    }

    /**
     * return the hero in this position, if not a hero return null
     *
     * @param position
     * @return
     */
    public static Hero getHero(Position position) {
        return locationHero.get(position);
    }


    /**
     * return a monster in this position, return null if there is no monster
     *
     * @param position
     * @return
     */
    public static Monster getMonster(Position position) {
        return locationMonster.get(position);
    }



    public static void addMonsterLocation(Position position, Monster monster) {
        locationMonster.put(position, monster);
    }

    public static void addHeroLocation(Position position, Hero hero) {
        locationHero.put(position, hero);
    }

    public static void removeMonster(Monster monster){
        Position location = getLocation(monster);
//        System.out.println("this is old");
//        System.out.println(characterLocation);
//        System.out.println(locationMonster);
        characterLocation.remove(monster);
        locationMonster.remove(location);
//        System.out.println("this is new");
//        System.out.println(characterLocation);
//        System.out.println(locationMonster);
    }

    public static void moveUp(Character character) {
        Position position = characterLocation.get(character);


        if (character instanceof Monster) {
            locationMonster.remove(position);
            position.setX(position.getX() - 1);


            locationMonster.put(position, (Monster) character);
        } else if (character instanceof Hero) {
            locationHero.remove(position);
            position.setX(position.getX() - 1);


            locationHero.put(position, (Hero) character);

        }

    }

    public static void moveDown(Character character) {

        Position position = characterLocation.get(character);
        if (character instanceof Monster) {
            locationMonster.remove(position);
            position.setX(position.getX() + 1);

            locationMonster.put(position, (Monster) character);
        } else if (character instanceof Hero) {
            locationHero.remove(position);
            position.setX(position.getX() + 1);

            locationHero.put(position, (Hero) character);

        }

    }

    public static void moveLeft(Character character) {


        Position position = characterLocation.get(character);
        if (character instanceof Monster) {
            locationMonster.remove(position);
            position.setY(position.getY() - 1);


            locationMonster.put(position, (Monster) character);
        } else if (character instanceof Hero) {
            locationHero.remove(position);
            position.setY(position.getY() - 1);


            locationHero.put(position, (Hero) character);

        }
    }

    public static void moveRight(Character character) {
        Position position = characterLocation.get(character);

        if (character instanceof Monster) {
            locationMonster.remove(position);
            position.setY(position.getY() + 1);


            locationMonster.put(position, (Monster) character);
        } else if (character instanceof Hero) {
            locationHero.remove(position);
            position.setY(position.getY() + 1);


            locationHero.put(position, (Hero) character);

        }
    }

    /**
     * get a location for a character
     * @param character
     * @return
     */
    public static Position getLocation(Character character) {
        return characterLocation.get(character);
    }


    public static void main(String[] args) {
        Set<Position> surroundingLocation = getSurroundingLocation(new Position(2, 3));
        System.out.println(surroundingLocation);

    }




}
