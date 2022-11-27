public class CaveTile extends CommonTile {
    private double increasedValue=0;
    @Override
    public String print(String characterIdentifier) {
        return TileStatic.getGrayCaveString(characterIdentifier);
    }

    @Override
    public String print() {

        return TileStatic.getGrayCaveString("    ");
    }

    @Override
    public void activate(Hero hero) {
//        System.out.println("activate cave called");
       hero.setAgility((int) (hero.getAgility()+ (increasedValue=hero.getAgility()*0.1)));
    }

    @Override
    public void deactivate(Hero hero) {
//        System.out.println("deactivate cave called");
        hero.setAgility((int) (hero.getAgility()-increasedValue));
    }
}
