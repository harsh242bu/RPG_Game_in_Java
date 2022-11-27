// Paladins data
public class PaladinsData extends HeroData implements Cloneable{
    static public Party paladins;

    PaladinsData(){
        paladins = new Party();
        // Wild_Vine XLR8 Crystal_Fist Boot_Leg Wrecking_Bolt

        paladins.addCharacter(new Hero("Wild_Vine", 300, 750, 650, 700, 2500, 7));
        paladins.addCharacter(new Hero("XLR8", 300, 750, 700, 700, 2500, 7));
        paladins.addCharacter(new Hero("Crystal_Fist", 250, 650, 600, 350, 2500, 4));
        paladins.addCharacter(new Hero("Boot_Leg", 100, 600, 500, 400, 2500, 5));
        paladins.addCharacter(new Hero("Wrecking_Bolt", 500, 500, 500, 500, 2500, 5));
    }

    public static int viewPaladins(int counter) {
        System.out.println("Paladins - Favored on Dexterity and Strength");
        getHeader();

        for(Character warrior: paladins.getLegion()){
            System.out.print("" + counter++ + ". ");
            warrior.printCharacter();
//            Utility.newLine();
        }
        return counter;
    }
    public static int size(){
        return paladins.size();
    }

    public static Hero getHero(int index) {
        Hero hero = null;
        try {
            hero = (Hero) paladins.get(index).clone();
            hero.setLevelBehaviour(new PaladinBehaviour());

        }
        catch (Exception e) {System.out.println(e);}
        return hero;

//        Hero hero = (Hero)paladins.get(index);
//        hero.setLevelBehaviour(new PaladinBehaviour());
//        return hero;
    }

    public static void removeHero(int index) {
        paladins.remove(index);
    }

    public static int getCharacterIndexByName(String name){
        return paladins.getCharacterIndexByName(name);
    }
}
