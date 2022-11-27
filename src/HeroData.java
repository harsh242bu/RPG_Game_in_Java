// Hero data
public abstract class HeroData {
    public static void getHeader() {
        String output = String.format("%-17s%-10s%-10s%-10s%-10s%-10s%-10s%-10s", "Name", "HP", "Mana", "Strength", "Agility", "Dexterity", "Money", "Level");
        System.out.println(output);
    }

    ;

    public static void getHeaderWithSrNo() {
        String output = String.format("No. %-17s%-10s%-10s%-10s%-10s%-10s%-10s%-10s", "Name", "HP", "Mana", "Strength", "Agility", "Dexterity", "Money", "Level");
        System.out.println(output);

    }

    ;
}
