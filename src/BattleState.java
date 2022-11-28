// Implemented for battle state machine
public interface BattleState{
    
    public void handleAttack(Battle battle);

    public void printOpponent(Battle battle);
}
