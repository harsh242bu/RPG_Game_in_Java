// A type of CommonTile - increases hero's dexterity
public class BushTile extends CommonTile {
    private double increasedValue=0;
    @Override
    public void activate(Hero hero) {
//        System.out.println("activate bush called");

        hero.setDexterity((int) (hero.getDexterity()+(increasedValue=hero.getDexterity()*0.1)));
    }


    @Override
    public void deactivate(Hero hero) {
//        System.out.println("deactivate bush called");

        hero.setDexterity((int) (hero.getDexterity()-increasedValue));
    }


    @Override
    public String print() {
        return TileStatic.getGreenBushString("    ");
    }

    @Override
    public String print(String characterIdentifier) {
        return TileStatic.getGreenBushString(characterIdentifier);
    }

    public static void main(String[] args) {
        CommonTile commonTile = new BushTile();
        System.out.println(commonTile.print("M1111"));

    }
}
