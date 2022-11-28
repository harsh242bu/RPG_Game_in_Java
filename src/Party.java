// Represents a party of characters - (monsters or heroes)
import java.util.ArrayList;
import java.util.List;

public class Party {
    private List<Character> legion;

    public Party() {
        this.legion = new ArrayList<>();
    }

    public List<Character> getLegion() {
        return legion;
    }

    public void setLegion(List<Character> legion) {
        this.legion = legion;
    }
    public Character get(int i){ return legion.get(i); }
    public void remove(int i){ legion.remove(i); }
    public void remove(Character ch){ legion.remove(ch); }

    public void addCharacter(Character ch){
        legion.add(ch);
    }
    public void addAll(List<Character> characters){
        legion.addAll(characters);
    }

    public int size() {
        return legion.size();
    }

    public int getCharacterIndexByName(String name){
        for(Character character: legion){
            if(character.getName().equals(name)){
                return legion.indexOf(character);
            }
        }
        return -1;
    }

    public int getMaxLevel(){
        int max = 0;
        for(Character ch: legion){
            if(max < ch.getIntLevel()){
                max = ch.getIntLevel();
            }
        }
        return max;
    }

}
