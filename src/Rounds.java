// Tracking number of rounds in the game. Required for respawning new monsters after 7 rounds.
public class Rounds {
    private static Rounds roundInstance;
    private int round = 1;
    private static final int TOTAL_ROUNDS = 7;

    private Rounds(){}

    public static Rounds getRoundsInstance(){
        if(roundInstance == null){
            roundInstance = new Rounds();
        }
        return roundInstance;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public void incrementRound(){
        setRound(getRound()+1);
    }

    public boolean checkRegenrateMonsters(){
//        boolean flag = false;
        if(round%TOTAL_ROUNDS == 0){
            return true;
        }
        return false;
    }
}
