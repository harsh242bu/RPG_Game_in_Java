// An abstraction of attack - used by hero and monster both to attack
public class Attack {
    private int attribute;
    private int value;

    Attack(int attribute, int value){
        this.attribute = attribute;
        this.value = value * (-1);
    }

    public int getAttribute() {
        return attribute;
    }

    // new changes

    public void setAttribute(int attribute) {
        this.attribute = attribute;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
