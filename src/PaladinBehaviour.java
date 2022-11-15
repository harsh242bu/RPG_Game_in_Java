// Represents level behaviour of paladins
public class PaladinBehaviour implements LevelUpBehaviour{
    @Override
    public void levelUp(Hero hero) {
        hero.setStrength((int)Math.round(hero.getStrength()*1.05));
        hero.setDexterity((int)Math.round(hero.getDexterity()*1.05));
    }
}
