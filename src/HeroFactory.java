import java.util.*;

/**
 * generate hero based on name
 */
public class HeroFactory {

    private static List<List<String>> data;
    private static Map<String, Hero> map;

    private static List<String> heroNames;


    static {
        map = new HashMap<>();
        data = FileParser.parseFile("resource/Paladins.txt");
        for (int i = 0; i < data.size(); i++) {
            List<String> params = data.get(i);
            map.put(params.get(0), new Hero(params.get(0), Integer.parseInt(params.get(1)), Integer.parseInt(params.get(2)), Integer.parseInt(params.get(3)), Integer.parseInt(params.get(4)), Integer.parseInt(params.get(5)), Integer.parseInt(params.get(6)), new PaladinStrategy()));
        }
        data = FileParser.parseFile("resource/Warriors.txt");
        for (int i = 0; i < data.size(); i++) {
            List<String> params = data.get(i);
            map.put(params.get(0), new Hero(params.get(0), Integer.parseInt(params.get(1)), Integer.parseInt(params.get(2)), Integer.parseInt(params.get(3)), Integer.parseInt(params.get(4)), Integer.parseInt(params.get(5)), Integer.parseInt(params.get(6)), new PaladinStrategy()));
        }
        data = FileParser.parseFile("resource/Sorcerers.txt");
        for (int i = 0; i < data.size(); i++) {
            List<String> params = data.get(i);
            map.put(params.get(0), new Hero(params.get(0), Integer.parseInt(params.get(1)), Integer.parseInt(params.get(2)), Integer.parseInt(params.get(3)), Integer.parseInt(params.get(4)), Integer.parseInt(params.get(5)), Integer.parseInt(params.get(6)), new PaladinStrategy()));
        }
        heroNames = new ArrayList<>(map.keySet());
    }

    /**
     * get a hero with name
     *
     * @return hero
     */
//    public Hero getHero(String name) throws CloneNotSupportedException {
//        Hero hero = map.get(name);
//        Hero result = hero.clone();
//        return result;
//    }

    /**
     * get a hero with index
     *
     * @return hero
     */
    public Hero getHero(int index) throws CloneNotSupportedException {
        Hero hero;
        try{
         hero = map.get(heroNames.get(index - 1));}
        catch (Exception e){
            System.out.println("No such hero");
            return null;
        }
        return hero;
    }

    public int getNumOfHero() {
        return heroNames.size();
    }

    /**
     * get the string of all heros with index
     *
     * @return String of hero list
     */
    public String getHeroList() {
        String result = "";
        for (int i = 0; i < heroNames.size(); i++) {
            result += (i + 1) + ". " + map.get(heroNames.get(i)) + "\n";
        }
        return result;
    }


}
