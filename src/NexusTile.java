public class NexusTile extends CommonTile {

    private RespawnStrategy respawnStrategy;

    public NexusTile(RespawnStrategy respawnStrategy) {
        this.respawnStrategy = respawnStrategy;
    }

    @Override
    public String print() {
        return Utils.getBlueNexusString("    ");
    }

    @Override
    public String print(String characterIdentifier) {
        return Utils.getBlueNexusString(characterIdentifier);
    }

    /**
     * different respawn strategy for hero and for monster
     */
    public void respawn() {
        respawnStrategy.respawn();
    }
}
