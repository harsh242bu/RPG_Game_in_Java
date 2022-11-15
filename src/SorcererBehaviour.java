// Level up behaviour of the sorcerer. Injected in the hero using strategy pattern
public class SorcererBehaviour implements LevelUpBehaviour{
    @Override
    public void levelUp(Hero hero) {
        hero.setDexterity((int)Math.round(hero.getDexterity()*1.05));
        hero.setAgility((int)Math.round(hero.getAgility()*1.05));
    }
}
