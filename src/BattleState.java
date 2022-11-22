// Implemented for battle state machine
public interface BattleState{
    // Create a new state machine to handle the turns inside the battle
//    public void handleTurn(BattleOld battle);
    public void handleAttack(Battle battle);
}
