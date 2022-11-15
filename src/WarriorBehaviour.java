// Level up behaviour of the warrior. Injected in the hero using strategy pattern
public class WarriorBehaviour implements LevelUpBehaviour{
    @Override
    public void levelUp(Hero hero) {
        hero.setStrength((int)Math.round(hero.getStrength()*1.05));
        hero.setAgility((int)Math.round(hero.getAgility()*1.05));
    }
}
