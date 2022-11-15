// Potion class
import java.util.List;

public class Potion extends Item {
    int attrIncrease;
    List<Integer> attrAffected;

    Potion(String name, int cost, int reqLevel, int attrIncrease, List<Integer> attrAffected){
        super(name, cost, reqLevel);
        this.attrIncrease = attrIncrease;
        this.attrAffected = attrAffected;
    }

    public int getAttrIncrease() {
        return attrIncrease;
    }

    public void setAttrIncrease(int attrIncrease) {
        this.attrIncrease = attrIncrease;
    }

    public List<Integer> getAttrAffected() {
        return attrAffected;
    }

    public void setAttrAffected(List<Integer> attrAffected) {
        this.attrAffected = attrAffected;
    }

    public void getHeader(){
//        Name/cost/required level/attribute increase/attribute affected
        System.out.println("Name\tCost\tLevel\tAttribute increase\tCategory");
    }

    public String printAttributesAffected(){
        String str = "";
        for(int attr: getAttrAffected()){
            str = Utility.printAttribute(attr) + " ";
        }
        return str;
    }

    @Override
    public void printItem(){
        System.out.println(getName() +"\t" + getCost() + "\t" + getReqLevel() + "\t" + getAttrIncrease() +
                "\t" + printAttributesAffected());
    }
}
