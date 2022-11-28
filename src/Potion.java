// Potion class

import java.util.ArrayList;
import java.util.List;

public class Potion extends Item {
    int attrIncrease;
    List<Integer> attrAffected;

    Potion(String name, int cost, int reqLevel, int attrIncrease, List<Integer> attrAffected) {
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

    @Override
    public Potion clone() {
        Potion potion = null;
        try{
            potion = (Potion) super.clone();
        }
        catch(Exception e){
            potion = new Potion(getName(), getCost(), getReqLevel(), getAttrIncrease(), getAttrAffected());
            potion.attrAffected = new ArrayList<Integer>();
            for(int attr: getAttrAffected()){
                potion.attrAffected.add(attr);
            }

        }
        return potion;
    }

    public void getHeader() {
//        Name/cost/required level/attribute increase/attribute affected
//        System.out.println("Name\tCost\tLevel\tAttribute increase\tCategory");
        String output = String.format("%-4s %-17s %-10s %-18s %-30s %-10s", "No.", "Name", "Cost", "Required Level", "Attribute Increased", "Category");
        System.out.println(output);
    }


    public String printAttributesAffected() {
        String str = "";
        for (int attr : getAttrAffected()) {
            str += Utility.printAttribute(attr) + " ";
        }
        return str;
    }

    @Override
    public void printItem() {
//        System.out.println(getName() +"\t" + getCost() + "\t" + getReqLevel() + "\t" + getAttrIncrease() +
//                "\t" + printAttributesAffected());
        String output = String.format(" %-17s %-10s %-18s %-30s %-10s", getName(), getCost(), getReqLevel(), getAttrIncrease(), printAttributesAffected());

        System.out.println(output);
    }
}
