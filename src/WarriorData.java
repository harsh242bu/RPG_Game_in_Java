// Warriors data
public class WarriorData extends HeroData{
    static public Party warriors;

    WarriorData(){
        warriors = new Party();

        warriors.addCharacter(new Hero("Four_Arms", 100, 700, 500, 600, 1354, 7));
        warriors.addCharacter(new Hero("Diamond_Head", 600, 700, 800, 500, 2500, 8));
        warriors.addCharacter(new Hero("Cannon_Bolt", 300, 900, 500, 750, 2546, 6));
        warriors.addCharacter(new Hero("Heat_Blast", 200, 750, 650, 700, 2500, 7));
        warriors.addCharacter(new Hero("Shock_Rock", 400, 800, 400, 700, 2500, 7));
    }
    public static int viewWarriors(int counter){
        System.out.println("Warriors - Favored on Strength and Agility");
        getHeader();

//        Formatter fmt = new Formatter();
//        for (int n : num){
//            fmt.format("%10s %10s %10s %10s %10s %10s %10s %10s\n", n, (n*n), (n*n*n));
//        }

        for(Character warrior: warriors.getLegion()){
            System.out.print("" + counter++ + ". ");
            warrior.printCharacter();
//            Utility.newLine();
        }
        return counter;
    }
    public static int size(){
        return warriors.size();
    }

    public static Hero getHero(int index) {
        Hero hero = (Hero)warriors.get(index);
        hero.setLevelBehaviour(new WarriorBehaviour());
        return hero;
    }
    public static void removeHero(int index) {
        warriors.remove(index);
    }
}
