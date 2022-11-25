import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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

    /**
     * return the surround hero for monster
     */

    /**
     * return the surround monster for hero
     */
    77




    /**
     * c is the character and position is the destination position
     * @param c
     * @param position
     */
    public static void changeLocation(Character c, Position position){
        Position location = getLocation(c);
        locationHero.remove(location);
        location.setX(position.getX());
        location.setY(position.getY());
        locationHero.put(location, (Hero) c);
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

    public static void removeMonsterLocation(Position position) {
        locationMonster.remove(position);
    }


    public static void removeHeroLocation(Position position) {
        locationHero.remove(position);
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

    public static Position getLocation(Character character) {
        return characterLocation.get(character);
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Position position = new Position(1, 3);
        HeroFactory heroFactory = new HeroFactory();
        Hero hero = heroFactory.getHero(1);
        CharacterLocation.addCharacter(hero, position);
        System.out.println(CharacterLocation.getLocation(hero));
        System.out.println(CharacterLocation.getHero(new Position(1, 3)));


        CharacterLocation.moveDown(hero);


        System.out.println(CharacterLocation.getLocation(hero));
        System.out.println(CharacterLocation.getHero(new Position(1, 4)));


    }


}
