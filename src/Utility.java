// Utility class. Contains various utility method used in the game
import java.util.*;

public class Utility {
    public static void printLine(int size){
        for(int j = 0; j < size; j++){
            System.out.print("+-----");
        }
        System.out.print("+\n");
    }
    public static void newLine(){
        System.out.println();
    }

    public static String getString(int i) {
        String str = "" + i;
        return str;
    }

    public static int intInput(int start, int end){
        Scanner scn = new Scanner(System.in);
        int input = scn.nextInt();
        while(input < start || input >= end){
            System.out.println("Wrong Input!! Enter again:");
            input = scn.nextInt();
        }
        return input;
    }

    public static String printAttribute(int attr){
        switch(attr){
            case(Modifiable.MANA):
                return "MANA";
            case(Modifiable.STRENGTH):
                return "STRENGTH";
            case(Modifiable.AGILITY):
                return "AGILITY";
            case(Modifiable.DEXTERITY):
                return "DEXTERITY";
            case(Modifiable.GOLD):
                return "GOLD";
            case(Modifiable.XP):
                return "XP";
            case(Modifiable.HP):
                return "HP";
            case(Modifiable.DEFENSE):
                return "DEFENSE";
            case(Modifiable.DAMAGE):
                return "DAMAGE";
        }
        return "NULL";

    }

    public static boolean isListUnique(List<Integer> intList) {
        Set<Integer> set = new HashSet<Integer>();

        for (int num : intList) {
            if (set.add(num) == false) {
                System.out.println("List not unique!! Enter again:");
                return false;
            }
        }
        return true;
    }
    public static boolean listInBound(List<Integer> intList, int start, int end) {
        for (int num : intList) {
            if (num < start || num > end) {
                System.out.println("List numbers are out of bound!! Enter again:");
                return false;
            }
        }
        return true;
    }
    public static boolean isSizeProper(List<Integer> intList, int size) {
        if(intList.size() <= size){
            return true;
        }
        else {
            System.out.println("Exceeded size!! Enter again:");
            return false;
        }
    }
    public static List<Integer> listInput(){
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();

        String[] list = str.split(" ");
        List<Integer> intList = new ArrayList<Integer>();

        for(String tempStr: list){
            intList.add(Integer.parseInt(tempStr));
        }
        return intList;
    }

    public static List<Integer> intInputValidated(int start, int end, int size){
        List<Integer> intList = listInput();
        while(!isListUnique(intList) || !listInBound(intList, start, end) || !isSizeProper(intList, size)){
            intList = listInput();
        }
        return intList;
    }

    public static String validateCharInput(List<String> strList){
        String str;
        str = inputChar();
        while(!strList.contains(str)){
            System.out.println("Wrong input!! Enter again:");
            str = inputChar();
        }
        return str;
    }

    public static String inputChar(){
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        str = str.toLowerCase();
        return str.substring(0,1);
    }

    public static int getRandomNum(int bound){
        return new Random().nextInt(bound);
    }

    public static int intInputFromList(List<Integer> choiceList) {
        Scanner scn = new Scanner(System.in);
        int input = scn.nextInt();
        while(!choiceList.contains(input)){
            System.out.println("Wrong input!! Enter again:");
            input = scn.nextInt();
        }
        return input;
    }

    public static int getIntForDouble(double num){
        return (int)Math.round(num);
    }

    public static boolean checkProbability(int num){
        int randNum = Utility.getRandomNum(100);
        if(randNum <= num){
            return true;
        }
        else return false;
    }
}
