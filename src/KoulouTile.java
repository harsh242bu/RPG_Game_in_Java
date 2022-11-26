public class KoulouTile extends CommonTile {
    private double increasedValue=0;
    @Override
    public String print() {
        return TileStatic.getRedKoulouString("    ");
    }

    @Override
    public String print(String characterIdentifier) {
        return TileStatic.getRedKoulouString(characterIdentifier);
    }

    @Override
    public void activate(Hero hero) {
        System.out.println("activate koulou called");

        hero.setStrength((int) (hero.getStrength()+(increasedValue=hero.getStrength()*0.1)));
    }

    @Override
    public void deactivate(Hero hero) {
        System.out.println("deactivate koulou called");

        hero.setStrength((int) (hero.getStrength()-increasedValue));
    }
}
