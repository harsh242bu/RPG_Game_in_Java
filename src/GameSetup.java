// Class is used to setup the game
import java.util.List;

public class GameSetup {
    final static int maxHeroes = 3;

    public static void loadData(){
        new WeaponsData();
        new ArmorsData();
        new PotionsData();
        new FireSpellsData();
        new IceSpellsData();
        new LightningSpellsData();
    }

    public static void viewHeroMenu(){
        HeroFactory.initializeHeroes();

        int counter = 0;
        Utility.newLine();
        System.out.println("Select your party from the list of Heroes below. (Max: "
                        + maxHeroes + " Heroes allowed)");
        counter = WarriorData.viewWarriors(counter + 1);
        Utility.newLine();
        counter = SorcerersData.viewSorcerers(counter);
        Utility.newLine();
        counter = PaladinsData.viewPaladins(counter);
        Utility.newLine();
    }
    public static Party inputHeroes(){
        System.out.println("Enter Hero numbers(max " + maxHeroes +"" +
                ") separated by space. For ex: 1 5 7");

        int totalHeroes = WarriorData.size() + SorcerersData.size() + PaladinsData.size();
        List<Integer> intList = Utility.intInputValidated(1, totalHeroes, maxHeroes);

        Party newParty = new Party();
        int count = 1;

        int warriorSize = WarriorData.size();
        int sorcererSize = SorcerersData.size();

        for(int option: intList){
            int index = option - 1;
            if(index < warriorSize){
                Hero h = WarriorData.getHero(index);
                h.setTag("H"+count++);
                newParty.addCharacter(h);
            }
            else if(index < warriorSize + sorcererSize){
                Hero h = SorcerersData.getHero(index - warriorSize);
                h.setTag("H"+count++);
                newParty.addCharacter(h);
            }
            else {
                Hero h = PaladinsData.getHero(index - warriorSize - sorcererSize);
                h.setTag("H"+count++);
                newParty.addCharacter(h);
            }
        }
        return newParty;
//        for(int option: intList){
//            int index = option - 1;
//
//            if(index < warriorSize){
//                WarriorData.removeHero(index);
//            }
//            else if(index < warriorSize + sorcererSize){
//                SorcerersData.removeHero(index - warriorSize);
//            }
//            else {
//                PaladinsData.removeHero(index - warriorSize - sorcererSize);
//            }
//        }
//        board.addParty(newParty);

    }

    public static void displayHeroes(Party party) {

        System.out.println("You have chosen the following heroes:" );

        HeroData.getHeader();
        for(Character hero: party.getLegion()){
            hero.printCharacter();
        }
    }

//    public static void displayHeroes(PartyPiece partyPiece) {
//        System.out.print("Your party is spawned at location: " );
//        partyPiece.printLoc();
//        Utility.newLine();
//        Utility.newLine();
//        System.out.println("You have chosen the following heroes:" );
//
//        HeroData.getHeader();
//        for(Character hero: partyPiece.getParty().getLegion()){
//            hero.printCharacter();
//        }
//    }

}
