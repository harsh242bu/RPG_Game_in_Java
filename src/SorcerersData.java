// Sorcerer data
public class SorcerersData extends HeroData implements Cloneable{
    static public Party sorcerers;

    SorcerersData(){
        sorcerers = new Party();
        // Grey_Matter Over_Flow Rath Stink_Fly Upgrade
        // Wild_Vine XLR8 Crystal_Fist Boot_Leg Wrecking_Bolt
        sorcerers.addCharacter(new Hero("Grey_Matter", 1300, 750, 450, 500, 2500, 9));
        sorcerers.addCharacter(new Hero("Over_Flow", 900, 800, 500, 650, 2500, 5));
        sorcerers.addCharacter(new Hero("Rath", 800, 800, 800, 800, 2500, 8));
        sorcerers.addCharacter(new Hero("Stink_Fly", 900, 800, 700, 400, 2500, 7));
        sorcerers.addCharacter(new Hero("Upgrade", 800, 850, 400, 600, 2500, 6));

    }

    public static int viewSorcerers(int counter) {
        System.out.println("Sorcerers - Favored on Agility and Dexterity");
        getHeader();

        for(Character sorcerer: sorcerers.getLegion()){
            System.out.print("" + counter++ + ". ");
            sorcerer.printCharacter();
//            Utility.newLine();
        }
        return counter;
    }
    public static int size(){
        return sorcerers.size();
    }

    public static Hero getHero(int index) {
        Hero hero = null;
        try {
            hero = (Hero) sorcerers.get(index).clone();
            hero.setLevelBehaviour(new SorcererBehaviour());

        }
        catch (Exception e) {System.out.println(e);}
        return hero;

//        Hero hero = (Hero)sorcerers.get(index);
//        hero.setLevelBehaviour(new SorcererBehaviour());
//        return hero;
    }

    public static void removeHero(int index) {
        sorcerers.remove(index);
    }

    public static int getCharacterIndexByName(String name){
        return sorcerers.getCharacterIndexByName(name);
    }
}
