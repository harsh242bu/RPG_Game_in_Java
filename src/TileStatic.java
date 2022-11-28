// Contains the utils for printing the tile with different colors
public class TileStatic {

    /**
     * Color
     * 31 red text
     * 32 green text
     * 33 yellow text
     * 34 blue text
     * 35 purple text
     * 36 cyan blue text
     * 37 gray text
     * 40 black background
     * 41 red background
     * 42 green background
     * 43 yellow backgorund
     * 44 blue background
     * 45 purple background
     * 46 cyan blue background
     * 47 gray background
     * <p>
     * FontType
     * 0 clear everything
     * 1 bold
     * 2 light
     * 3 italic
     * 4 underline
     * 5 slow flash
     * 6 quick flash
     *
     * @param color
     * @param fontType
     * @param content
     * @return
     */
    public static String getColorString(int color, int fontType, String content) {
        return String.format("\33[%d;%dm%s\033[0m", color, fontType, content);
    }

    public static String getRedKoulouString(String content) {
        return getColorString(41, 1, content);
    }

    public static String getGreenBushString(String content) {
        return getColorString(42, 1, content);
    }

    public static String getBlueNexusString(String content) {
        return getColorString(46, 1, content);
    }

    public static String getBlackInaccessibleString(String content) {
        return getColorString(40, 1, content);
    }

    public static String getGrayCaveString(String content) {
        return getColorString(47, 1, content);
    }

    public static void main(String[] args) {
        System.out.println(getGrayCaveString("this is a cave"));
        System.out.println(getGreenBushString("this is a bush"));
        System.out.println(getRedKoulouString("this is  a koulou"));
    }
}
